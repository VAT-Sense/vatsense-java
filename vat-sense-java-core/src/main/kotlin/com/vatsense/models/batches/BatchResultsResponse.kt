// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.models.batches

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vatsense.core.ExcludeMissing
import com.vatsense.core.JsonField
import com.vatsense.core.JsonMissing
import com.vatsense.core.JsonValue
import java.util.Collections
import java.util.Objects
import java.util.Optional

/** A page of checked rows, in the API's envelope. */
class BatchResultsResponse
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

    fun code(): Long = code.getRequired("code")

    /** Returns the raw JSON value of [code]. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

    fun data(): Data = data.getRequired("data")

    /** Returns the raw JSON value of [data]. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    fun success(): Boolean = success.getRequired("success")

    /** Returns the raw JSON value of [success]. */
    @JsonProperty("success") @ExcludeMissing fun _success(): JsonField<Boolean> = success

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    /** A page of checked rows. */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<BatchResult>>,
        private val hasMore: JsonField<Boolean>,
        private val nextAfter: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data")
            @ExcludeMissing
            data: JsonField<List<BatchResult>> = JsonMissing.of(),
            @JsonProperty("has_more")
            @ExcludeMissing
            hasMore: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("next_after")
            @ExcludeMissing
            nextAfter: JsonField<Long> = JsonMissing.of(),
        ) : this(data, hasMore, nextAfter, mutableMapOf())

        fun data(): List<BatchResult> = data.getRequired("data")

        /** Returns the raw JSON value of [data]. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<BatchResult>> = data

        fun hasMore(): Boolean = hasMore.getRequired("has_more")

        /** Returns the raw JSON value of [hasMore]. */
        @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

        /** Pass as `after` for the next page while `hasMore` is true. */
        fun nextAfter(): Optional<Long> = nextAfter.getOptional("next_after")

        /** Returns the raw JSON value of [nextAfter]. */
        @JsonProperty("next_after") @ExcludeMissing fun _nextAfter(): JsonField<Long> = nextAfter

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                data == other.data &&
                hasMore == other.hasMore &&
                nextAfter == other.nextAfter &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int = Objects.hash(data, hasMore, nextAfter, additionalProperties)

        override fun toString() =
            "Data{data=$data, hasMore=$hasMore, nextAfter=$nextAfter, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchResultsResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int = Objects.hash(code, data, success, additionalProperties)

    override fun toString() =
        "BatchResultsResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
