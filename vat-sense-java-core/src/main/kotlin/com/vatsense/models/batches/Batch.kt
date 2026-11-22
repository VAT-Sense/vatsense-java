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

/** A batch of VAT numbers checked together. */
class Batch
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val object_: JsonField<String>,
    private val autoContinue: JsonField<Boolean>,
    private val consultation: JsonField<Boolean>,
    private val createdAt: JsonField<String>,
    private val dashboardUrl: JsonField<String>,
    private val estimatedFinishAt: JsonField<String>,
    private val expiresAt: JsonField<String>,
    private val finishedAt: JsonField<String>,
    private val livemode: JsonField<Boolean>,
    private val number: JsonField<Long>,
    private val pauseReason: JsonField<String>,
    private val quote: JsonField<Quote>,
    private val reference: JsonField<String>,
    private val requestsUsed: JsonField<Long>,
    private val results: JsonField<Results>,
    private val rows: JsonField<Rows>,
    private val source: JsonField<String>,
    private val startedAt: JsonField<String>,
    private val status: JsonField<String>,
    private val trial: JsonField<Boolean>,
    private val usesOverage: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonField<String> = JsonMissing.of(),
        @JsonProperty("auto_continue")
        @ExcludeMissing
        autoContinue: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("consultation")
        @ExcludeMissing
        consultation: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("dashboard_url")
        @ExcludeMissing
        dashboardUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("estimated_finish_at")
        @ExcludeMissing
        estimatedFinishAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("expires_at") @ExcludeMissing expiresAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("finished_at")
        @ExcludeMissing
        finishedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("livemode") @ExcludeMissing livemode: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("number") @ExcludeMissing number: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("pause_reason")
        @ExcludeMissing
        pauseReason: JsonField<String> = JsonMissing.of(),
        @JsonProperty("quote") @ExcludeMissing quote: JsonField<Quote> = JsonMissing.of(),
        @JsonProperty("reference") @ExcludeMissing reference: JsonField<String> = JsonMissing.of(),
        @JsonProperty("requests_used")
        @ExcludeMissing
        requestsUsed: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("results") @ExcludeMissing results: JsonField<Results> = JsonMissing.of(),
        @JsonProperty("rows") @ExcludeMissing rows: JsonField<Rows> = JsonMissing.of(),
        @JsonProperty("source") @ExcludeMissing source: JsonField<String> = JsonMissing.of(),
        @JsonProperty("started_at") @ExcludeMissing startedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("trial") @ExcludeMissing trial: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("uses_overage")
        @ExcludeMissing
        usesOverage: JsonField<Boolean> = JsonMissing.of(),
    ) : this(
        id,
        object_,
        autoContinue,
        consultation,
        createdAt,
        dashboardUrl,
        estimatedFinishAt,
        expiresAt,
        finishedAt,
        livemode,
        number,
        pauseReason,
        quote,
        reference,
        requestsUsed,
        results,
        rows,
        source,
        startedAt,
        status,
        trial,
        usesOverage,
        mutableMapOf(),
    )

    /** The batch's 26-character id. */
    fun id(): String = id.getRequired("id")

    /** Returns the raw JSON value of [id]. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** Always `batch`. */
    fun object_(): Optional<String> = object_.getOptional("object")

    /** Returns the raw JSON value of [object_]. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<String> = object_

    fun autoContinue(): Optional<Boolean> = autoContinue.getOptional("auto_continue")

    /** Returns the raw JSON value of [autoContinue]. */
    @JsonProperty("auto_continue")
    @ExcludeMissing
    fun _autoContinue(): JsonField<Boolean> = autoContinue

    fun consultation(): Optional<Boolean> = consultation.getOptional("consultation")

    /** Returns the raw JSON value of [consultation]. */
    @JsonProperty("consultation")
    @ExcludeMissing
    fun _consultation(): JsonField<Boolean> = consultation

    /** When the batch was made. Times are UTC, ISO 8601. */
    fun createdAt(): Optional<String> = createdAt.getOptional("created_at")

    /** Returns the raw JSON value of [createdAt]. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<String> = createdAt

    /** The batch's page in the dashboard; empty for a test batch. */
    fun dashboardUrl(): Optional<String> = dashboardUrl.getOptional("dashboard_url")

    /** Returns the raw JSON value of [dashboardUrl]. */
    @JsonProperty("dashboard_url")
    @ExcludeMissing
    fun _dashboardUrl(): JsonField<String> = dashboardUrl

    fun estimatedFinishAt(): Optional<String> = estimatedFinishAt.getOptional("estimated_finish_at")

    /** Returns the raw JSON value of [estimatedFinishAt]. */
    @JsonProperty("estimated_finish_at")
    @ExcludeMissing
    fun _estimatedFinishAt(): JsonField<String> = estimatedFinishAt

    fun expiresAt(): Optional<String> = expiresAt.getOptional("expires_at")

    /** Returns the raw JSON value of [expiresAt]. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt(): JsonField<String> = expiresAt

    fun finishedAt(): Optional<String> = finishedAt.getOptional("finished_at")

    /** Returns the raw JSON value of [finishedAt]. */
    @JsonProperty("finished_at") @ExcludeMissing fun _finishedAt(): JsonField<String> = finishedAt

    /** False for a test batch, made with a test key. */
    fun livemode(): Optional<Boolean> = livemode.getOptional("livemode")

    /** Returns the raw JSON value of [livemode]. */
    @JsonProperty("livemode") @ExcludeMissing fun _livemode(): JsonField<Boolean> = livemode

    fun number(): Optional<Long> = number.getOptional("number")

    /** Returns the raw JSON value of [number]. */
    @JsonProperty("number") @ExcludeMissing fun _number(): JsonField<Long> = number

    fun pauseReason(): Optional<String> = pauseReason.getOptional("pause_reason")

    /** Returns the raw JSON value of [pauseReason]. */
    @JsonProperty("pause_reason")
    @ExcludeMissing
    fun _pauseReason(): JsonField<String> = pauseReason

    /** For drafts and paused batches. */
    fun quote(): Optional<Quote> = quote.getOptional("quote")

    /** Returns the raw JSON value of [quote]. */
    @JsonProperty("quote") @ExcludeMissing fun _quote(): JsonField<Quote> = quote

    fun reference(): Optional<String> = reference.getOptional("reference")

    /** Returns the raw JSON value of [reference]. */
    @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

    fun requestsUsed(): Optional<Long> = requestsUsed.getOptional("requests_used")

    /** Returns the raw JSON value of [requestsUsed]. */
    @JsonProperty("requests_used")
    @ExcludeMissing
    fun _requestsUsed(): JsonField<Long> = requestsUsed

    fun results(): Optional<Results> = results.getOptional("results")

    /** Returns the raw JSON value of [results]. */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<Results> = results

    fun rows(): Optional<Rows> = rows.getOptional("rows")

    /** Returns the raw JSON value of [rows]. */
    @JsonProperty("rows") @ExcludeMissing fun _rows(): JsonField<Rows> = rows

    fun source(): Optional<String> = source.getOptional("source")

    /** Returns the raw JSON value of [source]. */
    @JsonProperty("source") @ExcludeMissing fun _source(): JsonField<String> = source

    fun startedAt(): Optional<String> = startedAt.getOptional("started_at")

    /** Returns the raw JSON value of [startedAt]. */
    @JsonProperty("started_at") @ExcludeMissing fun _startedAt(): JsonField<String> = startedAt

    /** `draft`, `queued`, `processing`, `paused`, `complete` or `expired`. */
    fun status(): Optional<String> = status.getOptional("status")

    /** Returns the raw JSON value of [status]. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    fun trial(): Optional<Boolean> = trial.getOptional("trial")

    /** Returns the raw JSON value of [trial]. */
    @JsonProperty("trial") @ExcludeMissing fun _trial(): JsonField<Boolean> = trial

    fun usesOverage(): Optional<Boolean> = usesOverage.getOptional("uses_overage")

    /** Returns the raw JSON value of [usesOverage]. */
    @JsonProperty("uses_overage")
    @ExcludeMissing
    fun _usesOverage(): JsonField<Boolean> = usesOverage

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    /** Row counts. */
    class Rows
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val done: JsonField<Long>,
        private val toCheck: JsonField<Long>,
        private val total: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("done") @ExcludeMissing done: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("to_check") @ExcludeMissing toCheck: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total") @ExcludeMissing total: JsonField<Long> = JsonMissing.of(),
        ) : this(done, toCheck, total, mutableMapOf())

        /** Rows checked so far. */
        fun done(): Optional<Long> = done.getOptional("done")

        /** Returns the raw JSON value of [done]. */
        @JsonProperty("done") @ExcludeMissing fun _done(): JsonField<Long> = done

        /** Rows that will be sent for checking. */
        fun toCheck(): Optional<Long> = toCheck.getOptional("to_check")

        /** Returns the raw JSON value of [toCheck]. */
        @JsonProperty("to_check") @ExcludeMissing fun _toCheck(): JsonField<Long> = toCheck

        /** Rows in the batch. */
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

            return other is Rows &&
                done == other.done &&
                toCheck == other.toCheck &&
                total == other.total &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int = Objects.hash(done, toCheck, total, additionalProperties)

        override fun toString() =
            "Rows{done=$done, toCheck=$toCheck, total=$total, additionalProperties=$additionalProperties}"
    }

    /** Rows by result. */
    class Results
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val duplicate: JsonField<Long>,
        private val invalid: JsonField<Long>,
        private val notChecked: JsonField<Long>,
        private val repaired: JsonField<Long>,
        private val retrying: JsonField<Long>,
        private val unsupported: JsonField<Long>,
        private val valid: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("duplicate")
            @ExcludeMissing
            duplicate: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("invalid") @ExcludeMissing invalid: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("not_checked")
            @ExcludeMissing
            notChecked: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("repaired") @ExcludeMissing repaired: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("retrying") @ExcludeMissing retrying: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unsupported")
            @ExcludeMissing
            unsupported: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("valid") @ExcludeMissing valid: JsonField<Long> = JsonMissing.of(),
        ) : this(
            duplicate,
            invalid,
            notChecked,
            repaired,
            retrying,
            unsupported,
            valid,
            mutableMapOf(),
        )

        fun duplicate(): Optional<Long> = duplicate.getOptional("duplicate")

        /** Returns the raw JSON value of [duplicate]. */
        @JsonProperty("duplicate") @ExcludeMissing fun _duplicate(): JsonField<Long> = duplicate

        fun invalid(): Optional<Long> = invalid.getOptional("invalid")

        /** Returns the raw JSON value of [invalid]. */
        @JsonProperty("invalid") @ExcludeMissing fun _invalid(): JsonField<Long> = invalid

        fun notChecked(): Optional<Long> = notChecked.getOptional("not_checked")

        /** Returns the raw JSON value of [notChecked]. */
        @JsonProperty("not_checked") @ExcludeMissing fun _notChecked(): JsonField<Long> = notChecked

        fun repaired(): Optional<Long> = repaired.getOptional("repaired")

        /** Returns the raw JSON value of [repaired]. */
        @JsonProperty("repaired") @ExcludeMissing fun _repaired(): JsonField<Long> = repaired

        fun retrying(): Optional<Long> = retrying.getOptional("retrying")

        /** Returns the raw JSON value of [retrying]. */
        @JsonProperty("retrying") @ExcludeMissing fun _retrying(): JsonField<Long> = retrying

        fun unsupported(): Optional<Long> = unsupported.getOptional("unsupported")

        /** Returns the raw JSON value of [unsupported]. */
        @JsonProperty("unsupported")
        @ExcludeMissing
        fun _unsupported(): JsonField<Long> = unsupported

        fun valid(): Optional<Long> = valid.getOptional("valid")

        /** Returns the raw JSON value of [valid]. */
        @JsonProperty("valid") @ExcludeMissing fun _valid(): JsonField<Long> = valid

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

            return other is Results &&
                duplicate == other.duplicate &&
                invalid == other.invalid &&
                notChecked == other.notChecked &&
                repaired == other.repaired &&
                retrying == other.retrying &&
                unsupported == other.unsupported &&
                valid == other.valid &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int =
            Objects.hash(
                duplicate,
                invalid,
                notChecked,
                repaired,
                retrying,
                unsupported,
                valid,
                additionalProperties,
            )

        override fun toString() =
            "Results{duplicate=$duplicate, invalid=$invalid, notChecked=$notChecked, repaired=$repaired, retrying=$retrying, unsupported=$unsupported, valid=$valid, additionalProperties=$additionalProperties}"
    }

    /** What the batch needs, for drafts and paused batches. */
    class Quote
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val covered: JsonField<Boolean>,
        private val overageOn: JsonField<Boolean>,
        private val renewsAt: JsonField<String>,
        private val requestsLeft: JsonField<Long>,
        private val requestsNeeded: JsonField<Long>,
        private val shortfall: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("covered") @ExcludeMissing covered: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("overage_on")
            @ExcludeMissing
            overageOn: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("renews_at")
            @ExcludeMissing
            renewsAt: JsonField<String> = JsonMissing.of(),
            @JsonProperty("requests_left")
            @ExcludeMissing
            requestsLeft: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("requests_needed")
            @ExcludeMissing
            requestsNeeded: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("shortfall") @ExcludeMissing shortfall: JsonField<Long> = JsonMissing.of(),
        ) : this(
            covered,
            overageOn,
            renewsAt,
            requestsLeft,
            requestsNeeded,
            shortfall,
            mutableMapOf(),
        )

        /** Whether the requests left cover the batch. */
        fun covered(): Optional<Boolean> = covered.getOptional("covered")

        /** Returns the raw JSON value of [covered]. */
        @JsonProperty("covered") @ExcludeMissing fun _covered(): JsonField<Boolean> = covered

        fun overageOn(): Optional<Boolean> = overageOn.getOptional("overage_on")

        /** Returns the raw JSON value of [overageOn]. */
        @JsonProperty("overage_on") @ExcludeMissing fun _overageOn(): JsonField<Boolean> = overageOn

        fun renewsAt(): Optional<String> = renewsAt.getOptional("renews_at")

        /** Returns the raw JSON value of [renewsAt]. */
        @JsonProperty("renews_at") @ExcludeMissing fun _renewsAt(): JsonField<String> = renewsAt

        fun requestsLeft(): Optional<Long> = requestsLeft.getOptional("requests_left")

        /** Returns the raw JSON value of [requestsLeft]. */
        @JsonProperty("requests_left")
        @ExcludeMissing
        fun _requestsLeft(): JsonField<Long> = requestsLeft

        fun requestsNeeded(): Optional<Long> = requestsNeeded.getOptional("requests_needed")

        /** Returns the raw JSON value of [requestsNeeded]. */
        @JsonProperty("requests_needed")
        @ExcludeMissing
        fun _requestsNeeded(): JsonField<Long> = requestsNeeded

        fun shortfall(): Optional<Long> = shortfall.getOptional("shortfall")

        /** Returns the raw JSON value of [shortfall]. */
        @JsonProperty("shortfall") @ExcludeMissing fun _shortfall(): JsonField<Long> = shortfall

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

            return other is Quote &&
                covered == other.covered &&
                overageOn == other.overageOn &&
                renewsAt == other.renewsAt &&
                requestsLeft == other.requestsLeft &&
                requestsNeeded == other.requestsNeeded &&
                shortfall == other.shortfall &&
                additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int =
            Objects.hash(
                covered,
                overageOn,
                renewsAt,
                requestsLeft,
                requestsNeeded,
                shortfall,
                additionalProperties,
            )

        override fun toString() =
            "Quote{covered=$covered, overageOn=$overageOn, renewsAt=$renewsAt, requestsLeft=$requestsLeft, requestsNeeded=$requestsNeeded, shortfall=$shortfall, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Batch &&
            id == other.id &&
            object_ == other.object_ &&
            autoContinue == other.autoContinue &&
            consultation == other.consultation &&
            createdAt == other.createdAt &&
            dashboardUrl == other.dashboardUrl &&
            estimatedFinishAt == other.estimatedFinishAt &&
            expiresAt == other.expiresAt &&
            finishedAt == other.finishedAt &&
            livemode == other.livemode &&
            number == other.number &&
            pauseReason == other.pauseReason &&
            quote == other.quote &&
            reference == other.reference &&
            requestsUsed == other.requestsUsed &&
            results == other.results &&
            rows == other.rows &&
            source == other.source &&
            startedAt == other.startedAt &&
            status == other.status &&
            trial == other.trial &&
            usesOverage == other.usesOverage &&
            additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int =
        Objects.hash(
            id,
            object_,
            autoContinue,
            consultation,
            createdAt,
            dashboardUrl,
            estimatedFinishAt,
            expiresAt,
            finishedAt,
            livemode,
            number,
            pauseReason,
            quote,
            reference,
            requestsUsed,
            results,
            rows,
            source,
            startedAt,
            status,
            trial,
            usesOverage,
            additionalProperties,
        )

    override fun toString() =
        "Batch{id=$id, object_=$object_, autoContinue=$autoContinue, consultation=$consultation, createdAt=$createdAt, dashboardUrl=$dashboardUrl, estimatedFinishAt=$estimatedFinishAt, expiresAt=$expiresAt, finishedAt=$finishedAt, livemode=$livemode, number=$number, pauseReason=$pauseReason, quote=$quote, reference=$reference, requestsUsed=$requestsUsed, results=$results, rows=$rows, source=$source, startedAt=$startedAt, status=$status, trial=$trial, usesOverage=$usesOverage, additionalProperties=$additionalProperties}"
}
