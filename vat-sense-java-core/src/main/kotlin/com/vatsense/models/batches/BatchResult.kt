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

/** One checked row of a batch, as the CSV report lists it. */
class BatchResult
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val row: JsonField<Long>,
    private val authority: JsonField<String>,
    private val checkedAt: JsonField<String>,
    private val companyAddress: JsonField<String>,
    private val companyName: JsonField<String>,
    private val confirmationNumber: JsonField<String>,
    private val consultationNumber: JsonField<String>,
    private val countryCode: JsonField<String>,
    private val countryUploaded: JsonField<String>,
    private val duplicateOfRow: JsonField<Long>,
    private val match: JsonField<Match>,
    private val reason: JsonField<String>,
    private val repaired: JsonField<Boolean>,
    private val result: JsonField<String>,
    private val vatNumber: JsonField<String>,
    private val vatNumberUploaded: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("row") @ExcludeMissing row: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("authority") @ExcludeMissing authority: JsonField<String> = JsonMissing.of(),
        @JsonProperty("checked_at") @ExcludeMissing checkedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("company_address")
        @ExcludeMissing
        companyAddress: JsonField<String> = JsonMissing.of(),
        @JsonProperty("company_name")
        @ExcludeMissing
        companyName: JsonField<String> = JsonMissing.of(),
        @JsonProperty("confirmation_number")
        @ExcludeMissing
        confirmationNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("consultation_number")
        @ExcludeMissing
        consultationNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_code")
        @ExcludeMissing
        countryCode: JsonField<String> = JsonMissing.of(),
        @JsonProperty("country_uploaded")
        @ExcludeMissing
        countryUploaded: JsonField<String> = JsonMissing.of(),
        @JsonProperty("duplicate_of_row")
        @ExcludeMissing
        duplicateOfRow: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("match") @ExcludeMissing match: JsonField<Match> = JsonMissing.of(),
        @JsonProperty("reason") @ExcludeMissing reason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("repaired") @ExcludeMissing repaired: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vat_number") @ExcludeMissing vatNumber: JsonField<String> = JsonMissing.of(),
        @JsonProperty("vat_number_uploaded")
        @ExcludeMissing
        vatNumberUploaded: JsonField<String> = JsonMissing.of(),
    ) : this(
        row,
        authority,
        checkedAt,
        companyAddress,
        companyName,
        confirmationNumber,
        consultationNumber,
        countryCode,
        countryUploaded,
        duplicateOfRow,
        match,
        reason,
        repaired,
        result,
        vatNumber,
        vatNumberUploaded,
        mutableMapOf(),
    )

    fun row(): Long = row.getRequired("row")

    /** Returns the raw JSON value of [row]. */
    @JsonProperty("row") @ExcludeMissing fun _row(): JsonField<Long> = row

    fun authority(): Optional<String> = authority.getOptional("authority")

    /** Returns the raw JSON value of [authority]. */
    @JsonProperty("authority") @ExcludeMissing fun _authority(): JsonField<String> = authority

    fun checkedAt(): Optional<String> = checkedAt.getOptional("checked_at")

    /** Returns the raw JSON value of [checkedAt]. */
    @JsonProperty("checked_at") @ExcludeMissing fun _checkedAt(): JsonField<String> = checkedAt

    fun companyAddress(): Optional<String> = companyAddress.getOptional("company_address")

    /** Returns the raw JSON value of [companyAddress]. */
    @JsonProperty("company_address")
    @ExcludeMissing
    fun _companyAddress(): JsonField<String> = companyAddress

    fun companyName(): Optional<String> = companyName.getOptional("company_name")

    /** Returns the raw JSON value of [companyName]. */
    @JsonProperty("company_name")
    @ExcludeMissing
    fun _companyName(): JsonField<String> = companyName

    fun confirmationNumber(): Optional<String> =
        confirmationNumber.getOptional("confirmation_number")

    /** Returns the raw JSON value of [confirmationNumber]. */
    @JsonProperty("confirmation_number")
    @ExcludeMissing
    fun _confirmationNumber(): JsonField<String> = confirmationNumber

    fun consultationNumber(): Optional<String> =
        consultationNumber.getOptional("consultation_number")

    /** Returns the raw JSON value of [consultationNumber]. */
    @JsonProperty("consultation_number")
    @ExcludeMissing
    fun _consultationNumber(): JsonField<String> = consultationNumber

    fun countryCode(): Optional<String> = countryCode.getOptional("country_code")

    /** Returns the raw JSON value of [countryCode]. */
    @JsonProperty("country_code")
    @ExcludeMissing
    fun _countryCode(): JsonField<String> = countryCode

    fun countryUploaded(): Optional<String> = countryUploaded.getOptional("country_uploaded")

    /** Returns the raw JSON value of [countryUploaded]. */
    @JsonProperty("country_uploaded")
    @ExcludeMissing
    fun _countryUploaded(): JsonField<String> = countryUploaded

    fun duplicateOfRow(): Optional<Long> = duplicateOfRow.getOptional("duplicate_of_row")

    /** Returns the raw JSON value of [duplicateOfRow]. */
    @JsonProperty("duplicate_of_row")
    @ExcludeMissing
    fun _duplicateOfRow(): JsonField<Long> = duplicateOfRow

    fun match(): Optional<Match> = match.getOptional("match")

    /** Returns the raw JSON value of [match]. */
    @JsonProperty("match") @ExcludeMissing fun _match(): JsonField<Match> = match

    fun reason(): Optional<String> = reason.getOptional("reason")

    /** Returns the raw JSON value of [reason]. */
    @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

    fun repaired(): Optional<Boolean> = repaired.getOptional("repaired")

    /** Returns the raw JSON value of [repaired]. */
    @JsonProperty("repaired") @ExcludeMissing fun _repaired(): JsonField<Boolean> = repaired

    /** Such as `valid` or `invalid`; `pending` while the row is being checked. */
    fun result(): Optional<String> = result.getOptional("result")

    /** Returns the raw JSON value of [result]. */
    @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

    /** The number as it was checked. */
    fun vatNumber(): Optional<String> = vatNumber.getOptional("vat_number")

    /** Returns the raw JSON value of [vatNumber]. */
    @JsonProperty("vat_number") @ExcludeMissing fun _vatNumber(): JsonField<String> = vatNumber

    fun vatNumberUploaded(): Optional<String> = vatNumberUploaded.getOptional("vat_number_uploaded")

    /** Returns the raw JSON value of [vatNumberUploaded]. */
    @JsonProperty("vat_number_uploaded")
    @ExcludeMissing
    fun _vatNumberUploaded(): JsonField<String> = vatNumberUploaded

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    /** The company details matched, when they were sent. */
    class Match
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val fields: JsonField<Map<String, Field>>,
        private val result: JsonField<String>,
        private val score: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("fields")
            @ExcludeMissing
            fields: JsonField<Map<String, Field>> = JsonMissing.of(),
            @JsonProperty("result") @ExcludeMissing result: JsonField<String> = JsonMissing.of(),
            @JsonProperty("score") @ExcludeMissing score: JsonField<Long> = JsonMissing.of(),
        ) : this(fields, result, score, mutableMapOf())

        fun fields(): Optional<Map<String, Field>> = fields.getOptional("fields")

        /** Returns the raw JSON value of [fields]. */
        @JsonProperty("fields")
        @ExcludeMissing
        fun _fields(): JsonField<Map<String, Field>> = fields

        /** `likely`, `possible`, `unlikely` or `not_applicable`. */
        fun result(): Optional<String> = result.getOptional("result")

        /** Returns the raw JSON value of [result]. */
        @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

        fun score(): Optional<Long> = score.getOptional("score")

        /** Returns the raw JSON value of [score]. */
        @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Long> = score

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        /** One detail's comparison. */
        class Field
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val result: JsonField<String>,
            private val score: JsonField<Long>,
            private val sent: JsonField<String>,
            private val vies: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("result")
                @ExcludeMissing
                result: JsonField<String> = JsonMissing.of(),
                @JsonProperty("score") @ExcludeMissing score: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("sent") @ExcludeMissing sent: JsonField<String> = JsonMissing.of(),
                @JsonProperty("vies") @ExcludeMissing vies: JsonField<String> = JsonMissing.of(),
            ) : this(result, score, sent, vies, mutableMapOf())

            fun result(): Optional<String> = result.getOptional("result")

            /** Returns the raw JSON value of [result]. */
            @JsonProperty("result") @ExcludeMissing fun _result(): JsonField<String> = result

            fun score(): Optional<Long> = score.getOptional("score")

            /** Returns the raw JSON value of [score]. */
            @JsonProperty("score") @ExcludeMissing fun _score(): JsonField<Long> = score

            /** The detail as it was sent. */
            fun sent(): Optional<String> = sent.getOptional("sent")

            /** Returns the raw JSON value of [sent]. */
            @JsonProperty("sent") @ExcludeMissing fun _sent(): JsonField<String> = sent

            fun vies(): Optional<String> = vies.getOptional("vies")

            /** Returns the raw JSON value of [vies]. */
            @JsonProperty("vies") @ExcludeMissing fun _vies(): JsonField<String> = vies

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

                return other is Field &&
                    result == other.result &&
                    score == other.score &&
                    sent == other.sent &&
                    vies == other.vies &&
                    additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int =
                Objects.hash(result, score, sent, vies, additionalProperties)

            override fun toString() =
                "Field{result=$result, score=$score, sent=$sent, vies=$vies, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Match &&
                fields == other.fields &&
                result == other.result &&
                score == other.score &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int = Objects.hash(fields, result, score, additionalProperties)

        override fun toString() =
            "Match{fields=$fields, result=$result, score=$score, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BatchResult &&
            row == other.row &&
            authority == other.authority &&
            checkedAt == other.checkedAt &&
            companyAddress == other.companyAddress &&
            companyName == other.companyName &&
            confirmationNumber == other.confirmationNumber &&
            consultationNumber == other.consultationNumber &&
            countryCode == other.countryCode &&
            countryUploaded == other.countryUploaded &&
            duplicateOfRow == other.duplicateOfRow &&
            match == other.match &&
            reason == other.reason &&
            repaired == other.repaired &&
            result == other.result &&
            vatNumber == other.vatNumber &&
            vatNumberUploaded == other.vatNumberUploaded &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int =
        Objects.hash(
            row,
            authority,
            checkedAt,
            companyAddress,
            companyName,
            confirmationNumber,
            consultationNumber,
            countryCode,
            countryUploaded,
            duplicateOfRow,
            match,
            reason,
            repaired,
            result,
            vatNumber,
            vatNumberUploaded,
            additionalProperties,
        )

    override fun toString() =
        "BatchResult{row=$row, authority=$authority, checkedAt=$checkedAt, companyAddress=$companyAddress, companyName=$companyName, confirmationNumber=$confirmationNumber, consultationNumber=$consultationNumber, countryCode=$countryCode, countryUploaded=$countryUploaded, duplicateOfRow=$duplicateOfRow, match=$match, reason=$reason, repaired=$repaired, result=$result, vatNumber=$vatNumber, vatNumberUploaded=$vatNumberUploaded, additionalProperties=$additionalProperties}"
}
