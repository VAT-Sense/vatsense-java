// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.vatsense.core.Params
import com.vatsense.core.http.Headers
import com.vatsense.core.http.QueryParams
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns a list of VAT/GST rates for all countries, sorted alphabetically by country code. Each
 * rate is returned as a rate object containing the standard rate and any other applicable rates.
 *
 * You can optionally filter by country code, IP address, or EU membership.
 */
class RateListParams
private constructor(
    private val countryCode: String?,
    private val eu: Boolean?,
    private val ipAddress: String?,
    private val period: OffsetDateTime?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** A 2-character ISO 3166-1 alpha-2 country code (e.g. "GB", "FR"). */
    fun countryCode(): Optional<String> = Optional.ofNullable(countryCode)

    /** Filter results by EU membership. Use 1 for EU countries only, 0 for non-EU only. */
    fun eu(): Optional<Boolean> = Optional.ofNullable(eu)

    /** An IPv4 or IPv6 address. If provided, the country will be determined from the IP address. */
    fun ipAddress(): Optional<String> = Optional.ofNullable(ipAddress)

    /**
     * A historical date to retrieve rates for (format "YYYY-MM-DD HH:MM:SS"). Must be a past date.
     */
    fun period(): Optional<OffsetDateTime> = Optional.ofNullable(period)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): RateListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [RateListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateListParams]. */
    class Builder internal constructor() {

        private var countryCode: String? = null
        private var eu: Boolean? = null
        private var ipAddress: String? = null
        private var period: OffsetDateTime? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(rateListParams: RateListParams) = apply {
            countryCode = rateListParams.countryCode
            eu = rateListParams.eu
            ipAddress = rateListParams.ipAddress
            period = rateListParams.period
            additionalHeaders = rateListParams.additionalHeaders.toBuilder()
            additionalQueryParams = rateListParams.additionalQueryParams.toBuilder()
        }

        /** A 2-character ISO 3166-1 alpha-2 country code (e.g. "GB", "FR"). */
        fun countryCode(countryCode: String?) = apply { this.countryCode = countryCode }

        /** Alias for calling [Builder.countryCode] with `countryCode.orElse(null)`. */
        fun countryCode(countryCode: Optional<String>) = countryCode(countryCode.getOrNull())

        /** Filter results by EU membership. Use 1 for EU countries only, 0 for non-EU only. */
        fun eu(eu: Boolean?) = apply { this.eu = eu }

        /**
         * Alias for [Builder.eu].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun eu(eu: Boolean) = eu(eu as Boolean?)

        /** Alias for calling [Builder.eu] with `eu.orElse(null)`. */
        fun eu(eu: Optional<Boolean>) = eu(eu.getOrNull())

        /**
         * An IPv4 or IPv6 address. If provided, the country will be determined from the IP address.
         */
        fun ipAddress(ipAddress: String?) = apply { this.ipAddress = ipAddress }

        /** Alias for calling [Builder.ipAddress] with `ipAddress.orElse(null)`. */
        fun ipAddress(ipAddress: Optional<String>) = ipAddress(ipAddress.getOrNull())

        /**
         * A historical date to retrieve rates for (format "YYYY-MM-DD HH:MM:SS"). Must be a past
         * date.
         */
        fun period(period: OffsetDateTime?) = apply { this.period = period }

        /** Alias for calling [Builder.period] with `period.orElse(null)`. */
        fun period(period: Optional<OffsetDateTime>) = period(period.getOrNull())

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
         * Returns an immutable instance of [RateListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RateListParams =
            RateListParams(
                countryCode,
                eu,
                ipAddress,
                period,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                countryCode?.let { put("country_code", it) }
                eu?.let { put("eu", it.toString()) }
                ipAddress?.let { put("ip_address", it) }
                period?.let { put("period", DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(it)) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateListParams &&
            countryCode == other.countryCode &&
            eu == other.eu &&
            ipAddress == other.ipAddress &&
            period == other.period &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(countryCode, eu, ipAddress, period, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "RateListParams{countryCode=$countryCode, eu=$eu, ipAddress=$ipAddress, period=$period, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
