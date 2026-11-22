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

/** A batch, in the API's envelope. */
class BatchResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val code: JsonField<Long>,
    private val data: JsonField<Batch>,
    private val success: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code") @ExcludeMissing code: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Batch> = JsonMissing.of(),
        @JsonProperty("success") @ExcludeMissing success: JsonField<Boolean> = JsonMissing.of(),
    ) : this(code, data, success, mutableMapOf())

    fun code(): Long = code.getRequired("code")

    /** Returns the raw JSON value of [code]. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<Long> = code

    fun data(): Batch = data.getRequired("data")

    /** Returns the raw JSON value of [data]. */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Batch> = data

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchResponse &&
            code == other.code &&
            data == other.data &&
            success == other.success &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int = Objects.hash(code, data, success, additionalProperties)

    override fun toString() =
        "BatchResponse{code=$code, data=$data, success=$success, additionalProperties=$additionalProperties}"
}
