// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.currency

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.Enum
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class VatPrice
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val object_: JsonField<Object>,
    private val price: JsonField<Double>,
    private val priceExclVat: JsonField<Double>,
    private val priceInclVat: JsonField<Double>,
    private val taxType: JsonField<TaxType>,
    private val vat: JsonField<Double>,
    private val vatRate: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("price") @ExcludeMissing price: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("price_excl_vat")
        @ExcludeMissing
        priceExclVat: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("price_incl_vat")
        @ExcludeMissing
        priceInclVat: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tax_type") @ExcludeMissing taxType: JsonField<TaxType> = JsonMissing.of(),
        @JsonProperty("vat") @ExcludeMissing vat: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("vat_rate") @ExcludeMissing vatRate: JsonField<Double> = JsonMissing.of(),
    ) : this(object_, price, priceExclVat, priceInclVat, taxType, vat, vatRate, mutableMapOf())

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * The price provided.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun price(): Optional<Double> = price.getOptional("price")

    /**
     * The calculated price exclusive of VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun priceExclVat(): Optional<Double> = priceExclVat.getOptional("price_excl_vat")

    /**
     * The calculated price inclusive of VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun priceInclVat(): Optional<Double> = priceInclVat.getOptional("price_incl_vat")

    /**
     * Whether the price is inclusive or exclusive of VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxType(): Optional<TaxType> = taxType.getOptional("tax_type")

    /**
     * The total VAT amount.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vat(): Optional<Double> = vat.getOptional("vat")

    /**
     * The VAT rate percentage.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vatRate(): Optional<Double> = vatRate.getOptional("vat_rate")

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [price].
     *
     * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Double> = price

    /**
     * Returns the raw JSON value of [priceExclVat].
     *
     * Unlike [priceExclVat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price_excl_vat")
    @ExcludeMissing
    fun _priceExclVat(): JsonField<Double> = priceExclVat

    /**
     * Returns the raw JSON value of [priceInclVat].
     *
     * Unlike [priceInclVat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price_incl_vat")
    @ExcludeMissing
    fun _priceInclVat(): JsonField<Double> = priceInclVat

    /**
     * Returns the raw JSON value of [taxType].
     *
     * Unlike [taxType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_type") @ExcludeMissing fun _taxType(): JsonField<TaxType> = taxType

    /**
     * Returns the raw JSON value of [vat].
     *
     * Unlike [vat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vat") @ExcludeMissing fun _vat(): JsonField<Double> = vat

    /**
     * Returns the raw JSON value of [vatRate].
     *
     * Unlike [vatRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vat_rate") @ExcludeMissing fun _vatRate(): JsonField<Double> = vatRate

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [VatPrice]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VatPrice]. */
    class Builder internal constructor() {

        private var object_: JsonField<Object> = JsonMissing.of()
        private var price: JsonField<Double> = JsonMissing.of()
        private var priceExclVat: JsonField<Double> = JsonMissing.of()
        private var priceInclVat: JsonField<Double> = JsonMissing.of()
        private var taxType: JsonField<TaxType> = JsonMissing.of()
        private var vat: JsonField<Double> = JsonMissing.of()
        private var vatRate: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(vatPrice: VatPrice) = apply {
            object_ = vatPrice.object_
            price = vatPrice.price
            priceExclVat = vatPrice.priceExclVat
            priceInclVat = vatPrice.priceInclVat
            taxType = vatPrice.taxType
            vat = vatPrice.vat
            vatRate = vatPrice.vatRate
            additionalProperties = vatPrice.additionalProperties.toMutableMap()
        }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The price provided. */
        fun price(price: Double) = price(JsonField.of(price))

        /**
         * Sets [Builder.price] to an arbitrary JSON value.
         *
         * You should usually call [Builder.price] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun price(price: JsonField<Double>) = apply { this.price = price }

        /** The calculated price exclusive of VAT. */
        fun priceExclVat(priceExclVat: Double) = priceExclVat(JsonField.of(priceExclVat))

        /**
         * Sets [Builder.priceExclVat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.priceExclVat] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun priceExclVat(priceExclVat: JsonField<Double>) = apply {
            this.priceExclVat = priceExclVat
        }

        /** The calculated price inclusive of VAT. */
        fun priceInclVat(priceInclVat: Double) = priceInclVat(JsonField.of(priceInclVat))

        /**
         * Sets [Builder.priceInclVat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.priceInclVat] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun priceInclVat(priceInclVat: JsonField<Double>) = apply {
            this.priceInclVat = priceInclVat
        }

        /** Whether the price is inclusive or exclusive of VAT. */
        fun taxType(taxType: TaxType) = taxType(JsonField.of(taxType))

        /**
         * Sets [Builder.taxType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxType] with a well-typed [TaxType] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxType(taxType: JsonField<TaxType>) = apply { this.taxType = taxType }

        /** The total VAT amount. */
        fun vat(vat: Double) = vat(JsonField.of(vat))

        /**
         * Sets [Builder.vat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vat] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vat(vat: JsonField<Double>) = apply { this.vat = vat }

        /** The VAT rate percentage. */
        fun vatRate(vatRate: Double) = vatRate(JsonField.of(vatRate))

        /**
         * Sets [Builder.vatRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vatRate] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vatRate(vatRate: JsonField<Double>) = apply { this.vatRate = vatRate }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [VatPrice].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VatPrice =
            VatPrice(
                object_,
                price,
                priceExclVat,
                priceInclVat,
                taxType,
                vat,
                vatRate,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws VatSenseInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): VatPrice = apply {
        if (validated) {
            return@apply
        }

        object_().ifPresent { it.validate() }
        price()
        priceExclVat()
        priceInclVat()
        taxType().ifPresent { it.validate() }
        vat()
        vatRate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (price.asKnown().isPresent) 1 else 0) +
            (if (priceExclVat.asKnown().isPresent) 1 else 0) +
            (if (priceInclVat.asKnown().isPresent) 1 else 0) +
            (taxType.asKnown().getOrNull()?.validity() ?: 0) +
            (if (vat.asKnown().isPresent) 1 else 0) +
            (if (vatRate.asKnown().isPresent) 1 else 0)

    class Object @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val VAT_PRICE = of("vat_price")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            VAT_PRICE
        }

        /**
         * An enum containing [Object]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Object] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            VAT_PRICE,
            /** An enum member indicating that [Object] was instantiated with an unknown value. */
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
                VAT_PRICE -> Value.VAT_PRICE
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
                VAT_PRICE -> Known.VAT_PRICE
                else -> throw VatSenseInvalidDataException("Unknown Object: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws VatSenseInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Object = apply {
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

            return other is Object && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Whether the price is inclusive or exclusive of VAT. */
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws VatSenseInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

        return other is VatPrice &&
            object_ == other.object_ &&
            price == other.price &&
            priceExclVat == other.priceExclVat &&
            priceInclVat == other.priceInclVat &&
            taxType == other.taxType &&
            vat == other.vat &&
            vatRate == other.vatRate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            object_,
            price,
            priceExclVat,
            priceInclVat,
            taxType,
            vat,
            vatRate,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VatPrice{object_=$object_, price=$price, priceExclVat=$priceExclVat, priceInclVat=$priceInclVat, taxType=$taxType, vat=$vat, vatRate=$vatRate, additionalProperties=$additionalProperties}"
}
