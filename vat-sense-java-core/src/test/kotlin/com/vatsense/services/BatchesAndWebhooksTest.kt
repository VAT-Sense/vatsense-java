package com.vatsense.services

import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.delete
import com.github.tomakehurst.wiremock.client.WireMock.deleteRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.equalToJson
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.vatsense.client.VatSenseClient
import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import com.vatsense.models.batches.BatchContinueParams
import com.vatsense.models.batches.BatchCreateParams
import com.vatsense.models.batches.BatchListParams
import com.vatsense.models.batches.BatchResultsParams
import com.vatsense.models.batches.BatchRow
import com.vatsense.models.batches.BatchShortfall
import com.vatsense.models.batches.BatchStartParams
import com.vatsense.models.validate.ValidateCheckParams
import com.vatsense.webhooks.Webhook
import com.vatsense.webhooks.WebhookSignatureException
import java.time.Instant
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

/** Batches, consultation_optional, confirmation_number and webhook signatures, sent to WireMock. */
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class BatchesAndWebhooksTest {

    private val id = "01JM0000000000000000000000"
    private val batch =
        """{"object":"batch","id":"$id","number":4,"status":"processing","livemode":true,"rows":{"total":2,"to_check":2,"done":1},"quote":null}"""
    private val envelope = """{"success":true,"code":200,"data":$batch}"""

    private lateinit var client: VatSenseClient
    private lateinit var baseUrl: String

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        baseUrl = wmRuntimeInfo.httpBaseUrl
        client =
            VatSenseOkHttpClient.builder().baseUrl(baseUrl).username("user").password("key").build()
    }

    @Test
    fun createSendsBodyAndIdempotencyKey() {
        stubFor(post(urlPathEqualTo("/batches")).willReturn(okJson(envelope)))

        val created =
            client
                .batches()
                .create(
                    BatchCreateParams.builder()
                        .rows(
                            listOf(
                                BatchRow.builder()
                                    .vatNumber("GB288305674")
                                    .companyName("Weio Ltd")
                                    .build()
                            )
                        )
                        .shortfall(BatchShortfall.PAUSE)
                        .autoContinue(false)
                        .idempotencyKey("nov-1")
                        .build()
                )

        verify(
            postRequestedFor(urlPathEqualTo("/batches"))
                .withHeader("Idempotency-Key", equalTo("nov-1"))
                .withRequestBody(
                    equalToJson(
                        """{"rows":[{"vat_number":"GB288305674","company_name":"Weio Ltd"}],"shortfall":"pause","auto_continue":false}"""
                    )
                )
        )
        assertThat(created.data().id()).isEqualTo(id)
        assertThat(created.data().rows().get().done()).contains(1L)
        assertThat(created.data().quote()).isEmpty
    }

    @Test
    fun everyActionCallsItsPath() {
        stubFor(get(anyUrl()).willReturn(okJson(envelope)))
        stubFor(post(anyUrl()).willReturn(okJson(envelope)))

        client.batches().retrieve(id)
        client
            .batches()
            .start(id, BatchStartParams.builder().shortfall(BatchShortfall.OVERAGE).build())
        client.batches().pause(id)
        client.batches().continueBatch(id, BatchContinueParams.none())
        client.batches().complete(id)

        verify(getRequestedFor(urlEqualTo("/batches/$id")))
        verify(
            postRequestedFor(urlEqualTo("/batches/$id/start"))
                .withRequestBody(equalToJson("""{"shortfall":"overage"}"""))
        )
        verify(postRequestedFor(urlEqualTo("/batches/$id/pause")))
        verify(postRequestedFor(urlEqualTo("/batches/$id/continue")))
        verify(postRequestedFor(urlEqualTo("/batches/$id/complete")))
        assertThatThrownBy { client.batches().retrieve("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun listResultsDeleteAndCsv() {
        stubFor(
            get(urlPathEqualTo("/batches"))
                .willReturn(
                    okJson(
                        """{"success":true,"code":200,"data":{"data":[$batch],"page":2,"limit":10,"total":11,"has_more":false}}"""
                    )
                )
        )
        stubFor(
            get(urlPathEqualTo("/batches/$id/results"))
                .willReturn(
                    okJson(
                        """{"success":true,"code":200,"data":{"data":[{"row":1,"vat_number":"GB288305674","result":"valid","confirmation_number":null}],"has_more":true,"next_after":1}}"""
                    )
                )
        )
        stubFor(
            delete(urlPathEqualTo("/batches/$id"))
                .willReturn(
                    okJson(
                        """{"success":true,"code":200,"data":{"object":"batch","id":"$id","deleted":true}}"""
                    )
                )
        )
        stubFor(
            get(urlPathEqualTo("/batches/$id/results.csv"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "text/csv")
                        .withBody("row,vat_number\n1,GB288305674\n")
                )
        )

        val page = client.batches().list(BatchListParams.builder().page(2).limit(10).build())
        verify(getRequestedFor(urlEqualTo("/batches?page=2&limit=10")))
        assertThat(page.data().total()).contains(11L)
        assertThat(page.data().data()[0].id()).isEqualTo(id)

        val results =
            client.batches().results(id, BatchResultsParams.builder().after(0).limit(1).build())
        assertThat(results.data().hasMore()).isTrue
        assertThat(results.data().nextAfter()).contains(1L)
        assertThat(results.data().data()[0].result()).contains("valid")
        assertThat(results.data().data()[0].confirmationNumber()).isEmpty

        assertThat(client.batches().delete(id).data().deleted()).isTrue
        verify(deleteRequestedFor(urlEqualTo("/batches/$id")))

        assertThat(client.batches().resultsCsv(id)).isEqualTo("row,vat_number\n1,GB288305674\n")
    }

    @Test
    fun asyncCreate() {
        stubFor(post(urlPathEqualTo("/batches")).willReturn(okJson(envelope)))
        val async =
            VatSenseOkHttpClientAsync.builder()
                .baseUrl(baseUrl)
                .username("user")
                .password("key")
                .build()

        val created =
            async
                .batches()
                .create(BatchCreateParams.builder().numbers(listOf("GB288305674")).build())
                .get()

        verify(
            postRequestedFor(urlPathEqualTo("/batches"))
                .withRequestBody(equalToJson("""{"numbers":["GB288305674"]}"""))
        )
        assertThat(created.data().livemode()).contains(true)
    }

    @Test
    fun validateConsultationOptionalAndConfirmationNumber() {
        stubFor(
            get(urlPathEqualTo("/validate"))
                .willReturn(
                    okJson(
                        """{"success":true,"code":200,"data":{"valid":true,"confirmation_number":"VSC-ABC"}}"""
                    )
                )
        )

        val result =
            client
                .validate()
                .check(
                    ValidateCheckParams.builder()
                        .vatNumber("FR40303265045")
                        .requesterVatNumber("GB288305674")
                        .consultationOptional(true)
                        .build()
                )

        verify(
            getRequestedFor(urlPathEqualTo("/validate"))
                .withQueryParam("consultation_optional", equalTo("true"))
        )
        assertThat(result.data().get().confirmationNumber()).contains("VSC-ABC")
    }

    private val secret = "whsec_test_secret"
    private val payload =
        """{"id":"evt_1","type":"batch.completed","created":1793365200,"livemode":true,"data":{"object":{"object":"batch"}}}"""

    private fun sign(timestamp: Long, body: String, key: String = secret): String {
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(key.toByteArray(), "HmacSHA256"))
        return mac.doFinal("$timestamp.$body".toByteArray()).joinToString("") { "%02x".format(it) }
    }

    @Test
    fun webhookAcceptsAGoodEventAndTheOldSecretDuringARoll() {
        val event =
            Webhook.constructEvent(
                payload,
                "t=1793365200,v1=${sign(1793365200, payload)}",
                secret,
                now = Instant.ofEpochSecond(1793365260),
            )
        assertThat(event.get("type").asText()).isEqualTo("batch.completed")

        Webhook.verifySignature(
            payload,
            "t=1793365200,v1=${sign(1793365200, payload, "whsec_new")},v1=${sign(1793365200, payload)}",
            secret,
            now = Instant.ofEpochSecond(1793365200),
        )
    }

    @Test
    fun webhookRefusesBadEvents() {
        val cases =
            listOf(
                null to 1793365200L,
                "" to 1793365200L,
                "v1=abc" to 1793365200L,
                "t=1793365200" to 1793365200L,
                "t=soon,v1=abc" to 1793365200L,
                "t=1793365200,v1=${sign(1793365200, payload, "whsec_other")}" to 1793365200L,
                "t=1793365200,v1=${sign(1793365200, payload)}" to 1793365200L + 301,
            )
        for ((header, now) in cases) {
            assertThatThrownBy {
                    Webhook.verifySignature(
                        payload,
                        header,
                        secret,
                        now = Instant.ofEpochSecond(now),
                    )
                }
                .isInstanceOf(WebhookSignatureException::class.java)
        }
        assertThatThrownBy {
                Webhook.verifySignature(
                    payload.replace("true", "false"),
                    "t=1793365200,v1=${sign(1793365200, payload)}",
                    secret,
                    now = Instant.ofEpochSecond(1793365200),
                )
            }
            .isInstanceOf(WebhookSignatureException::class.java)
    }
}
