// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

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

class Country
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val countryCode: JsonField<String>,
    private val countryName: JsonField<String>,
    private val eu: JsonField<Boolean>,
    private val latitude: JsonField<Double>,
    private val longitude: JsonField<Double>,
    private val object_: JsonField<Object>,
    private val vat: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("country_code")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_name")
        @ExcludeMissing
        countryName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("eu") @ExcludeMissing eu: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("latitude") @ExcludeMissing latitude: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("longitude") @ExcludeMissing longitude: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("vat") @ExcludeMissing vat: JsonField<Boolean> = JsonMissing.of(),
    ) : this(countryCode, countryName, eu, latitude, longitude, object_, vat, mutableMapOf())

    /**
     * 2-character ISO 3166-1 alpha-2 country code.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun countryName(): Optional<String> = countryName.getOptional("country_name")

    /**
     * Whether the country is subject to EU VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eu(): Optional<Boolean> = eu.getOptional("eu")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun latitude(): Optional<Double> = latitude.getOptional("latitude")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun longitude(): Optional<Double> = longitude.getOptional("longitude")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * Whether the country is subject to VAT/GST.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vat(): Optional<Boolean> = vat.getOptional("vat")

    /**
     * Returns the raw JSON value of [countryCode].
     *
     * Unlike [countryCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country_code")
    @ExcludeMissing
    fun _countryCode(): JsonField<String> = countryCode

    /**
     * Returns the raw JSON value of [countryName].
     *
     * Unlike [countryName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("country_name")
    @ExcludeMissing
    fun _countryName(): JsonField<String> = countryName

    /**
     * Returns the raw JSON value of [eu].
     *
     * Unlike [eu], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("eu") @ExcludeMissing fun _eu(): JsonField<Boolean> = eu

    /**
     * Returns the raw JSON value of [latitude].
     *
     * Unlike [latitude], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("latitude") @ExcludeMissing fun _latitude(): JsonField<Double> = latitude

    /**
     * Returns the raw JSON value of [longitude].
     *
     * Unlike [longitude], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("longitude") @ExcludeMissing fun _longitude(): JsonField<Double> = longitude

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [vat].
     *
     * Unlike [vat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vat") @ExcludeMissing fun _vat(): JsonField<Boolean> = vat

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

        /** Returns a mutable builder for constructing an instance of [Country]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Country]. */
    class Builder internal constructor() {

        private var countryCode: JsonField<String> = JsonMissing.of()
        private var countryName: JsonField<String> = JsonMissing.of()
        private var eu: JsonField<Boolean> = JsonMissing.of()
        private var latitude: JsonField<Double> = JsonMissing.of()
        private var longitude: JsonField<Double> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var vat: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(country: Country) = apply {
            countryCode = country.countryCode
            countryName = country.countryName
            eu = country.eu
            latitude = country.latitude
            longitude = country.longitude
            object_ = country.object_
            vat = country.vat
            additionalProperties = country.additionalProperties.toMutableMap()
        }

        /** 2-character ISO 3166-1 alpha-2 country code. */
        fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

        /**
         * Sets [Builder.countryCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryCode(countryCode: JsonField<String>) = apply { this.countryCode = countryCode }

        fun countryName(countryName: String) = countryName(JsonField.of(countryName))

        /**
         * Sets [Builder.countryName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.countryName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun countryName(countryName: JsonField<String>) = apply { this.countryName = countryName }

        /** Whether the country is subject to EU VAT. */
        fun eu(eu: Boolean) = eu(JsonField.of(eu))

        /**
         * Sets [Builder.eu] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eu] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eu(eu: JsonField<Boolean>) = apply { this.eu = eu }

        fun latitude(latitude: Double) = latitude(JsonField.of(latitude))

        /**
         * Sets [Builder.latitude] to an arbitrary JSON value.
         *
         * You should usually call [Builder.latitude] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun latitude(latitude: JsonField<Double>) = apply { this.latitude = latitude }

        fun longitude(longitude: Double) = longitude(JsonField.of(longitude))

        /**
         * Sets [Builder.longitude] to an arbitrary JSON value.
         *
         * You should usually call [Builder.longitude] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun longitude(longitude: JsonField<Double>) = apply { this.longitude = longitude }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** Whether the country is subject to VAT/GST. */
        fun vat(vat: Boolean) = vat(JsonField.of(vat))

        /**
         * Sets [Builder.vat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vat] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vat(vat: JsonField<Boolean>) = apply { this.vat = vat }

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
         * Returns an immutable instance of [Country].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Country =
            Country(
                countryCode,
                countryName,
                eu,
                latitude,
                longitude,
                object_,
                vat,
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
    fun validate(): Country = apply {
        if (validated) {
            return@apply
        }

        countryCode()
        countryName()
        eu()
        latitude()
        longitude()
        object_().ifPresent { it.validate() }
        vat()
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
        (if (countryCode.asKnown().isPresent) 1 else 0) +
            (if (countryName.asKnown().isPresent) 1 else 0) +
            (if (eu.asKnown().isPresent) 1 else 0) +
            (if (latitude.asKnown().isPresent) 1 else 0) +
            (if (longitude.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (vat.asKnown().isPresent) 1 else 0)

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

            @JvmField val COUNTRY = of("country")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            COUNTRY
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
            COUNTRY,
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
                COUNTRY -> Value.COUNTRY
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
                COUNTRY -> Known.COUNTRY
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Country &&
            countryCode == other.countryCode &&
            countryName == other.countryName &&
            eu == other.eu &&
            latitude == other.latitude &&
            longitude == other.longitude &&
            object_ == other.object_ &&
            vat == other.vat &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            countryCode,
            countryName,
            eu,
            latitude,
            longitude,
            object_,
            vat,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Country{countryCode=$countryCode, countryName=$countryName, eu=$eu, latitude=$latitude, longitude=$longitude, object_=$object_, vat=$vat, additionalProperties=$additionalProperties}"
}
