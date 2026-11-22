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

/** A page of batches, in the API's envelope. */
class BatchListResponse
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

    /** A page of batches. */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val data: JsonField<List<Batch>>,
        private val hasMore: JsonField<Boolean>,
        private val limit: JsonField<Long>,
        private val page: JsonField<Long>,
        private val total: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("data") @ExcludeMissing data: JsonField<List<Batch>> = JsonMissing.of(),
            @JsonProperty("has_more")
            @ExcludeMissing
            hasMore: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("page") @ExcludeMissing page: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        ) : this(data, hasMore, limit, page, total, mutableMapOf())

        fun data(): List<Batch> = data.getRequired("data")

        /** Returns the raw JSON value of [data]. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Batch>> = data

        fun hasMore(): Boolean = hasMore.getRequired("has_more")

        /** Returns the raw JSON value of [hasMore]. */
        @JsonProperty("has_more") @ExcludeMissing fun _hasMore(): JsonField<Boolean> = hasMore

        fun limit(): Optional<Long> = limit.getOptional("limit")

        /** Returns the raw JSON value of [limit]. */
        @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

        fun page(): Optional<Long> = page.getOptional("page")

        /** Returns the raw JSON value of [page]. */
        @JsonProperty("page") @ExcludeMissing fun _page(): JsonField<Long> = page

        fun total(): Optional<Long> = total.getOptional("total")

        /** Returns the raw JSON value of [total]. */
        @JsonProperty("total") @ExcludeMissing fun _total(): JsonField<Long> = total

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
                limit == other.limit &&
                page == other.page &&
                total == other.total &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int =
            Objects.hash(data, hasMore, limit, page, total, additionalProperties)

        override fun toString() =
            "Data{data=$data, hasMore=$hasMore, limit=$limit, page=$page, total=$total, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchListResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int = Objects.hash(code, data, success, additionalProperties)

    override fun toString() =
        "BatchListResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
