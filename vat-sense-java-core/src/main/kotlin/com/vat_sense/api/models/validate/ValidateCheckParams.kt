// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.validate

import com.vat_sense.api.core.Params
import com.vat_sense.api.core.http.Headers
import com.vat_sense.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Check whether a given VAT number or EORI number is valid against live government records.
 *
 * **VAT validation** checks against UK (HMRC), EU (VIES), Australia, Norway, Switzerland, South
 * Africa, and Brazil records.
 *
 * **EORI validation** checks against UK and EU records only.
 *
 * If the external validation service is temporarily unavailable, the API returns a `412` error and
 * the request does not count against your usage quota.
 *
 * Provide either `vat_number` or `eori_number`, but not both.
 */
class ValidateCheckParams
private constructor(
    private val eoriNumber: String?,
    private val requesterVatNumber: String?,
    private val vatNumber: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The EORI number to validate. Must include the leading 2-character country code (e.g.
     * "GB123456789123"). UK and EU only.
     */
    fun eoriNumber(): Optional<String> = Optional.ofNullable(eoriNumber)

    /**
     * Your own VAT number. If supplied, the response will include a unique consultation number
     * issued by the relevant authority (VIES or HMRC). Must include the leading 2-character country
     * code.
     *
     * Note: GB requester numbers only work for GB validations; EU requester numbers only work for
     * EU validations. Cross-region is not supported.
     */
    fun requesterVatNumber(): Optional<String> = Optional.ofNullable(requesterVatNumber)

    /**
     * The VAT number to validate. Must include the leading 2-character country code (e.g.
     * "GB288305674", "FR12345678901").
     */
    fun vatNumber(): Optional<String> = Optional.ofNullable(vatNumber)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ValidateCheckParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ValidateCheckParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ValidateCheckParams]. */
    class Builder internal constructor() {

        private var eoriNumber: String? = null
        private var requesterVatNumber: String? = null
        private var vatNumber: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(validateCheckParams: ValidateCheckParams) = apply {
            eoriNumber = validateCheckParams.eoriNumber
            requesterVatNumber = validateCheckParams.requesterVatNumber
            vatNumber = validateCheckParams.vatNumber
            additionalHeaders = validateCheckParams.additionalHeaders.toBuilder()
            additionalQueryParams = validateCheckParams.additionalQueryParams.toBuilder()
        }

        /**
         * The EORI number to validate. Must include the leading 2-character country code (e.g.
         * "GB123456789123"). UK and EU only.
         */
        fun eoriNumber(eoriNumber: String?) = apply { this.eoriNumber = eoriNumber }

        /** Alias for calling [Builder.eoriNumber] with `eoriNumber.orElse(null)`. */
        fun eoriNumber(eoriNumber: Optional<String>) = eoriNumber(eoriNumber.getOrNull())

        /**
         * Your own VAT number. If supplied, the response will include a unique consultation number
         * issued by the relevant authority (VIES or HMRC). Must include the leading 2-character
         * country code.
         *
         * Note: GB requester numbers only work for GB validations; EU requester numbers only work
         * for EU validations. Cross-region is not supported.
         */
        fun requesterVatNumber(requesterVatNumber: String?) = apply {
            this.requesterVatNumber = requesterVatNumber
        }

        /**
         * Alias for calling [Builder.requesterVatNumber] with `requesterVatNumber.orElse(null)`.
         */
        fun requesterVatNumber(requesterVatNumber: Optional<String>) =
            requesterVatNumber(requesterVatNumber.getOrNull())

        /**
         * The VAT number to validate. Must include the leading 2-character country code (e.g.
         * "GB288305674", "FR12345678901").
         */
        fun vatNumber(vatNumber: String?) = apply { this.vatNumber = vatNumber }

        /** Alias for calling [Builder.vatNumber] with `vatNumber.orElse(null)`. */
        fun vatNumber(vatNumber: Optional<String>) = vatNumber(vatNumber.getOrNull())

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
         * Returns an immutable instance of [ValidateCheckParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ValidateCheckParams =
            ValidateCheckParams(
                eoriNumber,
                requesterVatNumber,
                vatNumber,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                eoriNumber?.let { put("eori_number", it) }
                requesterVatNumber?.let { put("requester_vat_number", it) }
                vatNumber?.let { put("vat_number", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ValidateCheckParams &&
            eoriNumber == other.eoriNumber &&
            requesterVatNumber == other.requesterVatNumber &&
            vatNumber == other.vatNumber &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            eoriNumber,
            requesterVatNumber,
            vatNumber,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "ValidateCheckParams{eoriNumber=$eoriNumber, requesterVatNumber=$requesterVatNumber, vatNumber=$vatNumber, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
