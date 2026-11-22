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

/** A deleted draft, in the API's envelope. */
class BatchDeleteResponse
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

    /** The deleted draft. */
    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val deleted: JsonField<Boolean>,
        private val object_: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("deleted") @ExcludeMissing deleted: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        ) : this(id, deleted, object_, mutableMapOf())

        fun id(): String = id.getRequired("id")

        /** Returns the raw JSON value of [id]. */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        fun deleted(): Boolean = deleted.getRequired("deleted")

        /** Returns the raw JSON value of [deleted]. */
        @JsonProperty("deleted") @ExcludeMissing fun _deleted(): JsonField<Boolean> = deleted

        fun object_(): Optional<String> = object_.getOptional("object")

        /** Returns the raw JSON value of [object_]. */
        @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

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
                id == other.id &&
                deleted == other.deleted &&
                object_ == other.object_ &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int = Objects.hash(id, deleted, object_, additionalProperties)

        override fun toString() =
            "Data{id=$id, deleted=$deleted, object_=$object_, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchDeleteResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int = Objects.hash(code, data, success, additionalProperties)

    override fun toString() =
        "BatchDeleteResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
