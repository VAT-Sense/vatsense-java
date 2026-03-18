// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vat_sense.api.core.Enum
import com.vat_sense.api.core.ExcludeMissing
import com.vat_sense.api.core.JsonField
import com.vat_sense.api.core.JsonMissing
import com.vat_sense.api.core.JsonValue
import com.vat_sense.api.core.checkKnown
import com.vat_sense.api.core.toImmutable
import com.vat_sense.api.errors.VatSenseInvalidDataException
import com.vat_sense.api.models.invoice.item.InvoiceItem
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class Invoice
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val business: JsonField<Business>,
    private val conversion: JsonField<InvoiceConversionInput>,
    private val created: JsonField<OffsetDateTime>,
    private val currencyCode: JsonField<String>,
    private val customer: JsonField<Customer>,
    private val date: JsonField<String>,
    private val hasVat: JsonField<Boolean>,
    private val invoiceNumber: JsonField<String>,
    private val invoiceUrl: JsonField<String>,
    private val isCopy: JsonField<Boolean>,
    private val isReverseCharge: JsonField<Boolean>,
    private val items: JsonField<List<InvoiceItem>>,
    private val notes: JsonField<String>,
    private val numItems: JsonField<Long>,
    private val object_: JsonField<Object>,
    private val taxPoint: JsonField<String>,
    private val taxType: JsonField<TaxType>,
    private val totals: JsonField<Totals>,
    private val type: JsonField<Type>,
    private val updated: JsonField<OffsetDateTime>,
    private val zeroRated: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("business") @ExcludeMissing business: JsonField<Business> = JsonMissing.of(),
        @JsonProperty("conversion")
        @ExcludeMissing
        conversion: JsonField<InvoiceConversionInput> = JsonMissing.of(),
        @JsonProperty("created")
        @ExcludeMissing
        created: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("currency_code")
        @ExcludeMissing
        currencyCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("customer") @ExcludeMissing customer: JsonField<Customer> = JsonMissing.of(),
        @JsonProperty("date") @ExcludeMissing date: JsonField<String> = JsonMissing.of(),
        @JsonProperty("has_vat") @ExcludeMissing hasVat: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("invoice_number")
        @ExcludeMissing
        invoiceNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("invoice_url")
        @ExcludeMissing
        invoiceUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("is_copy") @ExcludeMissing isCopy: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("is_reverse_charge")
        @ExcludeMissing
        isReverseCharge: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("items")
        @ExcludeMissing
        items: JsonField<List<InvoiceItem>> = JsonMissing.of(),
        @JsonProperty("notes") @ExcludeMissing notes: JsonField<String> = JsonMissing.of(),
        @JsonProperty("num_items") @ExcludeMissing numItems: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("tax_point") @ExcludeMissing taxPoint: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tax_type") @ExcludeMissing taxType: JsonField<TaxType> = JsonMissing.of(),
        @JsonProperty("totals") @ExcludeMissing totals: JsonField<Totals> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("updated")
        @ExcludeMissing
        updated: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("zero_rated") @ExcludeMissing zeroRated: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        id,
        business,
        conversion,
        created,
        currencyCode,
        customer,
        date,
        hasVat,
        invoiceNumber,
        invoiceUrl,
        isCopy,
        isReverseCharge,
        items,
        notes,
        numItems,
        object_,
        taxPoint,
        taxType,
        totals,
        type,
        updated,
        zeroRated,
        mutableMapOf(),
    )

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun business(): Optional<Business> = business.getOptional("business")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun conversion(): Optional<InvoiceConversionInput> = conversion.getOptional("conversion")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun created(): Optional<OffsetDateTime> = created.getOptional("created")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun currencyCode(): Optional<String> = currencyCode.getOptional("currency_code")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun customer(): Optional<Customer> = customer.getOptional("customer")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun date(): Optional<String> = date.getOptional("date")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasVat(): Optional<Boolean> = hasVat.getOptional("has_vat")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invoiceNumber(): Optional<String> = invoiceNumber.getOptional("invoice_number")

    /**
     * Unique URL to view the invoice. Append "/pdf" to download a PDF copy.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun invoiceUrl(): Optional<String> = invoiceUrl.getOptional("invoice_url")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isCopy(): Optional<Boolean> = isCopy.getOptional("is_copy")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isReverseCharge(): Optional<Boolean> = isReverseCharge.getOptional("is_reverse_charge")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun items(): Optional<List<InvoiceItem>> = items.getOptional("items")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun notes(): Optional<String> = notes.getOptional("notes")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun numItems(): Optional<Long> = numItems.getOptional("num_items")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxPoint(): Optional<String> = taxPoint.getOptional("tax_point")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun taxType(): Optional<TaxType> = taxType.getOptional("tax_type")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun totals(): Optional<Totals> = totals.getOptional("totals")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = type.getOptional("type")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun updated(): Optional<OffsetDateTime> = updated.getOptional("updated")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun zeroRated(): Optional<Boolean> = zeroRated.getOptional("zero_rated")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [business].
     *
     * Unlike [business], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("business") @ExcludeMissing fun _business(): JsonField<Business> = business

    /**
     * Returns the raw JSON value of [conversion].
     *
     * Unlike [conversion], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("conversion")
    @ExcludeMissing
    fun _conversion(): JsonField<InvoiceConversionInput> = conversion

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<OffsetDateTime> = created

    /**
     * Returns the raw JSON value of [currencyCode].
     *
     * Unlike [currencyCode], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("currency_code")
    @ExcludeMissing
    fun _currencyCode(): JsonField<String> = currencyCode

    /**
     * Returns the raw JSON value of [customer].
     *
     * Unlike [customer], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("customer") @ExcludeMissing fun _customer(): JsonField<Customer> = customer

    /**
     * Returns the raw JSON value of [date].
     *
     * Unlike [date], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("date") @ExcludeMissing fun _date(): JsonField<String> = date

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
     * Returns the raw JSON value of [invoiceUrl].
     *
     * Unlike [invoiceUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("invoice_url") @ExcludeMissing fun _invoiceUrl(): JsonField<String> = invoiceUrl

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
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<InvoiceItem>> = items

    /**
     * Returns the raw JSON value of [notes].
     *
     * Unlike [notes], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("notes") @ExcludeMissing fun _notes(): JsonField<String> = notes

    /**
     * Returns the raw JSON value of [numItems].
     *
     * Unlike [numItems], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("num_items") @ExcludeMissing fun _numItems(): JsonField<Long> = numItems

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [taxPoint].
     *
     * Unlike [taxPoint], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_point") @ExcludeMissing fun _taxPoint(): JsonField<String> = taxPoint

    /**
     * Returns the raw JSON value of [taxType].
     *
     * Unlike [taxType], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tax_type") @ExcludeMissing fun _taxType(): JsonField<TaxType> = taxType

    /**
     * Returns the raw JSON value of [totals].
     *
     * Unlike [totals], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("totals") @ExcludeMissing fun _totals(): JsonField<Totals> = totals

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [updated].
     *
     * Unlike [updated], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated") @ExcludeMissing fun _updated(): JsonField<OffsetDateTime> = updated

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

        /** Returns a mutable builder for constructing an instance of [Invoice]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Invoice]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var business: JsonField<Business> = JsonMissing.of()
        private var conversion: JsonField<InvoiceConversionInput> = JsonMissing.of()
        private var created: JsonField<OffsetDateTime> = JsonMissing.of()
        private var currencyCode: JsonField<String> = JsonMissing.of()
        private var customer: JsonField<Customer> = JsonMissing.of()
        private var date: JsonField<String> = JsonMissing.of()
        private var hasVat: JsonField<Boolean> = JsonMissing.of()
        private var invoiceNumber: JsonField<String> = JsonMissing.of()
        private var invoiceUrl: JsonField<String> = JsonMissing.of()
        private var isCopy: JsonField<Boolean> = JsonMissing.of()
        private var isReverseCharge: JsonField<Boolean> = JsonMissing.of()
        private var items: JsonField<MutableList<InvoiceItem>>? = null
        private var notes: JsonField<String> = JsonMissing.of()
        private var numItems: JsonField<Long> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var taxPoint: JsonField<String> = JsonMissing.of()
        private var taxType: JsonField<TaxType> = JsonMissing.of()
        private var totals: JsonField<Totals> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var updated: JsonField<OffsetDateTime> = JsonMissing.of()
        private var zeroRated: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invoice: Invoice) = apply {
            id = invoice.id
            business = invoice.business
            conversion = invoice.conversion
            created = invoice.created
            currencyCode = invoice.currencyCode
            customer = invoice.customer
            date = invoice.date
            hasVat = invoice.hasVat
            invoiceNumber = invoice.invoiceNumber
            invoiceUrl = invoice.invoiceUrl
            isCopy = invoice.isCopy
            isReverseCharge = invoice.isReverseCharge
            items = invoice.items.map { it.toMutableList() }
            notes = invoice.notes
            numItems = invoice.numItems
            object_ = invoice.object_
            taxPoint = invoice.taxPoint
            taxType = invoice.taxType
            totals = invoice.totals
            type = invoice.type
            updated = invoice.updated
            zeroRated = invoice.zeroRated
            additionalProperties = invoice.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun business(business: Business) = business(JsonField.of(business))

        /**
         * Sets [Builder.business] to an arbitrary JSON value.
         *
         * You should usually call [Builder.business] with a well-typed [Business] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun business(business: JsonField<Business>) = apply { this.business = business }

        fun conversion(conversion: InvoiceConversionInput?) =
            conversion(JsonField.ofNullable(conversion))

        /** Alias for calling [Builder.conversion] with `conversion.orElse(null)`. */
        fun conversion(conversion: Optional<InvoiceConversionInput>) =
            conversion(conversion.getOrNull())

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

        fun created(created: OffsetDateTime) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun created(created: JsonField<OffsetDateTime>) = apply { this.created = created }

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

        fun customer(customer: Customer?) = customer(JsonField.ofNullable(customer))

        /** Alias for calling [Builder.customer] with `customer.orElse(null)`. */
        fun customer(customer: Optional<Customer>) = customer(customer.getOrNull())

        /**
         * Sets [Builder.customer] to an arbitrary JSON value.
         *
         * You should usually call [Builder.customer] with a well-typed [Customer] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun customer(customer: JsonField<Customer>) = apply { this.customer = customer }

        fun date(date: String) = date(JsonField.of(date))

        /**
         * Sets [Builder.date] to an arbitrary JSON value.
         *
         * You should usually call [Builder.date] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun date(date: JsonField<String>) = apply { this.date = date }

        fun hasVat(hasVat: Boolean) = hasVat(JsonField.of(hasVat))

        /**
         * Sets [Builder.hasVat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasVat] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun hasVat(hasVat: JsonField<Boolean>) = apply { this.hasVat = hasVat }

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

        /** Unique URL to view the invoice. Append "/pdf" to download a PDF copy. */
        fun invoiceUrl(invoiceUrl: String) = invoiceUrl(JsonField.of(invoiceUrl))

        /**
         * Sets [Builder.invoiceUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.invoiceUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun invoiceUrl(invoiceUrl: JsonField<String>) = apply { this.invoiceUrl = invoiceUrl }

        fun isCopy(isCopy: Boolean) = isCopy(JsonField.of(isCopy))

        /**
         * Sets [Builder.isCopy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isCopy] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isCopy(isCopy: JsonField<Boolean>) = apply { this.isCopy = isCopy }

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

        fun items(items: List<InvoiceItem>) = items(JsonField.of(items))

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<InvoiceItem>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun items(items: JsonField<List<InvoiceItem>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /**
         * Adds a single [InvoiceItem] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: InvoiceItem) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        fun notes(notes: String?) = notes(JsonField.ofNullable(notes))

        /** Alias for calling [Builder.notes] with `notes.orElse(null)`. */
        fun notes(notes: Optional<String>) = notes(notes.getOrNull())

        /**
         * Sets [Builder.notes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.notes] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun notes(notes: JsonField<String>) = apply { this.notes = notes }

        fun numItems(numItems: Long) = numItems(JsonField.of(numItems))

        /**
         * Sets [Builder.numItems] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numItems] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun numItems(numItems: JsonField<Long>) = apply { this.numItems = numItems }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        fun taxPoint(taxPoint: String) = taxPoint(JsonField.of(taxPoint))

        /**
         * Sets [Builder.taxPoint] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxPoint] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxPoint(taxPoint: JsonField<String>) = apply { this.taxPoint = taxPoint }

        fun taxType(taxType: TaxType) = taxType(JsonField.of(taxType))

        /**
         * Sets [Builder.taxType] to an arbitrary JSON value.
         *
         * You should usually call [Builder.taxType] with a well-typed [TaxType] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun taxType(taxType: JsonField<TaxType>) = apply { this.taxType = taxType }

        fun totals(totals: Totals) = totals(JsonField.of(totals))

        /**
         * Sets [Builder.totals] to an arbitrary JSON value.
         *
         * You should usually call [Builder.totals] with a well-typed [Totals] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun totals(totals: JsonField<Totals>) = apply { this.totals = totals }

        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun updated(updated: OffsetDateTime) = updated(JsonField.of(updated))

        /**
         * Sets [Builder.updated] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updated] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updated(updated: JsonField<OffsetDateTime>) = apply { this.updated = updated }

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
         * Returns an immutable instance of [Invoice].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Invoice =
            Invoice(
                id,
                business,
                conversion,
                created,
                currencyCode,
                customer,
                date,
                hasVat,
                invoiceNumber,
                invoiceUrl,
                isCopy,
                isReverseCharge,
                (items ?: JsonMissing.of()).map { it.toImmutable() },
                notes,
                numItems,
                object_,
                taxPoint,
                taxType,
                totals,
                type,
                updated,
                zeroRated,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Invoice = apply {
        if (validated) {
            return@apply
        }

        id()
        business().ifPresent { it.validate() }
        conversion().ifPresent { it.validate() }
        created()
        currencyCode()
        customer().ifPresent { it.validate() }
        date()
        hasVat()
        invoiceNumber()
        invoiceUrl()
        isCopy()
        isReverseCharge()
        items().ifPresent { it.forEach { it.validate() } }
        notes()
        numItems()
        object_().ifPresent { it.validate() }
        taxPoint()
        taxType().ifPresent { it.validate() }
        totals().ifPresent { it.validate() }
        type().ifPresent { it.validate() }
        updated()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (business.asKnown().getOrNull()?.validity() ?: 0) +
            (conversion.asKnown().getOrNull()?.validity() ?: 0) +
            (if (created.asKnown().isPresent) 1 else 0) +
            (if (currencyCode.asKnown().isPresent) 1 else 0) +
            (customer.asKnown().getOrNull()?.validity() ?: 0) +
            (if (date.asKnown().isPresent) 1 else 0) +
            (if (hasVat.asKnown().isPresent) 1 else 0) +
            (if (invoiceNumber.asKnown().isPresent) 1 else 0) +
            (if (invoiceUrl.asKnown().isPresent) 1 else 0) +
            (if (isCopy.asKnown().isPresent) 1 else 0) +
            (if (isReverseCharge.asKnown().isPresent) 1 else 0) +
            (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (notes.asKnown().isPresent) 1 else 0) +
            (if (numItems.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (taxPoint.asKnown().isPresent) 1 else 0) +
            (taxType.asKnown().getOrNull()?.validity() ?: 0) +
            (totals.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updated.asKnown().isPresent) 1 else 0) +
            (if (zeroRated.asKnown().isPresent) 1 else 0)

    class Business
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address: JsonField<String>,
        private val companyNumber: JsonField<String>,
        private val logo: JsonField<String>,
        private val name: JsonField<String>,
        private val vatNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("company_number")
            @ExcludeMissing
            companyNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logo") @ExcludeMissing logo: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("vat_number")
            @ExcludeMissing
            vatNumber: JsonField<String> = JsonMissing.of(),
        ) : this(address, companyNumber, logo, name, vatNumber, mutableMapOf())

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun address(): Optional<String> = address.getOptional("address")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun companyNumber(): Optional<String> = companyNumber.getOptional("company_number")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun logo(): Optional<String> = logo.getOptional("logo")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vatNumber(): Optional<String> = vatNumber.getOptional("vat_number")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [companyNumber].
         *
         * Unlike [companyNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("company_number")
        @ExcludeMissing
        fun _companyNumber(): JsonField<String> = companyNumber

        /**
         * Returns the raw JSON value of [logo].
         *
         * Unlike [logo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logo") @ExcludeMissing fun _logo(): JsonField<String> = logo

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

            /** Returns a mutable builder for constructing an instance of [Business]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Business]. */
        class Builder internal constructor() {

            private var address: JsonField<String> = JsonMissing.of()
            private var companyNumber: JsonField<String> = JsonMissing.of()
            private var logo: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var vatNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(business: Business) = apply {
                address = business.address
                companyNumber = business.companyNumber
                logo = business.logo
                name = business.name
                vatNumber = business.vatNumber
                additionalProperties = business.additionalProperties.toMutableMap()
            }

            fun address(address: String) = address(JsonField.of(address))

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            fun companyNumber(companyNumber: String) = companyNumber(JsonField.of(companyNumber))

            /**
             * Sets [Builder.companyNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.companyNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun companyNumber(companyNumber: JsonField<String>) = apply {
                this.companyNumber = companyNumber
            }

            fun logo(logo: String?) = logo(JsonField.ofNullable(logo))

            /** Alias for calling [Builder.logo] with `logo.orElse(null)`. */
            fun logo(logo: Optional<String>) = logo(logo.getOrNull())

            /**
             * Sets [Builder.logo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logo] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun logo(logo: JsonField<String>) = apply { this.logo = logo }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun vatNumber(vatNumber: String) = vatNumber(JsonField.of(vatNumber))

            /**
             * Sets [Builder.vatNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vatNumber] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vatNumber(vatNumber: JsonField<String>) = apply { this.vatNumber = vatNumber }

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
             * Returns an immutable instance of [Business].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Business =
                Business(
                    address,
                    companyNumber,
                    logo,
                    name,
                    vatNumber,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Business = apply {
            if (validated) {
                return@apply
            }

            address()
            companyNumber()
            logo()
            name()
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
            (if (address.asKnown().isPresent) 1 else 0) +
                (if (companyNumber.asKnown().isPresent) 1 else 0) +
                (if (logo.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (vatNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Business &&
                address == other.address &&
                companyNumber == other.companyNumber &&
                logo == other.logo &&
                name == other.name &&
                vatNumber == other.vatNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, companyNumber, logo, name, vatNumber, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Business{address=$address, companyNumber=$companyNumber, logo=$logo, name=$name, vatNumber=$vatNumber, additionalProperties=$additionalProperties}"
    }

    class Customer
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val address: JsonField<String>,
        private val companyNumber: JsonField<String>,
        private val logo: JsonField<String>,
        private val name: JsonField<String>,
        private val vatNumber: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("company_number")
            @ExcludeMissing
            companyNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("logo") @ExcludeMissing logo: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("vat_number")
            @ExcludeMissing
            vatNumber: JsonField<String> = JsonMissing.of(),
        ) : this(address, companyNumber, logo, name, vatNumber, mutableMapOf())

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun address(): Optional<String> = address.getOptional("address")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun companyNumber(): Optional<String> = companyNumber.getOptional("company_number")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun logo(): Optional<String> = logo.getOptional("logo")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vatNumber(): Optional<String> = vatNumber.getOptional("vat_number")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [companyNumber].
         *
         * Unlike [companyNumber], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("company_number")
        @ExcludeMissing
        fun _companyNumber(): JsonField<String> = companyNumber

        /**
         * Returns the raw JSON value of [logo].
         *
         * Unlike [logo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("logo") @ExcludeMissing fun _logo(): JsonField<String> = logo

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

            /** Returns a mutable builder for constructing an instance of [Customer]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Customer]. */
        class Builder internal constructor() {

            private var address: JsonField<String> = JsonMissing.of()
            private var companyNumber: JsonField<String> = JsonMissing.of()
            private var logo: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var vatNumber: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(customer: Customer) = apply {
                address = customer.address
                companyNumber = customer.companyNumber
                logo = customer.logo
                name = customer.name
                vatNumber = customer.vatNumber
                additionalProperties = customer.additionalProperties.toMutableMap()
            }

            fun address(address: String) = address(JsonField.of(address))

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            fun companyNumber(companyNumber: String) = companyNumber(JsonField.of(companyNumber))

            /**
             * Sets [Builder.companyNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.companyNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun companyNumber(companyNumber: JsonField<String>) = apply {
                this.companyNumber = companyNumber
            }

            fun logo(logo: String?) = logo(JsonField.ofNullable(logo))

            /** Alias for calling [Builder.logo] with `logo.orElse(null)`. */
            fun logo(logo: Optional<String>) = logo(logo.getOrNull())

            /**
             * Sets [Builder.logo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.logo] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun logo(logo: JsonField<String>) = apply { this.logo = logo }

            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun vatNumber(vatNumber: String) = vatNumber(JsonField.of(vatNumber))

            /**
             * Sets [Builder.vatNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vatNumber] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun vatNumber(vatNumber: JsonField<String>) = apply { this.vatNumber = vatNumber }

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
             * Returns an immutable instance of [Customer].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Customer =
                Customer(
                    address,
                    companyNumber,
                    logo,
                    name,
                    vatNumber,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Customer = apply {
            if (validated) {
                return@apply
            }

            address()
            companyNumber()
            logo()
            name()
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
            (if (address.asKnown().isPresent) 1 else 0) +
                (if (companyNumber.asKnown().isPresent) 1 else 0) +
                (if (logo.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (vatNumber.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Customer &&
                address == other.address &&
                companyNumber == other.companyNumber &&
                logo == other.logo &&
                name == other.name &&
                vatNumber == other.vatNumber &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, companyNumber, logo, name, vatNumber, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Customer{address=$address, companyNumber=$companyNumber, logo=$logo, name=$name, vatNumber=$vatNumber, additionalProperties=$additionalProperties}"
    }

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

            @JvmField val INVOICE = of("invoice")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            INVOICE
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
            INVOICE,
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
                INVOICE -> Value.INVOICE
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
                INVOICE -> Known.INVOICE
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

    class Totals
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val discount: JsonField<Double>,
        private val subtotal: JsonField<Double>,
        private val total: JsonField<Double>,
        private val vat: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("discount")
            @ExcludeMissing
            discount: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("subtotal")
            @ExcludeMissing
            subtotal: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("vat") @ExcludeMissing vat: JsonField<Double> = JsonMissing.of(),
        ) : this(discount, subtotal, total, vat, mutableMapOf())

        /**
         * Total discount amount.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun discount(): Optional<Double> = discount.getOptional("discount")

        /**
         * Total before VAT.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun subtotal(): Optional<Double> = subtotal.getOptional("subtotal")

        /**
         * Grand total.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun total(): Optional<Double> = total.getOptional("total")

        /**
         * Total VAT amount.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun vat(): Optional<Double> = vat.getOptional("vat")

        /**
         * Returns the raw JSON value of [discount].
         *
         * Unlike [discount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("discount") @ExcludeMissing fun _discount(): JsonField<Double> = discount

        /**
         * Returns the raw JSON value of [subtotal].
         *
         * Unlike [subtotal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("subtotal") @ExcludeMissing fun _subtotal(): JsonField<Double> = subtotal

        /**
         * Returns the raw JSON value of [total].
         *
         * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Double> = total

        /**
         * Returns the raw JSON value of [vat].
         *
         * Unlike [vat], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("vat") @ExcludeMissing fun _vat(): JsonField<Double> = vat

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

            /** Returns a mutable builder for constructing an instance of [Totals]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Totals]. */
        class Builder internal constructor() {

            private var discount: JsonField<Double> = JsonMissing.of()
            private var subtotal: JsonField<Double> = JsonMissing.of()
            private var total: JsonField<Double> = JsonMissing.of()
            private var vat: JsonField<Double> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(totals: Totals) = apply {
                discount = totals.discount
                subtotal = totals.subtotal
                total = totals.total
                vat = totals.vat
                additionalProperties = totals.additionalProperties.toMutableMap()
            }

            /** Total discount amount. */
            fun discount(discount: Double) = discount(JsonField.of(discount))

            /**
             * Sets [Builder.discount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.discount] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun discount(discount: JsonField<Double>) = apply { this.discount = discount }

            /** Total before VAT. */
            fun subtotal(subtotal: Double) = subtotal(JsonField.of(subtotal))

            /**
             * Sets [Builder.subtotal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subtotal] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun subtotal(subtotal: JsonField<Double>) = apply { this.subtotal = subtotal }

            /** Grand total. */
            fun total(total: Double) = total(JsonField.of(total))

            /**
             * Sets [Builder.total] to an arbitrary JSON value.
             *
             * You should usually call [Builder.total] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun total(total: JsonField<Double>) = apply { this.total = total }

            /** Total VAT amount. */
            fun vat(vat: Double) = vat(JsonField.of(vat))

            /**
             * Sets [Builder.vat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.vat] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun vat(vat: JsonField<Double>) = apply { this.vat = vat }

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
             * Returns an immutable instance of [Totals].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Totals =
                Totals(discount, subtotal, total, vat, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Totals = apply {
            if (validated) {
                return@apply
            }

            discount()
            subtotal()
            total()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (discount.asKnown().isPresent) 1 else 0) +
                (if (subtotal.asKnown().isPresent) 1 else 0) +
                (if (total.asKnown().isPresent) 1 else 0) +
                (if (vat.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Totals &&
                discount == other.discount &&
                subtotal == other.subtotal &&
                total == other.total &&
                vat == other.vat &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(discount, subtotal, total, vat, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Totals{discount=$discount, subtotal=$subtotal, total=$total, vat=$vat, additionalProperties=$additionalProperties}"
    }

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

        return other is Invoice &&
            id == other.id &&
            business == other.business &&
            conversion == other.conversion &&
            created == other.created &&
            currencyCode == other.currencyCode &&
            customer == other.customer &&
            date == other.date &&
            hasVat == other.hasVat &&
            invoiceNumber == other.invoiceNumber &&
            invoiceUrl == other.invoiceUrl &&
            isCopy == other.isCopy &&
            isReverseCharge == other.isReverseCharge &&
            items == other.items &&
            notes == other.notes &&
            numItems == other.numItems &&
            object_ == other.object_ &&
            taxPoint == other.taxPoint &&
            taxType == other.taxType &&
            totals == other.totals &&
            type == other.type &&
            updated == other.updated &&
            zeroRated == other.zeroRated &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            business,
            conversion,
            created,
            currencyCode,
            customer,
            date,
            hasVat,
            invoiceNumber,
            invoiceUrl,
            isCopy,
            isReverseCharge,
            items,
            notes,
            numItems,
            object_,
            taxPoint,
            taxType,
            totals,
            type,
            updated,
            zeroRated,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Invoice{id=$id, business=$business, conversion=$conversion, created=$created, currencyCode=$currencyCode, customer=$customer, date=$date, hasVat=$hasVat, invoiceNumber=$invoiceNumber, invoiceUrl=$invoiceUrl, isCopy=$isCopy, isReverseCharge=$isReverseCharge, items=$items, notes=$notes, numItems=$numItems, object_=$object_, taxPoint=$taxPoint, taxType=$taxType, totals=$totals, type=$type, updated=$updated, zeroRated=$zeroRated, additionalProperties=$additionalProperties}"
}
