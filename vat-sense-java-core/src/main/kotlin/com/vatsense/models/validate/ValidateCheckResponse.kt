// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.validate

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

class ValidateCheckResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<Long>,
    private val data: JsonField<Data>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(code, data, success, mutableMapOf())

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun code(): Optional<Long> = code.getOptional("code")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun success(): Optional<Boolean> = success.getOptional("success")

    /**
     * Returns the raw JSON value of [code].
     *
     * Unlike [code], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [success].
     *
     * Unlike [success], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

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

        /** Returns a mutable builder for constructing an instance of [ValidateCheckResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ValidateCheckResponse]. */
    class Builder internal constructor() {

        private var code: JsonField<Long> = JsonMissing.of()
        private var data: JsonField<Data> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(validateCheckResponse: ValidateCheckResponse) = apply {
            code = validateCheckResponse.code
            data = validateCheckResponse.data
            success = validateCheckResponse.success
            additionalProperties = validateCheckResponse.additionalProperties.toMutableMap()
        }

        fun code(code: Long) = code(JsonField.of(code))

        /**
         * Sets [Builder.code] to an arbitrary JSON value.
         *
         * You should usually call [Builder.code] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun code(code: JsonField<Long>) = apply { this.code = code }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun success(success: Boolean) = success(JsonField.of(success))

        /**
         * Sets [Builder.success] to an arbitrary JSON value.
         *
         * You should usually call [Builder.success] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun success(success: JsonField<Boolean>) = apply { this.success = success }

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
         * Returns an immutable instance of [ValidateCheckResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ValidateCheckResponse =
            ValidateCheckResponse(code, data, success, additionalProperties.toMutableMap())
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
    fun validate(): ValidateCheckResponse = apply {
        if (validated) {
            return@apply
        }

        code()
        data().ifPresent { it.validate() }
        success()
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
        (if (code.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (if (success.asKnown().isPresent) 1 else 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val company: JsonField<Company>,
        private val consultationNumber: JsonField<String>,
        private val valid: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("company") @ExcludeMissing company: JsonField<Company> = JsonMissing.of(),
            @JsonProperty("consultation_number")
            @ExcludeMissing
            consultationNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("valid") @ExcludeMissing valid: JsonField<Boolean> = JsonMissing.of(),
        ) : this(company, consultationNumber, valid, mutableMapOf())

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun company(): Optional<Company> = company.getOptional("company")

        /**
         * Official consultation number (only returned when requester_vat_number is provided).
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun consultationNumber(): Optional<String> =
            consultationNumber.getOptional("consultation_number")

        /**
         * Whether the VAT/EORI number is valid.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun valid(): Optional<Boolean> = valid.getOptional("valid")

        /**
         * Returns the raw JSON value of [company].
         *
         * Unlike [company], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("company") @ExcludeMissing fun _company(): JsonField<Company> = company

        /**
         * Returns the raw JSON value of [consultationNumber].
         *
         * Unlike [consultationNumber], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("consultation_number")
        @ExcludeMissing
        fun _consultationNumber(): JsonField<String> = consultationNumber

        /**
         * Returns the raw JSON value of [valid].
         *
         * Unlike [valid], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("valid") @ExcludeMissing fun _valid(): JsonField<Boolean> = valid

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var company: JsonField<Company> = JsonMissing.of()
            private var consultationNumber: JsonField<String> = JsonMissing.of()
            private var valid: JsonField<Boolean> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                company = data.company
                consultationNumber = data.consultationNumber
                valid = data.valid
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun company(company: Company) = company(JsonField.of(company))

            /**
             * Sets [Builder.company] to an arbitrary JSON value.
             *
             * You should usually call [Builder.company] with a well-typed [Company] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun company(company: JsonField<Company>) = apply { this.company = company }

            /** Alias for calling [company] with `Company.ofValidation(validation)`. */
            fun company(validation: Company.ValidationCompany) =
                company(Company.ofValidation(validation))

            /** Alias for calling [company] with `Company.ofEoriValidation(eoriValidation)`. */
            fun company(eoriValidation: Company.EoriValidationCompany) =
                company(Company.ofEoriValidation(eoriValidation))

            /**
             * Official consultation number (only returned when requester_vat_number is provided).
             */
            fun consultationNumber(consultationNumber: String?) =
                consultationNumber(JsonField.ofNullable(consultationNumber))

            /**
             * Alias for calling [Builder.consultationNumber] with
             * `consultationNumber.orElse(null)`.
             */
            fun consultationNumber(consultationNumber: Optional<String>) =
                consultationNumber(consultationNumber.getOrNull())

            /**
             * Sets [Builder.consultationNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.consultationNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun consultationNumber(consultationNumber: JsonField<String>) = apply {
                this.consultationNumber = consultationNumber
            }

            /** Whether the VAT/EORI number is valid. */
            fun valid(valid: Boolean) = valid(JsonField.of(valid))

            /**
             * Sets [Builder.valid] to an arbitrary JSON value.
             *
             * You should usually call [Builder.valid] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun valid(valid: JsonField<Boolean>) = apply { this.valid = valid }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(company, consultationNumber, valid, additionalProperties.toMutableMap())
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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            company().ifPresent { it.validate() }
            consultationNumber()
            valid()
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
            (company.asKnown().getOrNull()?.validity() ?: 0) +
                (if (consultationNumber.asKnown().isPresent) 1 else 0) +
                (if (valid.asKnown().isPresent) 1 else 0)

        @JsonDeserialize(using = Company.Deserializer::class)
        @JsonSerialize(using = Company.Serializer::class)
        class Company
        private constructor(
            private val validation: ValidationCompany? = null,
            private val eoriValidation: EoriValidationCompany? = null,
            private val _json: JsonValue? = null,
        ) {

            fun validation(): Optional<ValidationCompany> = Optional.ofNullable(validation)

            fun eoriValidation(): Optional<EoriValidationCompany> =
                Optional.ofNullable(eoriValidation)

            fun isValidation(): Boolean = validation != null

            fun isEoriValidation(): Boolean = eoriValidation != null

            fun asValidation(): ValidationCompany = validation.getOrThrow("validation")

            fun asEoriValidation(): EoriValidationCompany =
                eoriValidation.getOrThrow("eoriValidation")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.vatsense.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = company.accept(new Company.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitValidation(ValidationCompany validation) {
             *         return Optional.of(validation.toString());
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
             * @throws VatSenseInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    validation != null -> visitor.visitValidation(validation)
                    eoriValidation != null -> visitor.visitEoriValidation(eoriValidation)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws VatSenseInvalidDataException if any value type in this object doesn't match
             *   its expected type.
             */
            fun validate(): Company = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitValidation(validation: ValidationCompany) {
                            validation.validate()
                        }

                        override fun visitEoriValidation(eoriValidation: EoriValidationCompany) {
                            eoriValidation.validate()
                        }
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
                        override fun visitValidation(validation: ValidationCompany) =
                            validation.validity()

                        override fun visitEoriValidation(eoriValidation: EoriValidationCompany) =
                            eoriValidation.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Company &&
                    validation == other.validation &&
                    eoriValidation == other.eoriValidation
            }

            override fun hashCode(): Int = Objects.hash(validation, eoriValidation)

            override fun toString(): String =
                when {
                    validation != null -> "Company{validation=$validation}"
                    eoriValidation != null -> "Company{eoriValidation=$eoriValidation}"
                    _json != null -> "Company{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Company")
                }

            companion object {

                @JvmStatic
                fun ofValidation(validation: ValidationCompany) = Company(validation = validation)

                @JvmStatic
                fun ofEoriValidation(eoriValidation: EoriValidationCompany) =
                    Company(eoriValidation = eoriValidation)
            }

            /**
             * An interface that defines how to map each variant of [Company] to a value of type
             * [T].
             */
            interface Visitor<out T> {

                fun visitValidation(validation: ValidationCompany): T

                fun visitEoriValidation(eoriValidation: EoriValidationCompany): T

                /**
                 * Maps an unknown variant of [Company] to a value of type [T].
                 *
                 * An instance of [Company] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws VatSenseInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw VatSenseInvalidDataException("Unknown Company: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Company>(Company::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Company {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<ValidationCompany>())?.let {
                                    Company(validation = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<EoriValidationCompany>())?.let {
                                    Company(eoriValidation = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from boolean).
                        0 -> Company(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Company>(Company::class) {

                override fun serialize(
                    value: Company,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.validation != null -> generator.writeObject(value.validation)
                        value.eoriValidation != null -> generator.writeObject(value.eoriValidation)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Company")
                    }
                }
            }

            class ValidationCompany
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val companyAddress: JsonField<String>,
                private val companyName: JsonField<String>,
                private val countryCode: JsonField<String>,
                private val vatNumber: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("company_address")
                    @ExcludeMissing
                    companyAddress: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("company_name")
                    @ExcludeMissing
                    companyName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country_code")
                    @ExcludeMissing
                    countryCode: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("vat_number")
                    @ExcludeMissing
                    vatNumber: JsonField<String> = JsonMissing.of(),
                ) : this(companyAddress, companyName, countryCode, vatNumber, mutableMapOf())

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun companyAddress(): Optional<String> =
                    companyAddress.getOptional("company_address")

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun companyName(): Optional<String> = companyName.getOptional("company_name")

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

                /**
                 * The VAT number (without country code prefix).
                 *
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun vatNumber(): Optional<String> = vatNumber.getOptional("vat_number")

                /**
                 * Returns the raw JSON value of [companyAddress].
                 *
                 * Unlike [companyAddress], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("company_address")
                @ExcludeMissing
                fun _companyAddress(): JsonField<String> = companyAddress

                /**
                 * Returns the raw JSON value of [companyName].
                 *
                 * Unlike [companyName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("company_name")
                @ExcludeMissing
                fun _companyName(): JsonField<String> = companyName

                /**
                 * Returns the raw JSON value of [countryCode].
                 *
                 * Unlike [countryCode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("country_code")
                @ExcludeMissing
                fun _countryCode(): JsonField<String> = countryCode

                /**
                 * Returns the raw JSON value of [vatNumber].
                 *
                 * Unlike [vatNumber], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("vat_number")
                @ExcludeMissing
                fun _vatNumber(): JsonField<String> = vatNumber

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

                    /**
                     * Returns a mutable builder for constructing an instance of
                     * [ValidationCompany].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [ValidationCompany]. */
                class Builder internal constructor() {

                    private var companyAddress: JsonField<String> = JsonMissing.of()
                    private var companyName: JsonField<String> = JsonMissing.of()
                    private var countryCode: JsonField<String> = JsonMissing.of()
                    private var vatNumber: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(validationCompany: ValidationCompany) = apply {
                        companyAddress = validationCompany.companyAddress
                        companyName = validationCompany.companyName
                        countryCode = validationCompany.countryCode
                        vatNumber = validationCompany.vatNumber
                        additionalProperties = validationCompany.additionalProperties.toMutableMap()
                    }

                    fun companyAddress(companyAddress: String) =
                        companyAddress(JsonField.of(companyAddress))

                    /**
                     * Sets [Builder.companyAddress] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.companyAddress] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun companyAddress(companyAddress: JsonField<String>) = apply {
                        this.companyAddress = companyAddress
                    }

                    fun companyName(companyName: String) = companyName(JsonField.of(companyName))

                    /**
                     * Sets [Builder.companyName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.companyName] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun companyName(companyName: JsonField<String>) = apply {
                        this.companyName = companyName
                    }

                    fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

                    /**
                     * Sets [Builder.countryCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.countryCode] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun countryCode(countryCode: JsonField<String>) = apply {
                        this.countryCode = countryCode
                    }

                    /** The VAT number (without country code prefix). */
                    fun vatNumber(vatNumber: String) = vatNumber(JsonField.of(vatNumber))

                    /**
                     * Sets [Builder.vatNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.vatNumber] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun vatNumber(vatNumber: JsonField<String>) = apply {
                        this.vatNumber = vatNumber
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [ValidationCompany].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): ValidationCompany =
                        ValidationCompany(
                            companyAddress,
                            companyName,
                            countryCode,
                            vatNumber,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws VatSenseInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): ValidationCompany = apply {
                    if (validated) {
                        return@apply
                    }

                    companyAddress()
                    companyName()
                    countryCode()
                    vatNumber()
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
                    (if (companyAddress.asKnown().isPresent) 1 else 0) +
                        (if (companyName.asKnown().isPresent) 1 else 0) +
                        (if (countryCode.asKnown().isPresent) 1 else 0) +
                        (if (vatNumber.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is ValidationCompany &&
                        companyAddress == other.companyAddress &&
                        companyName == other.companyName &&
                        countryCode == other.countryCode &&
                        vatNumber == other.vatNumber &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        companyAddress,
                        companyName,
                        countryCode,
                        vatNumber,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "ValidationCompany{companyAddress=$companyAddress, companyName=$companyName, countryCode=$countryCode, vatNumber=$vatNumber, additionalProperties=$additionalProperties}"
            }

            class EoriValidationCompany
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val companyAddress: JsonField<String>,
                private val companyName: JsonField<String>,
                private val countryCode: JsonField<String>,
                private val eoriNumber: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("company_address")
                    @ExcludeMissing
                    companyAddress: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("company_name")
                    @ExcludeMissing
                    companyName: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("country_code")
                    @ExcludeMissing
                    countryCode: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("eori_number")
                    @ExcludeMissing
                    eoriNumber: JsonField<String> = JsonMissing.of(),
                ) : this(companyAddress, companyName, countryCode, eoriNumber, mutableMapOf())

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun companyAddress(): Optional<String> =
                    companyAddress.getOptional("company_address")

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun companyName(): Optional<String> = companyName.getOptional("company_name")

                /**
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

                /**
                 * The EORI number (without country code prefix).
                 *
                 * @throws VatSenseInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun eoriNumber(): Optional<String> = eoriNumber.getOptional("eori_number")

                /**
                 * Returns the raw JSON value of [companyAddress].
                 *
                 * Unlike [companyAddress], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("company_address")
                @ExcludeMissing
                fun _companyAddress(): JsonField<String> = companyAddress

                /**
                 * Returns the raw JSON value of [companyName].
                 *
                 * Unlike [companyName], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("company_name")
                @ExcludeMissing
                fun _companyName(): JsonField<String> = companyName

                /**
                 * Returns the raw JSON value of [countryCode].
                 *
                 * Unlike [countryCode], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("country_code")
                @ExcludeMissing
                fun _countryCode(): JsonField<String> = countryCode

                /**
                 * Returns the raw JSON value of [eoriNumber].
                 *
                 * Unlike [eoriNumber], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("eori_number")
                @ExcludeMissing
                fun _eoriNumber(): JsonField<String> = eoriNumber

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

                    /**
                     * Returns a mutable builder for constructing an instance of
                     * [EoriValidationCompany].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [EoriValidationCompany]. */
                class Builder internal constructor() {

                    private var companyAddress: JsonField<String> = JsonMissing.of()
                    private var companyName: JsonField<String> = JsonMissing.of()
                    private var countryCode: JsonField<String> = JsonMissing.of()
                    private var eoriNumber: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(eoriValidationCompany: EoriValidationCompany) = apply {
                        companyAddress = eoriValidationCompany.companyAddress
                        companyName = eoriValidationCompany.companyName
                        countryCode = eoriValidationCompany.countryCode
                        eoriNumber = eoriValidationCompany.eoriNumber
                        additionalProperties =
                            eoriValidationCompany.additionalProperties.toMutableMap()
                    }

                    fun companyAddress(companyAddress: String) =
                        companyAddress(JsonField.of(companyAddress))

                    /**
                     * Sets [Builder.companyAddress] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.companyAddress] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun companyAddress(companyAddress: JsonField<String>) = apply {
                        this.companyAddress = companyAddress
                    }

                    fun companyName(companyName: String) = companyName(JsonField.of(companyName))

                    /**
                     * Sets [Builder.companyName] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.companyName] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun companyName(companyName: JsonField<String>) = apply {
                        this.companyName = companyName
                    }

                    fun countryCode(countryCode: String) = countryCode(JsonField.of(countryCode))

                    /**
                     * Sets [Builder.countryCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.countryCode] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun countryCode(countryCode: JsonField<String>) = apply {
                        this.countryCode = countryCode
                    }

                    /** The EORI number (without country code prefix). */
                    fun eoriNumber(eoriNumber: String) = eoriNumber(JsonField.of(eoriNumber))

                    /**
                     * Sets [Builder.eoriNumber] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.eoriNumber] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun eoriNumber(eoriNumber: JsonField<String>) = apply {
                        this.eoriNumber = eoriNumber
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [EoriValidationCompany].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): EoriValidationCompany =
                        EoriValidationCompany(
                            companyAddress,
                            companyName,
                            countryCode,
                            eoriNumber,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws VatSenseInvalidDataException if any value type in this object doesn't
                 *   match its expected type.
                 */
                fun validate(): EoriValidationCompany = apply {
                    if (validated) {
                        return@apply
                    }

                    companyAddress()
                    companyName()
                    countryCode()
                    eoriNumber()
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
                    (if (companyAddress.asKnown().isPresent) 1 else 0) +
                        (if (companyName.asKnown().isPresent) 1 else 0) +
                        (if (countryCode.asKnown().isPresent) 1 else 0) +
                        (if (eoriNumber.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is EoriValidationCompany &&
                        companyAddress == other.companyAddress &&
                        companyName == other.companyName &&
                        countryCode == other.countryCode &&
                        eoriNumber == other.eoriNumber &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        companyAddress,
                        companyName,
                        countryCode,
                        eoriNumber,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "EoriValidationCompany{companyAddress=$companyAddress, companyName=$companyName, countryCode=$countryCode, eoriNumber=$eoriNumber, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                company == other.company &&
                consultationNumber == other.consultationNumber &&
                valid == other.valid &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(company, consultationNumber, valid, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{company=$company, consultationNumber=$consultationNumber, valid=$valid, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ValidateCheckResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(code, data, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ValidateCheckResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
