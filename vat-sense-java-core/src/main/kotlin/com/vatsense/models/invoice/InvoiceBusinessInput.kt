// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.core.checkRequired
import com.vatsense.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class InvoiceBusinessInput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val address: JsonField<String>,
    private val name: JsonField<String>,
    private val vatNumber: JsonField<String>,
    private val bankAccount: JsonField<String>,
    private val companyNumber: JsonField<String>,
    private val email: JsonField<String>,
    private val logo: JsonField<String>,
    private val phone: JsonField<String>,
    private val website: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vat_number") @ExcludeMissing vatNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("bank_account")
        @ExcludeMissing
        bankAccount: JsonField<String> = JsonMissing.of(),
        @JsonProperty("company_number")
        @ExcludeMissing
        companyNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("logo") @ExcludeMissing logo: JsonField<String> = JsonMissing.of(),
        @JsonProperty("phone") @ExcludeMissing phone: JsonField<String> = JsonMissing.of(),
        @JsonProperty("website") @ExcludeMissing website: JsonField<String> = JsonMissing.of(),
    ) : this(
        address,
        name,
        vatNumber,
        bankAccount,
        companyNumber,
        email,
        logo,
        phone,
        website,
        mutableMapOf(),
    )

    /**
     * Your business trading address.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun address(): String = address.getRequired("address")

    /**
     * Your business trading name.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun name(): String = name.getRequired("name")

    /**
     * Your business VAT number.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vatNumber(): String = vatNumber.getRequired("vat_number")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun bankAccount(): Optional<String> = bankAccount.getOptional("bank_account")

    /**
     * Your business company number.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun companyNumber(): Optional<String> = companyNumber.getOptional("company_number")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * URL to your company logo (HTTPS only, .svg/.jpg/.png). Recommended 240px by 60px.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logo(): Optional<String> = logo.getOptional("logo")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun phone(): Optional<String> = phone.getOptional("phone")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun website(): Optional<String> = website.getOptional("website")

    /**
     * Returns the raw JSON value of [address].
     *
     * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    /**
     * Returns the raw JSON value of [vatNumber].
     *
     * Unlike [vatNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vat_number") @ExcludeMissing fun _vatNumber(): JsonField<String> = vatNumber

    /**
     * Returns the raw JSON value of [bankAccount].
     *
     * Unlike [bankAccount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("bank_account")
    @ExcludeMissing
    fun _bankAccount(): JsonField<String> = bankAccount

    /**
     * Returns the raw JSON value of [companyNumber].
     *
     * Unlike [companyNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("company_number")
    @ExcludeMissing
    fun _companyNumber(): JsonField<String> = companyNumber

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [logo].
     *
     * Unlike [logo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logo") @ExcludeMissing fun _logo(): JsonField<String> = logo

    /**
     * Returns the raw JSON value of [phone].
     *
     * Unlike [phone], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("phone") @ExcludeMissing fun _phone(): JsonField<String> = phone

    /**
     * Returns the raw JSON value of [website].
     *
     * Unlike [website], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("website") @ExcludeMissing fun _website(): JsonField<String> = website

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
         * Returns a mutable builder for constructing an instance of [InvoiceBusinessInput].
         *
         * The following fields are required:
         * ```java
         * .address()
         * .name()
         * .vatNumber()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvoiceBusinessInput]. */
    class Builder internal constructor() {

        private var address: JsonField<String>? = null
        private var name: JsonField<String>? = null
        private var vatNumber: JsonField<String>? = null
        private var bankAccount: JsonField<String> = JsonMissing.of()
        private var companyNumber: JsonField<String> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var logo: JsonField<String> = JsonMissing.of()
        private var phone: JsonField<String> = JsonMissing.of()
        private var website: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invoiceBusinessInput: InvoiceBusinessInput) = apply {
            address = invoiceBusinessInput.address
            name = invoiceBusinessInput.name
            vatNumber = invoiceBusinessInput.vatNumber
            bankAccount = invoiceBusinessInput.bankAccount
            companyNumber = invoiceBusinessInput.companyNumber
            email = invoiceBusinessInput.email
            logo = invoiceBusinessInput.logo
            phone = invoiceBusinessInput.phone
            website = invoiceBusinessInput.website
            additionalProperties = invoiceBusinessInput.additionalProperties.toMutableMap()
        }

        /** Your business trading address. */
        fun address(address: String) = address(JsonField.of(address))

        /**
         * Sets [Builder.address] to an arbitrary JSON value.
         *
         * You should usually call [Builder.address] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun address(address: JsonField<String>) = apply { this.address = address }

        /** Your business trading name. */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Your business VAT number. */
        fun vatNumber(vatNumber: String) = vatNumber(JsonField.of(vatNumber))

        /**
         * Sets [Builder.vatNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vatNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun vatNumber(vatNumber: JsonField<String>) = apply { this.vatNumber = vatNumber }

        fun bankAccount(bankAccount: String) = bankAccount(JsonField.of(bankAccount))

        /**
         * Sets [Builder.bankAccount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.bankAccount] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun bankAccount(bankAccount: JsonField<String>) = apply { this.bankAccount = bankAccount }

        /** Your business company number. */
        fun companyNumber(companyNumber: String) = companyNumber(JsonField.of(companyNumber))

        /**
         * Sets [Builder.companyNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.companyNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun companyNumber(companyNumber: JsonField<String>) = apply {
            this.companyNumber = companyNumber
        }

        fun email(email: String) = email(JsonField.of(email))

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        /** URL to your company logo (HTTPS only, .svg/.jpg/.png). Recommended 240px by 60px. */
        fun logo(logo: String) = logo(JsonField.of(logo))

        /**
         * Sets [Builder.logo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logo] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logo(logo: JsonField<String>) = apply { this.logo = logo }

        fun phone(phone: String) = phone(JsonField.of(phone))

        /**
         * Sets [Builder.phone] to an arbitrary JSON value.
         *
         * You should usually call [Builder.phone] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun phone(phone: JsonField<String>) = apply { this.phone = phone }

        fun website(website: String) = website(JsonField.of(website))

        /**
         * Sets [Builder.website] to an arbitrary JSON value.
         *
         * You should usually call [Builder.website] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun website(website: JsonField<String>) = apply { this.website = website }

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
         * Returns an immutable instance of [InvoiceBusinessInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .address()
         * .name()
         * .vatNumber()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InvoiceBusinessInput =
            InvoiceBusinessInput(
                checkRequired("address", address),
                checkRequired("name", name),
                checkRequired("vatNumber", vatNumber),
                bankAccount,
                companyNumber,
                email,
                logo,
                phone,
                website,
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
    fun validate(): InvoiceBusinessInput = apply {
        if (validated) {
            return@apply
        }

        address()
        name()
        vatNumber()
        bankAccount()
        companyNumber()
        email()
        logo()
        phone()
        website()
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
        (if (address.asKnown().isPresent) 1 else 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (if (vatNumber.asKnown().isPresent) 1 else 0) +
            (if (bankAccount.asKnown().isPresent) 1 else 0) +
            (if (companyNumber.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (logo.asKnown().isPresent) 1 else 0) +
            (if (phone.asKnown().isPresent) 1 else 0) +
            (if (website.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvoiceBusinessInput &&
            address == other.address &&
            name == other.name &&
            vatNumber == other.vatNumber &&
            bankAccount == other.bankAccount &&
            companyNumber == other.companyNumber &&
            email == other.email &&
            logo == other.logo &&
            phone == other.phone &&
            website == other.website &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            address,
            name,
            vatNumber,
            bankAccount,
            companyNumber,
            email,
            logo,
            phone,
            website,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InvoiceBusinessInput{address=$address, name=$name, vatNumber=$vatNumber, bankAccount=$bankAccount, companyNumber=$companyNumber, email=$email, logo=$logo, phone=$phone, website=$website, additionalProperties=$additionalProperties}"
}
