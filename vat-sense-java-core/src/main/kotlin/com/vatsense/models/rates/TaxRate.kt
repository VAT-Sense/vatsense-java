// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.BaseDeserializer
import com.vatsense.core.BaseSerializer
import com.vatsense.core.Enum
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.core.allMaxBy
import com.vatsense.core.getOrThrow
import com.vatsense.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class TaxRate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val class_: JsonField<String>,
    private val description: JsonField<String>,
    private val object_: JsonField<Object>,
    private val rate: JsonField<Double>,
    private val taxName: JsonField<String>,
    private val types: JsonField<Types>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("class") @ExcludeMissing class_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("rate") @ExcludeMissing rate: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("tax_name") @ExcludeMissing taxName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("types") @ExcludeMissing types: JsonField<Types> = JsonMissing.of(),
    ) : this(class_, description, object_, rate, taxName, types, mutableMapOf())

    /**
     * The rate tier within its tax (e.g. "standard", "reduced", "higher", "zero", "exempt").
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun class_(): Optional<String> = class_.getOptional("class")

    /**
     * A description of what goods/services this rate applies to.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * The tax rate percentage.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun rate(): Optional<Double> = rate.getOptional("rate")

    /**
     * Short name of the tax this rate belongs to (e.g. "vat", "gst", "hst", "pst", "qst", "igic",
     * "sst"). Open vocabulary, lower case. Null where not yet classified.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxName(): Optional<String> = taxName.getOptional("tax_name")

    /**
     * Comma-separated list of product types this rate applies to, or false if it applies generally.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun types(): Optional<Types> = types.getOptional("types")

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
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [rate].
     *
     * Unlike [rate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("rate") @ExcludeMissing fun _rate(): JsonField<Double> = rate

    /**
     * Returns the raw JSON value of [taxName].
     *
     * Unlike [taxName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_name") @ExcludeMissing fun _taxName(): JsonField<String> = taxName

    /**
     * Returns the raw JSON value of [types].
     *
     * Unlike [types], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("types") @ExcludeMissing fun _types(): JsonField<Types> = types

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

        /** Returns a mutable builder for constructing an instance of [TaxRate]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TaxRate]. */
    class Builder internal constructor() {

        private var class_: JsonField<String> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var rate: JsonField<Double> = JsonMissing.of()
        private var taxName: JsonField<String> = JsonMissing.of()
        private var types: JsonField<Types> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(taxRate: TaxRate) = apply {
            class_ = taxRate.class_
            description = taxRate.description
            object_ = taxRate.object_
            rate = taxRate.rate
            taxName = taxRate.taxName
            types = taxRate.types
            additionalProperties = taxRate.additionalProperties.toMutableMap()
        }

        /**
         * The rate tier within its tax (e.g. "standard", "reduced", "higher", "zero", "exempt").
         */
        fun class_(class_: String) = class_(JsonField.of(class_))

        /**
         * Sets [Builder.class_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.class_] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun class_(class_: JsonField<String>) = apply { this.class_ = class_ }

        /** A description of what goods/services this rate applies to. */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The tax rate percentage. */
        fun rate(rate: Double) = rate(JsonField.of(rate))

        /**
         * Sets [Builder.rate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.rate] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun rate(rate: JsonField<Double>) = apply { this.rate = rate }

        /**
         * Short name of the tax this rate belongs to (e.g. "vat", "gst", "hst", "pst", "qst",
         * "igic", "sst"). Open vocabulary, lower case. Null where not yet classified.
         */
        fun taxName(taxName: String?) = taxName(JsonField.ofNullable(taxName))

        /** Alias for calling [Builder.taxName] with `taxName.orElse(null)`. */
        fun taxName(taxName: Optional<String>) = taxName(taxName.getOrNull())

        /**
         * Sets [Builder.taxName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxName] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxName(taxName: JsonField<String>) = apply { this.taxName = taxName }

        /**
         * Comma-separated list of product types this rate applies to, or false if it applies
         * generally.
         */
        fun types(types: Types) = types(JsonField.of(types))

        /**
         * Sets [Builder.types] to an arbitrary JSON value.
         *
         * You should usually call [Builder.types] with a well-typed [Types] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun types(types: JsonField<Types>) = apply { this.types = types }

        /** Alias for calling [types] with `Types.ofString(string)`. */
        fun types(string: String) = types(Types.ofString(string))

        /** Alias for calling [types] with `Types.ofBool(bool)`. */
        fun types(bool: Boolean) = types(Types.ofBool(bool))

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
         * Returns an immutable instance of [TaxRate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TaxRate =
            TaxRate(
                class_,
                description,
                object_,
                rate,
                taxName,
                types,
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
    fun validate(): TaxRate = apply {
        if (validated) {
            return@apply
        }

        class_()
        description()
        object_().ifPresent { it.validate() }
        rate()
        taxName()
        types().ifPresent { it.validate() }
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
        (if (class_.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (rate.asKnown().isPresent) 1 else 0) +
            (if (taxName.asKnown().isPresent) 1 else 0) +
            (types.asKnown().getOrNull()?.validity() ?: 0)

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

            @JvmField val TAX_RATE = of("tax_rate")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            TAX_RATE
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
            TAX_RATE,
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
                TAX_RATE -> Value.TAX_RATE
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
                TAX_RATE -> Known.TAX_RATE
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

    /**
     * Comma-separated list of product types this rate applies to, or false if it applies generally.
     */
    @JsonDeserialize(using = Types.Deserializer::class)
    @JsonSerialize(using = Types.Serializer::class)
    class Types
    private constructor(
        private val string: String? = null,
        private val bool: Boolean? = null,
        private val _json: JsonValue? = null,
    ) {

        fun string(): Optional<String> = Optional.ofNullable(string)

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        fun isString(): Boolean = string != null

        fun isBool(): Boolean = bool != null

        fun asString(): String = string.getOrThrow("string")

        fun asBool(): Boolean = bool.getOrThrow("bool")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.vatsense.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = types.accept(new Types.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitString(String string) {
         *         return Optional.of(string.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws VatSenseInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                bool != null -> visitor.visitBool(bool)
                else -> visitor.unknown(_json)
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
        fun validate(): Types = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitBool(bool: Boolean) {}
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitString(string: String) = 1

                    override fun visitBool(bool: Boolean) = 1

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Types && string == other.string && bool == other.bool
        }

        override fun hashCode(): Int = Objects.hash(string, bool)

        override fun toString(): String =
            when {
                string != null -> "Types{string=$string}"
                bool != null -> "Types{bool=$bool}"
                _json != null -> "Types{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Types")
            }

        companion object {

            @JvmStatic fun ofString(string: String) = Types(string = string)

            @JvmStatic fun ofBool(bool: Boolean) = Types(bool = bool)
        }

        /** An interface that defines how to map each variant of [Types] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitString(string: String): T

            fun visitBool(bool: Boolean): T

            /**
             * Maps an unknown variant of [Types] to a value of type [T].
             *
             * An instance of [Types] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws VatSenseInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw VatSenseInvalidDataException("Unknown Types: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Types>(Types::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Types {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Types(string = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                                Types(bool = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from integer).
                    0 -> Types(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Types>(Types::class) {

            override fun serialize(
                value: Types,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.bool != null -> generator.writeObject(value.bool)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Types")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TaxRate &&
            class_ == other.class_ &&
            description == other.description &&
            object_ == other.object_ &&
            rate == other.rate &&
            taxName == other.taxName &&
            types == other.types &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(class_, description, object_, rate, taxName, types, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "TaxRate{class_=$class_, description=$description, object_=$object_, rate=$rate, taxName=$taxName, types=$types, additionalProperties=$additionalProperties}"
}
