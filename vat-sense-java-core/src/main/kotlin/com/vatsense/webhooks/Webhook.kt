// Checking the signature of VAT Sense webhook events.

package com.vatsense.webhooks

import com.fasterxml.jackson.core.JacksonException
import com.fasterxml.jackson.databind.JsonNode
import com.vatsense.core.jsonMapper
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.time.Duration
import java.time.Instant
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import kotlin.math.abs

/**
 * Checks the `VatSense-Signature` header of webhook events.
 *
 * Every event is a signed JSON `POST` with a header such as `t=1793365200,v1=5257a8...`: `v1` is
 * the hex HMAC-SHA256 of the timestamp, a full stop and the raw request body, keyed with the
 * endpoint's signing secret (`whsec_...`). For 24 hours after a secret is rolled the header carries
 * a second `v1`, so any match is accepted.
 *
 * ```java
 * JsonNode event = Webhook.constructEvent(rawBody, request.getHeader(Webhook.SIGNATURE_HEADER), secret);
 * ```
 */
object Webhook {

    /** The name of the header that carries the signature. */
    const val SIGNATURE_HEADER: String = "VatSense-Signature"

    /** Events whose timestamp is further than this from now are refused. */
    @JvmField val DEFAULT_TOLERANCE: Duration = Duration.ofMinutes(5)

    /**
     * Checks an event's signature header against its raw body, exactly as received.
     *
     * @param tolerance refuse events signed longer ago than this; `null` skips the check
     * @param now the current time, for tests
     * @throws WebhookSignatureException when the event does not verify
     */
    @JvmStatic
    @JvmOverloads
    fun verifySignature(
        payload: String,
        header: String?,
        secret: String,
        tolerance: Duration? = DEFAULT_TOLERANCE,
        now: Instant = Instant.now(),
    ) {
        if (header.isNullOrEmpty()) {
            throw WebhookSignatureException("The VatSense-Signature header is missing.")
        }
        if (secret.isEmpty()) {
            throw WebhookSignatureException("No signing secret was given.")
        }

        var timestamp: Long? = null
        val signatures = mutableListOf<String>()
        for (part in header.split(",")) {
            val index = part.indexOf('=')
            if (index < 0) continue
            val key = part.substring(0, index).trim()
            val value = part.substring(index + 1).trim()
            when (key) {
                "t" ->
                    timestamp =
                        value.takeIf { it.isNotEmpty() && it.all(Char::isDigit) }?.toLongOrNull()
                            ?: throw WebhookSignatureException(
                                "The signature header's timestamp is not a number."
                            )
                "v1" -> if (value.isNotEmpty()) signatures.add(value)
            }
        }
        val signedAt =
            timestamp ?: throw WebhookSignatureException("The signature header has no timestamp.")
        if (signatures.isEmpty()) {
            throw WebhookSignatureException("The signature header has no v1 signature.")
        }
        if (tolerance != null && abs(now.epochSecond - signedAt) > tolerance.seconds) {
            throw WebhookSignatureException("The event's timestamp is outside the tolerance.")
        }

        val mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(secret.toByteArray(StandardCharsets.UTF_8), "HmacSHA256"))
        val digest = mac.doFinal("$signedAt.$payload".toByteArray(StandardCharsets.UTF_8))
        val expected =
            digest.joinToString("") { "%02x".format(it) }.toByteArray(StandardCharsets.US_ASCII)
        if (
            signatures.none {
                MessageDigest.isEqual(expected, it.toByteArray(StandardCharsets.US_ASCII))
            }
        ) {
            throw WebhookSignatureException("No signature matches the payload.")
        }
    }

    /**
     * Checks the signature with [verifySignature], then parses the event (`id`, `type`, `created`,
     * `livemode`, `data`).
     *
     * @throws WebhookSignatureException when the event does not verify
     */
    @JvmStatic
    @JvmOverloads
    fun constructEvent(
        payload: String,
        header: String?,
        secret: String,
        tolerance: Duration? = DEFAULT_TOLERANCE,
        now: Instant = Instant.now(),
    ): JsonNode {
        verifySignature(payload, header, secret, tolerance, now)
        val event =
            try {
                jsonMapper().readTree(payload)
            } catch (e: JacksonException) {
                throw WebhookSignatureException("The payload is not JSON.")
            }
        if (event == null || !event.isObject) {
            throw WebhookSignatureException("The payload is not a JSON object.")
        }
        return event
    }
}
