// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

import com.vatsense.core.Params
import com.vatsense.core.http.Headers
import com.vatsense.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns a list of all countries, including whether they are subject to VAT/GST and whether they
 * are subject to EU VAT. Each country is returned as a country object.
 *
 * You can optionally filter by country code or IP address.
 */
class CountryListParams
private constructor(
    private val countryCode: String?,
    private val ipAddress: String?,
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

    /** An IPv4 or IPv6 address. If provided, the country will be determined from the IP address. */
    fun ipAddress(): Optional<String> = Optional.ofNullable(ipAddress)

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CountryListParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [CountryListParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CountryListParams]. */
    class Builder internal constructor() {

        private var countryCode: String? = null
        private var ipAddress: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(countryListParams: CountryListParams) = apply {
            countryCode = countryListParams.countryCode
            ipAddress = countryListParams.ipAddress
            additionalHeaders = countryListParams.additionalHeaders.toBuilder()
            additionalQueryParams = countryListParams.additionalQueryParams.toBuilder()
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

        /**
         * An IPv4 or IPv6 address. If provided, the country will be determined from the IP address.
         */
        fun ipAddress(ipAddress: String?) = apply { this.ipAddress = ipAddress }

        /** Alias for calling [Builder.ipAddress] with `ipAddress.orElse(null)`. */
        fun ipAddress(ipAddress: Optional<String>) = ipAddress(ipAddress.getOrNull())

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
         * Returns an immutable instance of [CountryListParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CountryListParams =
            CountryListParams(
                countryCode,
                ipAddress,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                countryCode?.let { put("country_code", it) }
                ipAddress?.let { put("ip_address", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CountryListParams &&
            countryCode == other.countryCode &&
            ipAddress == other.ipAddress &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(countryCode, ipAddress, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CountryListParams{countryCode=$countryCode, ipAddress=$ipAddress, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
