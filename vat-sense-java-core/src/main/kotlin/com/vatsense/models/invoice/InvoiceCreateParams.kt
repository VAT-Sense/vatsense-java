// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice

import com.vatsense.core.JsonValue
import com.vatsense.core.Params
import com.vatsense.core.checkRequired
import com.vatsense.core.http.Headers
import com.vatsense.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a new VAT-compliant invoice. VAT Sense will automatically calculate the totals based on
 * the items provided.
 *
 * Not available with sandbox API keys.
 *
 * Set [Builder.idempotencyKey] to retry a create safely: a repeat with the same key and the same
 * body, byte for byte, creates nothing and returns the invoice the first request made.
 */
class InvoiceCreateParams
private constructor(
    private val createInvoice: CreateInvoice,
    private val idempotencyKey: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun createInvoice(): CreateInvoice = createInvoice

    /**
     * Sent as the `Idempotency-Key` header to retry a create safely: a repeat with the same key and
     * the same body, byte for byte, creates nothing and returns the invoice the first request made.
     * The same key with a different body gets `422` "Idempotency Key Reused".
     */
    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    fun _additionalBodyProperties(): Map<String, JsonValue> = createInvoice._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvoiceCreateParams].
         *
         * The following fields are required:
         * ```java
         * .createInvoice()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvoiceCreateParams]. */
    class Builder internal constructor() {

        private var createInvoice: CreateInvoice? = null
        private var idempotencyKey: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(invoiceCreateParams: InvoiceCreateParams) = apply {
            createInvoice = invoiceCreateParams.createInvoice
            idempotencyKey = invoiceCreateParams.idempotencyKey
            additionalHeaders = invoiceCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = invoiceCreateParams.additionalQueryParams.toBuilder()
        }

        fun createInvoice(createInvoice: CreateInvoice) = apply {
            this.createInvoice = createInvoice
        }

        /**
         * Sent as the `Idempotency-Key` header to retry a create safely. 1 to 255 characters,
         * unique to this invoice (such as your order number or a UUID).
         */
        fun idempotencyKey(idempotencyKey: String?) = apply { this.idempotencyKey = idempotencyKey }

        /** Alias for calling [Builder.idempotencyKey] with `idempotencyKey.orElse(null)`. */
        fun idempotencyKey(idempotencyKey: Optional<String>) =
            idempotencyKey(idempotencyKey.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [InvoiceCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .createInvoice()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InvoiceCreateParams =
            InvoiceCreateParams(
                checkRequired("createInvoice", createInvoice),
                idempotencyKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): CreateInvoice = createInvoice

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                idempotencyKey?.let { put("Idempotency-Key", it) }
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvoiceCreateParams &&
            createInvoice == other.createInvoice &&
            idempotencyKey == other.idempotencyKey &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(createInvoice, idempotencyKey, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InvoiceCreateParams{createInvoice=$createInvoice, idempotencyKey=$idempotencyKey, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
