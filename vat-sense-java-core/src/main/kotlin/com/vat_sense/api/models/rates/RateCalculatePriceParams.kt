// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.fasterxml.jackson.annotation.JsonCreator
import com.vat_sense.api.core.Enum
import com.vat_sense.api.core.JsonField
import com.vat_sense.api.core.Params
import com.vat_sense.api.core.checkRequired
import com.vat_sense.api.core.http.Headers
import com.vat_sense.api.core.http.QueryParams
import com.vat_sense.api.errors.VatSenseInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Combines the functionality of the "Find a tax rate" and "VAT price calculation" endpoints to
 * return the particular VAT price for an applicable VAT rate. Requires both a location
 * (country_code or ip_address) and a price to calculate.
 */
class RateCalculatePriceParams
private constructor(
    private val price: String,
    private val taxType: TaxType,
    private val countryCode: String?,
    private val eu: Boolean?,
    private val ipAddress: String?,
    private val provinceCode: String?,
    private val type: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The price to calculate on. Must be a string with exactly 2 decimal places (e.g. "30.00",
     * "59.95").
     */
    fun price(): String = price

    /** Whether the provided price is inclusive or exclusive of VAT. */
    fun taxType(): TaxType = taxType

    /** A 2-character ISO 3166-1 alpha-2 country code (e.g. "GB", "FR"). */
    fun countryCode(): Optional<String> = Optional.ofNullable(countryCode)

    /** Filter results by EU membership. Use 1 for EU countries only, 0 for non-EU only. */
    fun eu(): Optional<Boolean> = Optional.ofNullable(eu)

    /** An IPv4 or IPv6 address. If provided, the country will be determined from the IP address. */
    fun ipAddress(): Optional<String> = Optional.ofNullable(ipAddress)

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

        /**
         * Returns a mutable builder for constructing an instance of [RateCalculatePriceParams].
         *
         * The following fields are required:
         * ```java
         * .price()
         * .taxType()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateCalculatePriceParams]. */
    class Builder internal constructor() {

        private var price: String? = null
        private var taxType: TaxType? = null
        private var countryCode: String? = null
        private var eu: Boolean? = null
        private var ipAddress: String? = null
        private var provinceCode: String? = null
        private var type: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(rateCalculatePriceParams: RateCalculatePriceParams) = apply {
            price = rateCalculatePriceParams.price
            taxType = rateCalculatePriceParams.taxType
            countryCode = rateCalculatePriceParams.countryCode
            eu = rateCalculatePriceParams.eu
            ipAddress = rateCalculatePriceParams.ipAddress
            provinceCode = rateCalculatePriceParams.provinceCode
            type = rateCalculatePriceParams.type
            additionalHeaders = rateCalculatePriceParams.additionalHeaders.toBuilder()
            additionalQueryParams = rateCalculatePriceParams.additionalQueryParams.toBuilder()
        }

        /**
         * The price to calculate on. Must be a string with exactly 2 decimal places (e.g. "30.00",
         * "59.95").
         */
        fun price(price: String) = apply { this.price = price }

        /** Whether the provided price is inclusive or exclusive of VAT. */
        fun taxType(taxType: TaxType) = apply { this.taxType = taxType }

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
         * Returns an immutable instance of [RateCalculatePriceParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .price()
         * .taxType()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RateCalculatePriceParams =
            RateCalculatePriceParams(
                checkRequired("price", price),
                checkRequired("taxType", taxType),
                countryCode,
                eu,
                ipAddress,
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
                put("price", price)
                put("tax_type", taxType.toString())
                countryCode?.let { put("country_code", it) }
                eu?.let { put("eu", it.toString()) }
                ipAddress?.let { put("ip_address", it) }
                provinceCode?.let { put("province_code", it) }
                type?.let { put("type", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** Whether the provided price is inclusive or exclusive of VAT. */
    class TaxType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val INCL = of("incl")

            @JvmField val EXCL = of("excl")

            @JvmStatic fun of(value: String) = TaxType(JsonField.of(value))
        }

        /** An enum containing [TaxType]'s known values. */
        enum class Known {
            INCL,
            EXCL,
        }

        /**
         * An enum containing [TaxType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [TaxType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            INCL,
            EXCL,
            /** An enum member indicating that [TaxType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                INCL -> Value.INCL
                EXCL -> Value.EXCL
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws VatSenseInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                INCL -> Known.INCL
                EXCL -> Known.EXCL
                else -> throw VatSenseInvalidDataException("Unknown TaxType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws VatSenseInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                VatSenseInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): TaxType = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: VatSenseInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TaxType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateCalculatePriceParams &&
            price == other.price &&
            taxType == other.taxType &&
            countryCode == other.countryCode &&
            eu == other.eu &&
            ipAddress == other.ipAddress &&
            provinceCode == other.provinceCode &&
            type == other.type &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(
            price,
            taxType,
            countryCode,
            eu,
            ipAddress,
            provinceCode,
            type,
            additionalHeaders,
            additionalQueryParams,
        )

    override fun toString() =
        "RateCalculatePriceParams{price=$price, taxType=$taxType, countryCode=$countryCode, eu=$eu, ipAddress=$ipAddress, provinceCode=$provinceCode, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
