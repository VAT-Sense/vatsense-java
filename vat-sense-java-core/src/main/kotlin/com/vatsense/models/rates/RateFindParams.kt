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
 * A handy endpoint for finding a rate that applies to a particular country and optional product
 * type, based on country code or IP address.
 *
 * If no type is provided, or no specific rate is applied to the given type, then the standard rate
 * will be returned if the country is subject to tax.
 *
 * If the country is not subject to VAT/GST then an error response will be returned, indicating no
 * tax applies.
 */
class RateFindParams
private constructor(
    private val countryCode: String?,
    private val eu: Boolean?,
    private val ipAddress: String?,
    private val period: OffsetDateTime?,
    private val provinceCode: String?,
    private val type: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A 2-character ISO 3166-1 alpha-2 country code (e.g. "GB", "FR"). Overseas territories that
     * carry their own ISO code but are modelled as provinces of a parent country (e.g. "NC" New
     * Caledonia, "MF" Saint Martin, "GP", "MQ", "RE", "PF", "GF", "YT", "BL", "PM", "WF" under
     * "FR") may be queried directly; the response identifies the territory and the rate is the one
     * the parent-plus-province query returns.
     */
    fun countryCode(): Optional<String> = Optional.ofNullable(countryCode)

    /** Filter results by EU membership. Use 1 for EU countries only, 0 for non-EU only. */
    fun eu(): Optional<Boolean> = Optional.ofNullable(eu)

    /** An IPv4 or IPv6 address. If provided, the country will be determined from the IP address. */
    fun ipAddress(): Optional<String> = Optional.ofNullable(ipAddress)

    /**
     * A historical date to retrieve rates for (format "YYYY-MM-DD HH:MM:SS"). Must be a past date.
     */
    fun period(): Optional<OffsetDateTime> = Optional.ofNullable(period)

    /**
     * A 2-character province code (e.g. "NU", "NT"). If providing a province code, you must also
     * provide the relevant country_code.
     */
    fun provinceCode(): Optional<String> = Optional.ofNullable(provinceCode)

    /**
     * The product type to find the applicable rate for. See the /rates/types endpoint for a full
     * list of valid values.
     */
    fun type(): Optional<String> = Optional.ofNullable(type)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): RateFindParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [RateFindParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateFindParams]. */
    class Builder internal constructor() {

        private var countryCode: String? = null
        private var eu: Boolean? = null
        private var ipAddress: String? = null
        private var period: OffsetDateTime? = null
        private var provinceCode: String? = null
        private var type: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(rateFindParams: RateFindParams) = apply {
            countryCode = rateFindParams.countryCode
            eu = rateFindParams.eu
            ipAddress = rateFindParams.ipAddress
            period = rateFindParams.period
            provinceCode = rateFindParams.provinceCode
            type = rateFindParams.type
            additionalHeaders = rateFindParams.additionalHeaders.toBuilder()
            additionalQueryParams = rateFindParams.additionalQueryParams.toBuilder()
        }

        /**
         * A 2-character ISO 3166-1 alpha-2 country code (e.g. "GB", "FR"). Overseas territories
         * that carry their own ISO code but are modelled as provinces of a parent country (e.g.
         * "NC" New Caledonia, "MF" Saint Martin, "GP", "MQ", "RE", "PF", "GF", "YT", "BL", "PM",
         * "WF" under "FR") may be queried directly; the response identifies the territory and the
         * rate is the one the parent-plus-province query returns.
         */
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

        /**
         * A 2-character province code (e.g. "NU", "NT"). If providing a province code, you must
         * also provide the relevant country_code.
         */
        fun provinceCode(provinceCode: String?) = apply { this.provinceCode = provinceCode }

        /** Alias for calling [Builder.provinceCode] with `provinceCode.orElse(null)`. */
        fun provinceCode(provinceCode: Optional<String>) = provinceCode(provinceCode.getOrNull())

        /**
         * The product type to find the applicable rate for. See the /rates/types endpoint for a
         * full list of valid values.
         */
        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

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
         * Returns an immutable instance of [RateFindParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RateFindParams =
            RateFindParams(
                countryCode,
                eu,
                ipAddress,
                period,
                provinceCode,
                type,
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
                provinceCode?.let { put("province_code", it) }
                type?.let { put("type", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateFindParams &&
            countryCode == other.countryCode &&
            eu == other.eu &&
            ipAddress == other.ipAddress &&
            period == other.period &&
            provinceCode == other.provinceCode &&
            type == other.type &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            countryCode,
            eu,
            ipAddress,
            period,
            provinceCode,
            type,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "RateFindParams{countryCode=$countryCode, eu=$eu, ipAddress=$ipAddress, period=$period, provinceCode=$provinceCode, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
