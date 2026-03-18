// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice.item

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

class InvoiceItem
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val discountRate: JsonField<Double>,
    private val item: JsonField<String>,
    private val object_: JsonField<Object>,
    private val priceEach: JsonField<Double>,
    private val priceTotal: JsonField<Double>,
    private val quantity: JsonField<Double>,
    private val vatRate: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("discount_rate")
        @ExcludeMissing
        discountRate: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("item") @ExcludeMissing item: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<Object> = JsonMissing.of(),
        @JsonProperty("price_each") @ExcludeMissing priceEach: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("price_total")
        @ExcludeMissing
        priceTotal: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("quantity") @ExcludeMissing quantity: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("vat_rate") @ExcludeMissing vatRate: JsonField<Double> = JsonMissing.of(),
    ) : this(
        id,
        discountRate,
        item,
        object_,
        priceEach,
        priceTotal,
        quantity,
        vatRate,
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
    fun discountRate(): Optional<Double> = discountRate.getOptional("discount_rate")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun item(): Optional<String> = item.getOptional("item")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun object_(): Optional<Object> = object_.getOptional("object")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun priceEach(): Optional<Double> = priceEach.getOptional("price_each")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun priceTotal(): Optional<Double> = priceTotal.getOptional("price_total")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun quantity(): Optional<Double> = quantity.getOptional("quantity")

    /**
     * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun vatRate(): Optional<Double> = vatRate.getOptional("vat_rate")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [discountRate].
     *
     * Unlike [discountRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("discount_rate")
    @ExcludeMissing
    fun _discountRate(): JsonField<Double> = discountRate

    /**
     * Returns the raw JSON value of [item].
     *
     * Unlike [item], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("item") @ExcludeMissing fun _item(): JsonField<String> = item

    /**
     * Returns the raw JSON value of [object_].
     *
     * Unlike [object_], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /**
     * Returns the raw JSON value of [priceEach].
     *
     * Unlike [priceEach], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price_each") @ExcludeMissing fun _priceEach(): JsonField<Double> = priceEach

    /**
     * Returns the raw JSON value of [priceTotal].
     *
     * Unlike [priceTotal], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("price_total") @ExcludeMissing fun _priceTotal(): JsonField<Double> = priceTotal

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

        /** Returns a mutable builder for constructing an instance of [InvoiceItem]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InvoiceItem]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var discountRate: JsonField<Double> = JsonMissing.of()
        private var item: JsonField<String> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var priceEach: JsonField<Double> = JsonMissing.of()
        private var priceTotal: JsonField<Double> = JsonMissing.of()
        private var quantity: JsonField<Double> = JsonMissing.of()
        private var vatRate: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(invoiceItem: InvoiceItem) = apply {
            id = invoiceItem.id
            discountRate = invoiceItem.discountRate
            item = invoiceItem.item
            object_ = invoiceItem.object_
            priceEach = invoiceItem.priceEach
            priceTotal = invoiceItem.priceTotal
            quantity = invoiceItem.quantity
            vatRate = invoiceItem.vatRate
            additionalProperties = invoiceItem.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun discountRate(discountRate: Double?) = discountRate(JsonField.ofNullable(discountRate))

        /**
         * Alias for [Builder.discountRate].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun discountRate(discountRate: Double) = discountRate(discountRate as Double?)

        /** Alias for calling [Builder.discountRate] with `discountRate.orElse(null)`. */
        fun discountRate(discountRate: Optional<Double>) = discountRate(discountRate.getOrNull())

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

        fun item(item: String) = item(JsonField.of(item))

        /**
         * Sets [Builder.item] to an arbitrary JSON value.
         *
         * You should usually call [Builder.item] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun item(item: JsonField<String>) = apply { this.item = item }

        fun object_(object_: Object) = object_(JsonField.of(object_))

        /**
         * Sets [Builder.object_] to an arbitrary JSON value.
         *
         * You should usually call [Builder.object_] with a well-typed [Object] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        fun priceEach(priceEach: Double) = priceEach(JsonField.of(priceEach))

        /**
         * Sets [Builder.priceEach] to an arbitrary JSON value.
         *
         * You should usually call [Builder.priceEach] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun priceEach(priceEach: JsonField<Double>) = apply { this.priceEach = priceEach }

        fun priceTotal(priceTotal: Double) = priceTotal(JsonField.of(priceTotal))

        /**
         * Sets [Builder.priceTotal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.priceTotal] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun priceTotal(priceTotal: JsonField<Double>) = apply { this.priceTotal = priceTotal }

        fun quantity(quantity: Double) = quantity(JsonField.of(quantity))

        /**
         * Sets [Builder.quantity] to an arbitrary JSON value.
         *
         * You should usually call [Builder.quantity] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun quantity(quantity: JsonField<Double>) = apply { this.quantity = quantity }

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
         * Returns an immutable instance of [InvoiceItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InvoiceItem =
            InvoiceItem(
                id,
                discountRate,
                item,
                object_,
                priceEach,
                priceTotal,
                quantity,
                vatRate,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InvoiceItem = apply {
        if (validated) {
            return@apply
        }

        id()
        discountRate()
        item()
        object_().ifPresent { it.validate() }
        priceEach()
        priceTotal()
        quantity()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (discountRate.asKnown().isPresent) 1 else 0) +
            (if (item.asKnown().isPresent) 1 else 0) +
            (object_.asKnown().getOrNull()?.validity() ?: 0) +
            (if (priceEach.asKnown().isPresent) 1 else 0) +
            (if (priceTotal.asKnown().isPresent) 1 else 0) +
            (if (quantity.asKnown().isPresent) 1 else 0) +
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

            @JvmField val ITEM = of("item")

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        /** An enum containing [Object]'s known values. */
        enum class Known {
            ITEM
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
            ITEM,
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
                ITEM -> Value.ITEM
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
                ITEM -> Known.ITEM
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvoiceItem &&
            id == other.id &&
            discountRate == other.discountRate &&
            item == other.item &&
            object_ == other.object_ &&
            priceEach == other.priceEach &&
            priceTotal == other.priceTotal &&
            quantity == other.quantity &&
            vatRate == other.vatRate &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            discountRate,
            item,
            object_,
            priceEach,
            priceTotal,
            quantity,
            vatRate,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InvoiceItem{id=$id, discountRate=$discountRate, item=$item, object_=$object_, priceEach=$priceEach, priceTotal=$priceTotal, quantity=$quantity, vatRate=$vatRate, additionalProperties=$additionalProperties}"
}
