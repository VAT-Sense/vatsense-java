// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice.item

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vat_sense.api.core.ExcludeMissing
import com.vat_sense.api.core.JsonField
import com.vat_sense.api.core.JsonMissing
import com.vat_sense.api.core.JsonValue
import com.vat_sense.api.core.checkRequired
import com.vat_sense.api.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

class InvoiceItemInput
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val item: JsonField<String>,
    private val priceEach: JsonField<Double>,
    private val quantity: JsonField<Double>,
    private val vatRate: JsonField<Double>,
    private val discountRate: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("item") @ExcludeMissing item: JsonField<String> = JsonMissing.of(),
        @JsonProperty("price_each") @ExcludeMissing priceEach: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("vat_rate") @ExcludeMissing vatRate: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("discount_rate")
        @ExcludeMissing
        discountRate: JsonField<Double> = JsonMissing.of(),
    ) : this(item, priceEach, quantity, vatRate, discountRate, mutableMapOf())

    /**
     * The description of the line item.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun item(): String = item.getRequired("item")

    /**
     * The price per item. Must be a decimal with 2 decimal places.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun priceEach(): Double = priceEach.getRequired("price_each")

    /**
     * The quantity of the item.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun quantity(): Double = quantity.getRequired("quantity")

    /**
     * A percentage VAT rate for this item.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vatRate(): Double = vatRate.getRequired("vat_rate")

    /**
     * A percentage discount to apply to the price.
     *
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun discountRate(): Optional<Double> = discountRate.getOptional("discount_rate")

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<String> = item

    /**
     * Returns the raw JSON value of [priceEach].
     *
     * Unlike [priceEach], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price_each") @ExcludeMissing fun _priceEach(): JsonField<Double> = priceEach

    /**
     * Returns the raw JSON value of [quantity].
     *
     * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Double> = quantity

    /**
     * Returns the raw JSON value of [vatRate].
     *
     * Unlike [vatRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vat_rate") @ExcludeMissing fun _vatRate(): JsonField<Double> = vatRate

    /**
     * Returns the raw JSON value of [discountRate].
     *
     * Unlike [discountRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("discount_rate")
    @ExcludeMissing
    fun _discountRate(): JsonField<Double> = discountRate

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
         * Returns a mutable builder for constructing an instance of [InvoiceItemInput].
         *
         * The following fields are required:
         * ```java
         * .item()
         * .priceEach()
         * .quantity()
         * .vatRate()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvoiceItemInput]. */
    class Builder internal constructor() {

        private var item: JsonField<String>? = null
        private var priceEach: JsonField<Double>? = null
        private var quantity: JsonField<Double>? = null
        private var vatRate: JsonField<Double>? = null
        private var discountRate: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invoiceItemInput: InvoiceItemInput) = apply {
            item = invoiceItemInput.item
            priceEach = invoiceItemInput.priceEach
            quantity = invoiceItemInput.quantity
            vatRate = invoiceItemInput.vatRate
            discountRate = invoiceItemInput.discountRate
            additionalProperties = invoiceItemInput.additionalProperties.toMutableMap()
        }

        /** The description of the line item. */
        fun item(item: String) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun item(item: JsonField<String>) = apply { this.item = item }

        /** The price per item. Must be a decimal with 2 decimal places. */
        fun priceEach(priceEach: Double) = priceEach(JsonField.of(priceEach))

        /**
         * Sets [Builder.priceEach] to an arbitrary JSON value.
         *
         * You should usually call [Builder.priceEach] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun priceEach(priceEach: JsonField<Double>) = apply { this.priceEach = priceEach }

        /** The quantity of the item. */
        fun quantity(quantity: Double) = quantity(JsonField.of(quantity))

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Double>) = apply { this.quantity = quantity }

        /** A percentage VAT rate for this item. */
        fun vatRate(vatRate: Double) = vatRate(JsonField.of(vatRate))

        /**
         * Sets [Builder.vatRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vatRate] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vatRate(vatRate: JsonField<Double>) = apply { this.vatRate = vatRate }

        /** A percentage discount to apply to the price. */
        fun discountRate(discountRate: Double) = discountRate(JsonField.of(discountRate))

        /**
         * Sets [Builder.discountRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.discountRate] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun discountRate(discountRate: JsonField<Double>) = apply {
            this.discountRate = discountRate
        }

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
         * Returns an immutable instance of [InvoiceItemInput].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .item()
         * .priceEach()
         * .quantity()
         * .vatRate()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InvoiceItemInput =
            InvoiceItemInput(
                checkRequired("item", item),
                checkRequired("priceEach", priceEach),
                checkRequired("quantity", quantity),
                checkRequired("vatRate", vatRate),
                discountRate,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InvoiceItemInput = apply {
        if (validated) {
            return@apply
        }

        item()
        priceEach()
        quantity()
        vatRate()
        discountRate()
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
        (if (item.asKnown().isPresent) 1 else 0) +
            (if (priceEach.asKnown().isPresent) 1 else 0) +
            (if (quantity.asKnown().isPresent) 1 else 0) +
            (if (vatRate.asKnown().isPresent) 1 else 0) +
            (if (discountRate.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvoiceItemInput &&
            item == other.item &&
            priceEach == other.priceEach &&
            quantity == other.quantity &&
            vatRate == other.vatRate &&
            discountRate == other.discountRate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(item, priceEach, quantity, vatRate, discountRate, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InvoiceItemInput{item=$item, priceEach=$priceEach, quantity=$quantity, vatRate=$vatRate, discountRate=$discountRate, additionalProperties=$additionalProperties}"
}
