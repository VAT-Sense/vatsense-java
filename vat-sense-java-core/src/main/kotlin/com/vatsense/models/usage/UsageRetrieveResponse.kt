// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.usage

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.errors.VatSenseInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UsageRetrieveResponse
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

        /** Returns a mutable builder for constructing an instance of [UsageRetrieveResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UsageRetrieveResponse]. */
    class Builder internal constructor() {

        private var code: JsonField<Long> = JsonMissing.of()
        private var data: JsonField<Data> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(usageRetrieveResponse: UsageRetrieveResponse) = apply {
            code = usageRetrieveResponse.code
            data = usageRetrieveResponse.data
            success = usageRetrieveResponse.success
            additionalProperties = usageRetrieveResponse.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [UsageRetrieveResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UsageRetrieveResponse =
            UsageRetrieveResponse(code, data, success, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): UsageRetrieveResponse = apply {
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
        private val requests: JsonField<Requests>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("requests")
            @ExcludeMissing
            requests: JsonField<Requests> = JsonMissing.of()
        ) : this(requests, mutableMapOf())

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun requests(): Optional<Requests> = requests.getOptional("requests")

        /**
         * Returns the raw JSON value of [requests].
         *
         * Unlike [requests], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("requests") @ExcludeMissing fun _requests(): JsonField<Requests> = requests

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

            private var requests: JsonField<Requests> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                requests = data.requests
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun requests(requests: Requests) = requests(JsonField.of(requests))

            /**
             * Sets [Builder.requests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requests] with a well-typed [Requests] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requests(requests: JsonField<Requests>) = apply { this.requests = requests }

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
            fun build(): Data = Data(requests, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            requests().ifPresent { it.validate() }
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
        internal fun validity(): Int = (requests.asKnown().getOrNull()?.validity() ?: 0)

        class Requests
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val remaining: JsonField<Long>,
            private val total: JsonField<Long>,
            private val used: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("remaining")
                @ExcludeMissing
                remaining: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("used") @ExcludeMissing used: JsonField<Long> = JsonMissing.of(),
            ) : this(remaining, total, used, mutableMapOf())

            /**
             * Requests remaining before the limit is reached.
             *
             * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun remaining(): Optional<Long> = remaining.getOptional("remaining")

            /**
             * Total requests allowed on your plan.
             *
             * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun total(): Optional<Long> = total.getOptional("total")

            /**
             * Requests used in the last 30 days.
             *
             * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun used(): Optional<Long> = used.getOptional("used")

            /**
             * Returns the raw JSON value of [remaining].
             *
             * Unlike [remaining], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("remaining") @ExcludeMissing fun _remaining(): JsonField<Long> = remaining

            /**
             * Returns the raw JSON value of [total].
             *
             * Unlike [total], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

            /**
             * Returns the raw JSON value of [used].
             *
             * Unlike [used], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("used") @ExcludeMissing fun _used(): JsonField<Long> = used

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

                /** Returns a mutable builder for constructing an instance of [Requests]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Requests]. */
            class Builder internal constructor() {

                private var remaining: JsonField<Long> = JsonMissing.of()
                private var total: JsonField<Long> = JsonMissing.of()
                private var used: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(requests: Requests) = apply {
                    remaining = requests.remaining
                    total = requests.total
                    used = requests.used
                    additionalProperties = requests.additionalProperties.toMutableMap()
                }

                /** Requests remaining before the limit is reached. */
                fun remaining(remaining: Long) = remaining(JsonField.of(remaining))

                /**
                 * Sets [Builder.remaining] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.remaining] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun remaining(remaining: JsonField<Long>) = apply { this.remaining = remaining }

                /** Total requests allowed on your plan. */
                fun total(total: Long) = total(JsonField.of(total))

                /**
                 * Sets [Builder.total] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.total] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun total(total: JsonField<Long>) = apply { this.total = total }

                /** Requests used in the last 30 days. */
                fun used(used: Long) = used(JsonField.of(used))

                /**
                 * Sets [Builder.used] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.used] with a well-typed [Long] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun used(used: JsonField<Long>) = apply { this.used = used }

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
                 * Returns an immutable instance of [Requests].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Requests =
                    Requests(remaining, total, used, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Requests = apply {
                if (validated) {
                    return@apply
                }

                remaining()
                total()
                used()
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
                (if (remaining.asKnown().isPresent) 1 else 0) +
                    (if (total.asKnown().isPresent) 1 else 0) +
                    (if (used.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Requests &&
                    remaining == other.remaining &&
                    total == other.total &&
                    used == other.used &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(remaining, total, used, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Requests{remaining=$remaining, total=$total, used=$used, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                requests == other.requests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(requests, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{requests=$requests, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UsageRetrieveResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(code, data, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UsageRetrieveResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
