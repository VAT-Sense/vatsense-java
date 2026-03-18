// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice

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
import com.vatsense.core.checkRequired
import com.vatsense.core.toImmutable
import com.vatsense.errors.VatSenseInvalidDataException
import com.vatsense.models.invoice.item.InvoiceItemInput
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CreateInvoice
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val business: JsonField<InvoiceBusinessInput>,
    private val currencyCode: JsonField<String>,
    private val date: JsonField<String>,
    private val items: JsonField<List<InvoiceItemInput>>,
    private val taxPoint: JsonField<String>,
    private val conversion: JsonField<InvoiceConversionInput>,
    private val customer: JsonField<InvoiceCustomerInput>,
    private val hasVat: JsonField<Boolean>,
    private val invoiceNumber: JsonField<String>,
    private val isCopy: JsonField<Boolean>,
    private val isReverseCharge: JsonField<Boolean>,
    private val notes: JsonField<String>,
    private val padInvoiceNumber: JsonField<Long>,
    private val serial: JsonField<String>,
    private val taxType: JsonField<TaxType>,
    private val type: JsonField<Type>,
    private val zeroRated: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("business")
        @ExcludeMissing
        business: JsonField<InvoiceBusinessInput> = JsonMissing.of(),
        @JsonProperty("currency_code")
        @ExcludeMissing
        currencyCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("date") @ExcludeMissing date: JsonField<String> = JsonMissing.of(),
        @JsonProperty("items")
        @ExcludeMissing
        items: JsonField<List<InvoiceItemInput>> = JsonMissing.of(),
        @JsonProperty("tax_point") @ExcludeMissing taxPoint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("conversion")
        @ExcludeMissing
        conversion: JsonField<InvoiceConversionInput> = JsonMissing.of(),
        @JsonProperty("customer")
        @ExcludeMissing
        customer: JsonField<InvoiceCustomerInput> = JsonMissing.of(),
        @JsonProperty("has_vat") @ExcludeMissing hasVat: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("invoice_number")
        @ExcludeMissing
        invoiceNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_copy") @ExcludeMissing isCopy: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_reverse_charge")
        @ExcludeMissing
        isReverseCharge: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pad_invoice_number")
        @ExcludeMissing
        padInvoiceNumber: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("serial") @ExcludeMissing serial: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tax_type") @ExcludeMissing taxType: JsonField<TaxType> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("zero_rated") @ExcludeMissing zeroRated: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        business,
        currencyCode,
        date,
        items,
        taxPoint,
        conversion,
        customer,
        hasVat,
        invoiceNumber,
        isCopy,
        isReverseCharge,
        notes,
        padInvoiceNumber,
        serial,
        taxType,
        type,
        zeroRated,
        mutableMapOf(),
    )

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun business(): InvoiceBusinessInput = business.getRequired("business")

    /**
     * The 3-character currency code the invoice is billed in.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun currencyCode(): String = currencyCode.getRequired("currency_code")

    /**
     * The date the invoice was issued (YYYY-MM-DD or YYYY-MM-DD HH:MM:SS).
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun date(): String = date.getRequired("date")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun items(): List<InvoiceItemInput> = items.getRequired("items")

    /**
     * The tax point or "time of supply" (YYYY-MM-DD or YYYY-MM-DD HH:MM:SS).
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun taxPoint(): String = taxPoint.getRequired("tax_point")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversion(): Optional<InvoiceConversionInput> = conversion.getOptional("conversion")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customer(): Optional<InvoiceCustomerInput> = customer.getOptional("customer")

    /**
     * Whether the invoice is subject to VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasVat(): Optional<Boolean> = hasVat.getOptional("has_vat")

    /**
     * A unique invoice number. If not provided, defaults to an auto-incremented number.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invoiceNumber(): Optional<String> = invoiceNumber.getOptional("invoice_number")

    /**
     * Whether the invoice is a copy of a primary invoice.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isCopy(): Optional<Boolean> = isCopy.getOptional("is_copy")

    /**
     * Whether the invoice is zero-rated due to reverse charge.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isReverseCharge(): Optional<Boolean> = isReverseCharge.getOptional("is_reverse_charge")

    /**
     * Any additional notes for the invoice.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * Pad the auto-generated invoice number with leading zeros to this length.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun padInvoiceNumber(): Optional<Long> = padInvoiceNumber.getOptional("pad_invoice_number")

    /**
     * A serial prepended to the auto-generated invoice number. Each unique serial has its own
     * auto-increment range.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun serial(): Optional<String> = serial.getOptional("serial")

    /**
     * Whether item prices include or exclude VAT.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxType(): Optional<TaxType> = taxType.getOptional("tax_type")

    /**
     * The type of invoice.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = type.getOptional("type")

    /**
     * Whether the invoice has been zero-rated.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun zeroRated(): Optional<Boolean> = zeroRated.getOptional("zero_rated")

    /**
     * Returns the raw JSON value of [business].
     *
     * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business")
    @ExcludeMissing
    fun _business(): JsonField<InvoiceBusinessInput> = business

    /**
     * Returns the raw JSON value of [currencyCode].
     *
     * Unlike [currencyCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency_code")
    @ExcludeMissing
    fun _currencyCode(): JsonField<String> = currencyCode

    /**
     * Returns the raw JSON value of [date].
     *
     * Unlike [date], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("date") @ExcludeMissing fun _date(): JsonField<String> = date

    /**
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<InvoiceItemInput>> = items

    /**
     * Returns the raw JSON value of [taxPoint].
     *
     * Unlike [taxPoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_point") @ExcludeMissing fun _taxPoint(): JsonField<String> = taxPoint

    /**
     * Returns the raw JSON value of [conversion].
     *
     * Unlike [conversion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversion")
    @ExcludeMissing
    fun _conversion(): JsonField<InvoiceConversionInput> = conversion

    /**
     * Returns the raw JSON value of [customer].
     *
     * Unlike [customer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer")
    @ExcludeMissing
    fun _customer(): JsonField<InvoiceCustomerInput> = customer

    /**
     * Returns the raw JSON value of [hasVat].
     *
     * Unlike [hasVat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("has_vat") @ExcludeMissing fun _hasVat(): JsonField<Boolean> = hasVat

    /**
     * Returns the raw JSON value of [invoiceNumber].
     *
     * Unlike [invoiceNumber], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invoice_number")
    @ExcludeMissing
    fun _invoiceNumber(): JsonField<String> = invoiceNumber

    /**
     * Returns the raw JSON value of [isCopy].
     *
     * Unlike [isCopy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_copy") @ExcludeMissing fun _isCopy(): JsonField<Boolean> = isCopy

    /**
     * Returns the raw JSON value of [isReverseCharge].
     *
     * Unlike [isReverseCharge], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_reverse_charge")
    @ExcludeMissing
    fun _isReverseCharge(): JsonField<Boolean> = isReverseCharge

    /**
     * Returns the raw JSON value of [notes].
     *
     * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<String> = notes

    /**
     * Returns the raw JSON value of [padInvoiceNumber].
     *
     * Unlike [padInvoiceNumber], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("pad_invoice_number")
    @ExcludeMissing
    fun _padInvoiceNumber(): JsonField<Long> = padInvoiceNumber

    /**
     * Returns the raw JSON value of [serial].
     *
     * Unlike [serial], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("serial") @ExcludeMissing fun _serial(): JsonField<String> = serial

    /**
     * Returns the raw JSON value of [taxType].
     *
     * Unlike [taxType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_type") @ExcludeMissing fun _taxType(): JsonField<TaxType> = taxType

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [zeroRated].
     *
     * Unlike [zeroRated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("zero_rated") @ExcludeMissing fun _zeroRated(): JsonField<Boolean> = zeroRated

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
         * Returns a mutable builder for constructing an instance of [CreateInvoice].
         *
         * The following fields are required:
         * ```java
         * .business()
         * .currencyCode()
         * .date()
         * .items()
         * .taxPoint()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreateInvoice]. */
    class Builder internal constructor() {

        private var business: JsonField<InvoiceBusinessInput>? = null
        private var currencyCode: JsonField<String>? = null
        private var date: JsonField<String>? = null
        private var items: JsonField<MutableList<InvoiceItemInput>>? = null
        private var taxPoint: JsonField<String>? = null
        private var conversion: JsonField<InvoiceConversionInput> = JsonMissing.of()
        private var customer: JsonField<InvoiceCustomerInput> = JsonMissing.of()
        private var hasVat: JsonField<Boolean> = JsonMissing.of()
        private var invoiceNumber: JsonField<String> = JsonMissing.of()
        private var isCopy: JsonField<Boolean> = JsonMissing.of()
        private var isReverseCharge: JsonField<Boolean> = JsonMissing.of()
        private var notes: JsonField<String> = JsonMissing.of()
        private var padInvoiceNumber: JsonField<Long> = JsonMissing.of()
        private var serial: JsonField<String> = JsonMissing.of()
        private var taxType: JsonField<TaxType> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var zeroRated: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(createInvoice: CreateInvoice) = apply {
            business = createInvoice.business
            currencyCode = createInvoice.currencyCode
            date = createInvoice.date
            items = createInvoice.items.map { it.toMutableList() }
            taxPoint = createInvoice.taxPoint
            conversion = createInvoice.conversion
            customer = createInvoice.customer
            hasVat = createInvoice.hasVat
            invoiceNumber = createInvoice.invoiceNumber
            isCopy = createInvoice.isCopy
            isReverseCharge = createInvoice.isReverseCharge
            notes = createInvoice.notes
            padInvoiceNumber = createInvoice.padInvoiceNumber
            serial = createInvoice.serial
            taxType = createInvoice.taxType
            type = createInvoice.type
            zeroRated = createInvoice.zeroRated
            additionalProperties = createInvoice.additionalProperties.toMutableMap()
        }

        fun business(business: InvoiceBusinessInput) = business(JsonField.of(business))

        /**
         * Sets [Builder.business] to an arbitrary JSON value.
         *
         * You should usually call [Builder.business] with a well-typed [InvoiceBusinessInput] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun business(business: JsonField<InvoiceBusinessInput>) = apply { this.business = business }

        /** The 3-character currency code the invoice is billed in. */
        fun currencyCode(currencyCode: String) = currencyCode(JsonField.of(currencyCode))

        /**
         * Sets [Builder.currencyCode] to an arbitrary JSON value.
         *
         * You should usually call [Builder.currencyCode] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun currencyCode(currencyCode: JsonField<String>) = apply {
            this.currencyCode = currencyCode
        }

        /** The date the invoice was issued (YYYY-MM-DD or YYYY-MM-DD HH:MM:SS). */
        fun date(date: String) = date(JsonField.of(date))

        /**
         * Sets [Builder.date] to an arbitrary JSON value.
         *
         * You should usually call [Builder.date] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun date(date: JsonField<String>) = apply { this.date = date }

        fun items(items: List<InvoiceItemInput>) = items(JsonField.of(items))

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<InvoiceItemInput>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun items(items: JsonField<List<InvoiceItemInput>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /**
         * Adds a single [InvoiceItemInput] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: InvoiceItemInput) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        /** The tax point or "time of supply" (YYYY-MM-DD or YYYY-MM-DD HH:MM:SS). */
        fun taxPoint(taxPoint: String) = taxPoint(JsonField.of(taxPoint))

        /**
         * Sets [Builder.taxPoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxPoint] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxPoint(taxPoint: JsonField<String>) = apply { this.taxPoint = taxPoint }

        fun conversion(conversion: InvoiceConversionInput) = conversion(JsonField.of(conversion))

        /**
         * Sets [Builder.conversion] to an arbitrary JSON value.
         *
         * You should usually call [Builder.conversion] with a well-typed [InvoiceConversionInput]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun conversion(conversion: JsonField<InvoiceConversionInput>) = apply {
            this.conversion = conversion
        }

        fun customer(customer: InvoiceCustomerInput) = customer(JsonField.of(customer))

        /**
         * Sets [Builder.customer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customer] with a well-typed [InvoiceCustomerInput] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun customer(customer: JsonField<InvoiceCustomerInput>) = apply { this.customer = customer }

        /** Whether the invoice is subject to VAT. */
        fun hasVat(hasVat: Boolean) = hasVat(JsonField.of(hasVat))

        /**
         * Sets [Builder.hasVat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasVat] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasVat(hasVat: JsonField<Boolean>) = apply { this.hasVat = hasVat }

        /** A unique invoice number. If not provided, defaults to an auto-incremented number. */
        fun invoiceNumber(invoiceNumber: String) = invoiceNumber(JsonField.of(invoiceNumber))

        /**
         * Sets [Builder.invoiceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invoiceNumber] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun invoiceNumber(invoiceNumber: JsonField<String>) = apply {
            this.invoiceNumber = invoiceNumber
        }

        /** Whether the invoice is a copy of a primary invoice. */
        fun isCopy(isCopy: Boolean) = isCopy(JsonField.of(isCopy))

        /**
         * Sets [Builder.isCopy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isCopy] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isCopy(isCopy: JsonField<Boolean>) = apply { this.isCopy = isCopy }

        /** Whether the invoice is zero-rated due to reverse charge. */
        fun isReverseCharge(isReverseCharge: Boolean) =
            isReverseCharge(JsonField.of(isReverseCharge))

        /**
         * Sets [Builder.isReverseCharge] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isReverseCharge] with a well-typed [Boolean] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun isReverseCharge(isReverseCharge: JsonField<Boolean>) = apply {
            this.isReverseCharge = isReverseCharge
        }

        /** Any additional notes for the invoice. */
        fun notes(notes: String) = notes(JsonField.of(notes))

        /**
         * Sets [Builder.notes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notes] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun notes(notes: JsonField<String>) = apply { this.notes = notes }

        /** Pad the auto-generated invoice number with leading zeros to this length. */
        fun padInvoiceNumber(padInvoiceNumber: Long) =
            padInvoiceNumber(JsonField.of(padInvoiceNumber))

        /**
         * Sets [Builder.padInvoiceNumber] to an arbitrary JSON value.
         *
         * You should usually call [Builder.padInvoiceNumber] with a well-typed [Long] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun padInvoiceNumber(padInvoiceNumber: JsonField<Long>) = apply {
            this.padInvoiceNumber = padInvoiceNumber
        }

        /**
         * A serial prepended to the auto-generated invoice number. Each unique serial has its own
         * auto-increment range.
         */
        fun serial(serial: String) = serial(JsonField.of(serial))

        /**
         * Sets [Builder.serial] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serial] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun serial(serial: JsonField<String>) = apply { this.serial = serial }

        /** Whether item prices include or exclude VAT. */
        fun taxType(taxType: TaxType) = taxType(JsonField.of(taxType))

        /**
         * Sets [Builder.taxType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxType] with a well-typed [TaxType] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxType(taxType: JsonField<TaxType>) = apply { this.taxType = taxType }

        /** The type of invoice. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Whether the invoice has been zero-rated. */
        fun zeroRated(zeroRated: Boolean) = zeroRated(JsonField.of(zeroRated))

        /**
         * Sets [Builder.zeroRated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.zeroRated] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun zeroRated(zeroRated: JsonField<Boolean>) = apply { this.zeroRated = zeroRated }

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
         * Returns an immutable instance of [CreateInvoice].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .business()
         * .currencyCode()
         * .date()
         * .items()
         * .taxPoint()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CreateInvoice =
            CreateInvoice(
                checkRequired("business", business),
                checkRequired("currencyCode", currencyCode),
                checkRequired("date", date),
                checkRequired("items", items).map { it.toImmutable() },
                checkRequired("taxPoint", taxPoint),
                conversion,
                customer,
                hasVat,
                invoiceNumber,
                isCopy,
                isReverseCharge,
                notes,
                padInvoiceNumber,
                serial,
                taxType,
                type,
                zeroRated,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreateInvoice = apply {
        if (validated) {
            return@apply
        }

        business().validate()
        currencyCode()
        date()
        items().forEach { it.validate() }
        taxPoint()
        conversion().ifPresent { it.validate() }
        customer().ifPresent { it.validate() }
        hasVat()
        invoiceNumber()
        isCopy()
        isReverseCharge()
        notes()
        padInvoiceNumber()
        serial()
        taxType().ifPresent { it.validate() }
        type().ifPresent { it.validate() }
        zeroRated()
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
        (business.asKnown().getOrNull()?.validity() ?: 0) +
            (if (currencyCode.asKnown().isPresent) 1 else 0) +
            (if (date.asKnown().isPresent) 1 else 0) +
            (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (taxPoint.asKnown().isPresent) 1 else 0) +
            (conversion.asKnown().getOrNull()?.validity() ?: 0) +
            (customer.asKnown().getOrNull()?.validity() ?: 0) +
            (if (hasVat.asKnown().isPresent) 1 else 0) +
            (if (invoiceNumber.asKnown().isPresent) 1 else 0) +
            (if (isCopy.asKnown().isPresent) 1 else 0) +
            (if (isReverseCharge.asKnown().isPresent) 1 else 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (padInvoiceNumber.asKnown().isPresent) 1 else 0) +
            (if (serial.asKnown().isPresent) 1 else 0) +
            (taxType.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (zeroRated.asKnown().isPresent) 1 else 0)

    /** Whether item prices include or exclude VAT. */
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

    /** The type of invoice. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SALE = of("sale")

            @JvmField val REFUND = of("refund")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            SALE,
            REFUND,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SALE,
            REFUND,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                SALE -> Value.SALE
                REFUND -> Value.REFUND
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
                SALE -> Known.SALE
                REFUND -> Known.REFUND
                else -> throw VatSenseInvalidDataException("Unknown Type: $value")
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

        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreateInvoice &&
            business == other.business &&
            currencyCode == other.currencyCode &&
            date == other.date &&
            items == other.items &&
            taxPoint == other.taxPoint &&
            conversion == other.conversion &&
            customer == other.customer &&
            hasVat == other.hasVat &&
            invoiceNumber == other.invoiceNumber &&
            isCopy == other.isCopy &&
            isReverseCharge == other.isReverseCharge &&
            notes == other.notes &&
            padInvoiceNumber == other.padInvoiceNumber &&
            serial == other.serial &&
            taxType == other.taxType &&
            type == other.type &&
            zeroRated == other.zeroRated &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            business,
            currencyCode,
            date,
            items,
            taxPoint,
            conversion,
            customer,
            hasVat,
            invoiceNumber,
            isCopy,
            isReverseCharge,
            notes,
            padInvoiceNumber,
            serial,
            taxType,
            type,
            zeroRated,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreateInvoice{business=$business, currencyCode=$currencyCode, date=$date, items=$items, taxPoint=$taxPoint, conversion=$conversion, customer=$customer, hasVat=$hasVat, invoiceNumber=$invoiceNumber, isCopy=$isCopy, isReverseCharge=$isReverseCharge, notes=$notes, padInvoiceNumber=$padInvoiceNumber, serial=$serial, taxType=$taxType, type=$type, zeroRated=$zeroRated, additionalProperties=$additionalProperties}"
}
