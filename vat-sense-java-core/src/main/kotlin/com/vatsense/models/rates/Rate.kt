// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.Enum
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.core.checkKnown
import com.vatsense.core.toImmutable
import com.vatsense.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Rate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val countryCode: JsonField<String>,
    private val countryName: JsonField<String>,
    private val eu: JsonField<Boolean>,
    private val object_: JsonField<Object>,
    private val other: JsonField<List<Other>>,
    private val standard: JsonField<TaxRate>,
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
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("other") @ExcludeMissing other: JsonField<List<Other>> = JsonMissing.of(),
        @JsonProperty("standard") @ExcludeMissing standard: JsonField<TaxRate> = JsonMissing.of(),
    ) : this(countryCode, countryName, eu, object_, other, standard, mutableMapOf())

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
     * Whether the country is an EU member.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun eu(): Optional<Boolean> = eu.getOptional("eu")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * A list of other tax rates. Null if no additional rates exist.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun other(): Optional<List<Other>> = other.getOptional("other")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun standard(): Optional<TaxRate> = standard.getOptional("standard")

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
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [other].
     *
     * Unlike [other], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("other") @ExcludeMissing fun _other(): JsonField<List<Other>> = other

    /**
     * Returns the raw JSON value of [standard].
     *
     * Unlike [standard], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("standard") @ExcludeMissing fun _standard(): JsonField<TaxRate> = standard

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

        /** Returns a mutable builder for constructing an instance of [Rate]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Rate]. */
    class Builder internal constructor() {

        private var countryCode: JsonField<String> = JsonMissing.of()
        private var countryName: JsonField<String> = JsonMissing.of()
        private var eu: JsonField<Boolean> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var other: JsonField<MutableList<Other>>? = null
        private var standard: JsonField<TaxRate> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(rate: Rate) = apply {
            countryCode = rate.countryCode
            countryName = rate.countryName
            eu = rate.eu
            object_ = rate.object_
            other = rate.other.map { it.toMutableList() }
            standard = rate.standard
            additionalProperties = rate.additionalProperties.toMutableMap()
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

        /** Whether the country is an EU member. */
        fun eu(eu: Boolean) = eu(JsonField.of(eu))

        /**
         * Sets [Builder.eu] to an arbitrary JSON value.
         *
         * You should usually call [Builder.eu] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun eu(eu: JsonField<Boolean>) = apply { this.eu = eu }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** A list of other tax rates. Null if no additional rates exist. */
        fun other(other: List<Other>?) = other(JsonField.ofNullable(other))

        /** Alias for calling [Builder.other] with `other.orElse(null)`. */
        fun other(other: Optional<List<Other>>) = other(other.getOrNull())

        /**
         * Sets [Builder.other] to an arbitrary JSON value.
         *
         * You should usually call [Builder.other] with a well-typed `List<Other>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun other(other: JsonField<List<Other>>) = apply {
            this.other = other.map { it.toMutableList() }
        }

        /**
         * Adds a single [Other] to [Builder.other].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addOther(other: Other) = apply {
            this.other =
                (this.other ?: JsonField.of(mutableListOf())).also {
                    checkKnown("other", it).add(other)
                }
        }

        fun standard(standard: TaxRate) = standard(JsonField.of(standard))

        /**
         * Sets [Builder.standard] to an arbitrary JSON value.
         *
         * You should usually call [Builder.standard] with a well-typed [TaxRate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun standard(standard: JsonField<TaxRate>) = apply { this.standard = standard }

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
         * Returns an immutable instance of [Rate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Rate =
            Rate(
                countryCode,
                countryName,
                eu,
                object_,
                (other ?: JsonMissing.of()).map { it.toImmutable() },
                standard,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Rate = apply {
        if (validated) {
            return@apply
        }

        countryCode()
        countryName()
        eu()
        object_().ifPresent { it.validate() }
        other().ifPresent { it.forEach { it.validate() } }
        standard().ifPresent { it.validate() }
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
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (other.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (standard.asKnown().getOrNull()?.validity() ?: 0)

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

            @JvmField val RATE = of("rate")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            RATE
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
            RATE,
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
                RATE -> Value.RATE
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
                RATE -> Known.RATE
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

    class Other
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val class_: JsonField<String>,
        private val description: JsonField<String>,
        private val object_: JsonField<TaxRate.Object>,
        private val rate: JsonField<Double>,
        private val types: JsonField<TaxRate.Types>,
        private val province: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("class") @ExcludeMissing class_: JsonField<String> = JsonMissing.of(),
            @JsonProperty("description")
            @ExcludeMissing
            description: JsonField<String> = JsonMissing.of(),
            @JsonProperty("object")
            @ExcludeMissing
            object_: JsonField<TaxRate.Object> = JsonMissing.of(),
            @JsonProperty("rate") @ExcludeMissing rate: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("types")
            @ExcludeMissing
            types: JsonField<TaxRate.Types> = JsonMissing.of(),
            @JsonProperty("province") @ExcludeMissing province: JsonField<String> = JsonMissing.of(),
        ) : this(class_, description, object_, rate, types, province, mutableMapOf())

        fun toTaxRate(): TaxRate =
            TaxRate.builder()
                .class_(class_)
                .description(description)
                .object_(object_)
                .rate(rate)
                .types(types)
                .build()

        /**
         * The rate class (e.g. "standard", "reduced", "zero").
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun class_(): Optional<String> = class_.getOptional("class")

        /**
         * A description of what goods/services this rate applies to.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun description(): Optional<String> = description.getOptional("description")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun object_(): Optional<TaxRate.Object> = object_.getOptional("object")

        /**
         * The tax rate percentage.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun rate(): Optional<Double> = rate.getOptional("rate")

        /**
         * Comma-separated list of product types this rate applies to, or false if it applies
         * generally.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun types(): Optional<TaxRate.Types> = types.getOptional("types")

        /**
         * The province this rate applies to, if applicable.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun province(): Optional<String> = province.getOptional("province")

        /**
         * Returns the raw JSON value of [class_].
         *
         * Unlike [class_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("class") @ExcludeMissing fun _class_(): JsonField<String> = class_

        /**
         * Returns the raw JSON value of [description].
         *
         * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("description")
        @ExcludeMissing
        fun _description(): JsonField<String> = description

        /**
         * Returns the raw JSON value of [object_].
         *
         * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<TaxRate.Object> = object_

        /**
         * Returns the raw JSON value of [rate].
         *
         * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Double> = rate

        /**
         * Returns the raw JSON value of [types].
         *
         * Unlike [types], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("types") @ExcludeMissing fun _types(): JsonField<TaxRate.Types> = types

        /**
         * Returns the raw JSON value of [province].
         *
         * Unlike [province], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("province") @ExcludeMissing fun _province(): JsonField<String> = province

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

            /** Returns a mutable builder for constructing an instance of [Other]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Other]. */
        class Builder internal constructor() {

            private var class_: JsonField<String> = JsonMissing.of()
            private var description: JsonField<String> = JsonMissing.of()
            private var object_: JsonField<TaxRate.Object> = JsonMissing.of()
            private var rate: JsonField<Double> = JsonMissing.of()
            private var types: JsonField<TaxRate.Types> = JsonMissing.of()
            private var province: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(other: Other) = apply {
                class_ = other.class_
                description = other.description
                object_ = other.object_
                rate = other.rate
                types = other.types
                province = other.province
                additionalProperties = other.additionalProperties.toMutableMap()
            }

            /** The rate class (e.g. "standard", "reduced", "zero"). */
            fun class_(class_: String) = class_(JsonField.of(class_))

            /**
             * Sets [Builder.class_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.class_] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun class_(class_: JsonField<String>) = apply { this.class_ = class_ }

            /** A description of what goods/services this rate applies to. */
            fun description(description: String) = description(JsonField.of(description))

            /**
             * Sets [Builder.description] to an arbitrary JSON value.
             *
             * You should usually call [Builder.description] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun description(description: JsonField<String>) = apply {
                this.description = description
            }

            fun object_(object_: TaxRate.Object) = object_(JsonField.of(object_))

            /**
             * Sets [Builder.object_] to an arbitrary JSON value.
             *
             * You should usually call [Builder.object_] with a well-typed [TaxRate.Object] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun object_(object_: JsonField<TaxRate.Object>) = apply { this.object_ = object_ }

            /** The tax rate percentage. */
            fun rate(rate: Double) = rate(JsonField.of(rate))

            /**
             * Sets [Builder.rate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.rate] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun rate(rate: JsonField<Double>) = apply { this.rate = rate }

            /**
             * Comma-separated list of product types this rate applies to, or false if it applies
             * generally.
             */
            fun types(types: TaxRate.Types) = types(JsonField.of(types))

            /**
             * Sets [Builder.types] to an arbitrary JSON value.
             *
             * You should usually call [Builder.types] with a well-typed [TaxRate.Types] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun types(types: JsonField<TaxRate.Types>) = apply { this.types = types }

            /** Alias for calling [types] with `TaxRate.Types.ofString(string)`. */
            fun types(string: String) = types(TaxRate.Types.ofString(string))

            /** Alias for calling [types] with `TaxRate.Types.ofBool(bool)`. */
            fun types(bool: Boolean) = types(TaxRate.Types.ofBool(bool))

            /** The province this rate applies to, if applicable. */
            fun province(province: String?) = province(JsonField.ofNullable(province))

            /** Alias for calling [Builder.province] with `province.orElse(null)`. */
            fun province(province: Optional<String>) = province(province.getOrNull())

            /**
             * Sets [Builder.province] to an arbitrary JSON value.
             *
             * You should usually call [Builder.province] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun province(province: JsonField<String>) = apply { this.province = province }

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
             * Returns an immutable instance of [Other].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Other =
                Other(
                    class_,
                    description,
                    object_,
                    rate,
                    types,
                    province,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Other = apply {
            if (validated) {
                return@apply
            }

            class_()
            description()
            object_().ifPresent { it.validate() }
            rate()
            types().ifPresent { it.validate() }
            province()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (class_.asKnown().isPresent) 1 else 0) +
                (if (description.asKnown().isPresent) 1 else 0) +
                (object_.asKnown().getOrNull()?.validity() ?: 0) +
                (if (rate.asKnown().isPresent) 1 else 0) +
                (types.asKnown().getOrNull()?.validity() ?: 0) +
                (if (province.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Other &&
                class_ == other.class_ &&
                description == other.description &&
                object_ == other.object_ &&
                rate == other.rate &&
                types == other.types &&
                province == other.province &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(class_, description, object_, rate, types, province, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Other{class_=$class_, description=$description, object_=$object_, rate=$rate, types=$types, province=$province, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Rate &&
            countryCode == other.countryCode &&
            countryName == other.countryName &&
            eu == other.eu &&
            object_ == other.object_ &&
            this.other == other.other &&
            standard == other.standard &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(countryCode, countryName, eu, object_, other, standard, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Rate{countryCode=$countryCode, countryName=$countryName, eu=$eu, object_=$object_, other=$other, standard=$standard, additionalProperties=$additionalProperties}"
}
