// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.sandbox

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import com.vatsense.core.checkKnown
import com.vatsense.core.toImmutable
import com.vatsense.errors.VatSenseInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class SandboxGenerateKeyResponse
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

        /**
         * Returns a mutable builder for constructing an instance of [SandboxGenerateKeyResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SandboxGenerateKeyResponse]. */
    class Builder internal constructor() {

        private var code: JsonField<Long> = JsonMissing.of()
        private var data: JsonField<Data> = JsonMissing.of()
        private var success: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(sandboxGenerateKeyResponse: SandboxGenerateKeyResponse) = apply {
            code = sandboxGenerateKeyResponse.code
            data = sandboxGenerateKeyResponse.data
            success = sandboxGenerateKeyResponse.success
            additionalProperties = sandboxGenerateKeyResponse.additionalProperties.toMutableMap()
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
         * Returns an immutable instance of [SandboxGenerateKeyResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SandboxGenerateKeyResponse =
            SandboxGenerateKeyResponse(code, data, success, additionalProperties.toMutableMap())
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
    fun validate(): SandboxGenerateKeyResponse = apply {
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
        private val allowedEndpoints: JsonField<List<String>>,
        private val expiresAt: JsonField<OffsetDateTime>,
        private val key: JsonField<String>,
        private val requestsRemaining: JsonField<Long>,
        private val signupUrl: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("allowed_endpoints")
            @ExcludeMissing
            allowedEndpoints: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("expires_at")
            @ExcludeMissing
            expiresAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("key") @ExcludeMissing key: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requests_remaining")
            @ExcludeMissing
            requestsRemaining: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("signup_url")
            @ExcludeMissing
            signupUrl: JsonField<String> = JsonMissing.of(),
        ) : this(allowedEndpoints, expiresAt, key, requestsRemaining, signupUrl, mutableMapOf())

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun allowedEndpoints(): Optional<List<String>> =
            allowedEndpoints.getOptional("allowed_endpoints")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun expiresAt(): Optional<OffsetDateTime> = expiresAt.getOptional("expires_at")

        /**
         * The temporary sandbox API key.
         *
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun key(): Optional<String> = key.getOptional("key")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun requestsRemaining(): Optional<Long> =
            requestsRemaining.getOptional("requests_remaining")

        /**
         * @throws VatSenseInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun signupUrl(): Optional<String> = signupUrl.getOptional("signup_url")

        /**
         * Returns the raw JSON value of [allowedEndpoints].
         *
         * Unlike [allowedEndpoints], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_endpoints")
        @ExcludeMissing
        fun _allowedEndpoints(): JsonField<List<String>> = allowedEndpoints

        /**
         * Returns the raw JSON value of [expiresAt].
         *
         * Unlike [expiresAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun _expiresAt(): JsonField<OffsetDateTime> = expiresAt

        /**
         * Returns the raw JSON value of [key].
         *
         * Unlike [key], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("key") @ExcludeMissing fun _key(): JsonField<String> = key

        /**
         * Returns the raw JSON value of [requestsRemaining].
         *
         * Unlike [requestsRemaining], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("requests_remaining")
        @ExcludeMissing
        fun _requestsRemaining(): JsonField<Long> = requestsRemaining

        /**
         * Returns the raw JSON value of [signupUrl].
         *
         * Unlike [signupUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("signup_url") @ExcludeMissing fun _signupUrl(): JsonField<String> = signupUrl

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

            private var allowedEndpoints: JsonField<MutableList<String>>? = null
            private var expiresAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var key: JsonField<String> = JsonMissing.of()
            private var requestsRemaining: JsonField<Long> = JsonMissing.of()
            private var signupUrl: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                allowedEndpoints = data.allowedEndpoints.map { it.toMutableList() }
                expiresAt = data.expiresAt
                key = data.key
                requestsRemaining = data.requestsRemaining
                signupUrl = data.signupUrl
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun allowedEndpoints(allowedEndpoints: List<String>) =
                allowedEndpoints(JsonField.of(allowedEndpoints))

            /**
             * Sets [Builder.allowedEndpoints] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedEndpoints] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun allowedEndpoints(allowedEndpoints: JsonField<List<String>>) = apply {
                this.allowedEndpoints = allowedEndpoints.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [allowedEndpoints].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedEndpoint(allowedEndpoint: String) = apply {
                allowedEndpoints =
                    (allowedEndpoints ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedEndpoints", it).add(allowedEndpoint)
                    }
            }

            fun expiresAt(expiresAt: OffsetDateTime) = expiresAt(JsonField.of(expiresAt))

            /**
             * Sets [Builder.expiresAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresAt(expiresAt: JsonField<OffsetDateTime>) = apply {
                this.expiresAt = expiresAt
            }

            /** The temporary sandbox API key. */
            fun key(key: String) = key(JsonField.of(key))

            /**
             * Sets [Builder.key] to an arbitrary JSON value.
             *
             * You should usually call [Builder.key] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun key(key: JsonField<String>) = apply { this.key = key }

            fun requestsRemaining(requestsRemaining: Long) =
                requestsRemaining(JsonField.of(requestsRemaining))

            /**
             * Sets [Builder.requestsRemaining] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestsRemaining] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestsRemaining(requestsRemaining: JsonField<Long>) = apply {
                this.requestsRemaining = requestsRemaining
            }

            fun signupUrl(signupUrl: String) = signupUrl(JsonField.of(signupUrl))

            /**
             * Sets [Builder.signupUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.signupUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun signupUrl(signupUrl: JsonField<String>) = apply { this.signupUrl = signupUrl }

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
                Data(
                    (allowedEndpoints ?: JsonMissing.of()).map { it.toImmutable() },
                    expiresAt,
                    key,
                    requestsRemaining,
                    signupUrl,
                    additionalProperties.toMutableMap(),
                )
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

            allowedEndpoints()
            expiresAt()
            key()
            requestsRemaining()
            signupUrl()
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
            (allowedEndpoints.asKnown().getOrNull()?.size ?: 0) +
                (if (expiresAt.asKnown().isPresent) 1 else 0) +
                (if (key.asKnown().isPresent) 1 else 0) +
                (if (requestsRemaining.asKnown().isPresent) 1 else 0) +
                (if (signupUrl.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                allowedEndpoints == other.allowedEndpoints &&
                expiresAt == other.expiresAt &&
                key == other.key &&
                requestsRemaining == other.requestsRemaining &&
                signupUrl == other.signupUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                allowedEndpoints,
                expiresAt,
                key,
                requestsRemaining,
                signupUrl,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{allowedEndpoints=$allowedEndpoints, expiresAt=$expiresAt, key=$key, requestsRemaining=$requestsRemaining, signupUrl=$signupUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SandboxGenerateKeyResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(code, data, success, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SandboxGenerateKeyResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
