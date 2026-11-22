// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.models.batches

import com.vatsense.core.Params
import com.vatsense.core.http.Headers
import com.vatsense.core.http.QueryParams
import java.util.Collections
import java.util.Optional

/** What to do when your requests do not cover the batch. */
enum class BatchShortfall(private val value: String) {
    /** Start nothing and return the quote (the default). */
    WAIT("wait"),
    /** Check what is covered and pause the rest. */
    PAUSE("pause"),
    /** Run into overage, which must already be on in the dashboard. */
    OVERAGE("overage");

    fun asString(): String = value

    override fun toString(): String = value
}

/** A row to check, with optional company details for matching. */
class BatchRow private constructor(private val values: Map<String, String>) {

    fun vatNumber(): String = values.getValue("vat_number")

    fun _values(): Map<String, String> = values

    companion object {

        @JvmStatic fun builder() = Builder()

        /** A row with only a VAT number. */
        @JvmStatic fun of(vatNumber: String): BatchRow = builder().vatNumber(vatNumber).build()
    }

    class Builder internal constructor() {
        private val values = linkedMapOf<String, String>()

        /** The VAT number, with its 2-character country code. Required. */
        fun vatNumber(vatNumber: String) = apply { values["vat_number"] = vatNumber }

        fun countryCode(countryCode: String) = apply { values["country_code"] = countryCode }

        fun companyName(companyName: String) = apply { values["company_name"] = companyName }

        fun address(address: String) = apply { values["address"] = address }

        fun street(street: String) = apply { values["street"] = street }

        fun addressLine2(addressLine2: String) = apply { values["address_line_2"] = addressLine2 }

        fun postcode(postcode: String) = apply { values["postcode"] = postcode }

        fun city(city: String) = apply { values["city"] = city }

        fun build(): BatchRow {
            check(values.containsKey("vat_number")) { "`vatNumber` is required but was not set" }
            return BatchRow(Collections.unmodifiableMap(LinkedHashMap(values)))
        }
    }

    override fun equals(other: Any?): Boolean = other is BatchRow && values == other.values

    override fun hashCode(): Int = values.hashCode()

    override fun toString() = "BatchRow{$values}"
}

/** Shared by the batch params: extra headers and query params, and a JSON body. */
abstract class BatchBaseParams
internal constructor(
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** The JSON body, or empty for a call with none. */
    abstract fun _body(): Optional<Map<String, Any>>

    abstract class Builder<B : Builder<B>> internal constructor() {
        internal var additionalHeaders: Headers.Builder = Headers.builder()
        internal var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @Suppress("UNCHECKED_CAST") private fun self(): B = this as B

        fun putAdditionalHeader(name: String, value: String): B =
            self().apply { additionalHeaders.put(name, value) }

        fun putAdditionalQueryParam(key: String, value: String): B =
            self().apply { additionalQueryParams.put(key, value) }
    }
}

/**
 * Create a batch of VAT numbers and, by default, start checking it. Set exactly one of
 * [Builder.numbers] or [Builder.rows].
 */
class BatchCreateParams
private constructor(
    private val body: Map<String, Any>,
    private val idempotencyKey: String?,
    additionalHeaders: Headers,
    additionalQueryParams: QueryParams,
) : BatchBaseParams(additionalHeaders, additionalQueryParams) {

    fun idempotencyKey(): Optional<String> = Optional.ofNullable(idempotencyKey)

    override fun _body(): Optional<Map<String, Any>> = Optional.of(body)

    override fun _headers(): Headers =
        Headers.builder()
            .apply { idempotencyKey?.let { put("Idempotency-Key", it) } }
            .putAll(super._headers())
            .build()

    companion object {
        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() : BatchBaseParams.Builder<Builder>() {
        private val body = linkedMapOf<String, Any>()
        private var idempotencyKey: String? = null

        /** The VAT numbers to check, each with its 2-character country code. */
        fun numbers(numbers: List<String>) = apply { body["numbers"] = numbers.toList() }

        /** Rows with a VAT number and, for company matching, any of the other details. */
        fun rows(rows: List<BatchRow>) = apply { body["rows"] = rows.map { it._values() } }

        /** Your own label for the batch, at most 255 characters. */
        fun reference(reference: String) = apply { body["reference"] = reference }

        /** Defaults to true. False keeps a draft for 24 hours, to start with `start`. */
        fun start(start: Boolean) = apply { body["start"] = start }

        /** What to do when your requests do not cover the batch (default `WAIT`). */
        fun shortfall(shortfall: BatchShortfall) = apply {
            body["shortfall"] = shortfall.asString()
        }

        /** Defaults to true. With `PAUSE`, continue when your requests renew. */
        fun autoContinue(autoContinue: Boolean) = apply { body["auto_continue"] = autoContinue }

        /** Defaults to false. Send the requester VAT number from your account settings. */
        fun consultation(consultation: Boolean) = apply { body["consultation"] = consultation }

        /**
         * Sent as the `Idempotency-Key` header, at most 64 characters. The same key again returns
         * the batch already made.
         */
        fun idempotencyKey(idempotencyKey: String) = apply { this.idempotencyKey = idempotencyKey }

        fun build(): BatchCreateParams =
            BatchCreateParams(
                Collections.unmodifiableMap(LinkedHashMap(body)),
                idempotencyKey,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }
}

/** Start a draft, with the same options as a create. */
class BatchStartParams
private constructor(
    private val body: Map<String, Any>,
    additionalHeaders: Headers,
    additionalQueryParams: QueryParams,
) : BatchBaseParams(additionalHeaders, additionalQueryParams) {

    override fun _body(): Optional<Map<String, Any>> = Optional.of(body)

    companion object {
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun none(): BatchStartParams = builder().build()
    }

    class Builder internal constructor() : BatchBaseParams.Builder<Builder>() {
        private val body = linkedMapOf<String, Any>()

        fun shortfall(shortfall: BatchShortfall) = apply {
            body["shortfall"] = shortfall.asString()
        }

        fun autoContinue(autoContinue: Boolean) = apply { body["auto_continue"] = autoContinue }

        fun consultation(consultation: Boolean) = apply { body["consultation"] = consultation }

        fun build(): BatchStartParams =
            BatchStartParams(
                Collections.unmodifiableMap(LinkedHashMap(body)),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }
}

/** Continue a paused batch. */
class BatchContinueParams
private constructor(
    private val body: Map<String, Any>,
    additionalHeaders: Headers,
    additionalQueryParams: QueryParams,
) : BatchBaseParams(additionalHeaders, additionalQueryParams) {

    override fun _body(): Optional<Map<String, Any>> = Optional.of(body)

    companion object {
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun none(): BatchContinueParams = builder().build()
    }

    class Builder internal constructor() : BatchBaseParams.Builder<Builder>() {
        private val body = linkedMapOf<String, Any>()

        /** `OVERAGE` runs into overage, which must already be on. */
        fun shortfall(shortfall: BatchShortfall) = apply {
            body["shortfall"] = shortfall.asString()
        }

        fun build(): BatchContinueParams =
            BatchContinueParams(
                Collections.unmodifiableMap(LinkedHashMap(body)),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }
}

/** The account's batches, newest first. */
class BatchListParams private constructor(additionalHeaders: Headers, queryParams: QueryParams) :
    BatchBaseParams(additionalHeaders, queryParams) {

    override fun _body(): Optional<Map<String, Any>> = Optional.empty()

    companion object {
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun none(): BatchListParams = builder().build()
    }

    class Builder internal constructor() : BatchBaseParams.Builder<Builder>() {
        /** The page, from 1. */
        fun page(page: Long) = apply { additionalQueryParams.put("page", page.toString()) }

        /** Batches a page, 1 to 100 (default 25). */
        fun limit(limit: Long) = apply { additionalQueryParams.put("limit", limit.toString()) }

        /** Lists the drafts not yet started instead. */
        fun draftsOnly() = apply { additionalQueryParams.put("status", "draft") }

        fun build(): BatchListParams =
            BatchListParams(additionalHeaders.build(), additionalQueryParams.build())
    }
}

/** A page of a batch's checked rows. */
class BatchResultsParams private constructor(additionalHeaders: Headers, queryParams: QueryParams) :
    BatchBaseParams(additionalHeaders, queryParams) {

    override fun _body(): Optional<Map<String, Any>> = Optional.empty()

    companion object {
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun none(): BatchResultsParams = builder().build()
    }

    class Builder internal constructor() : BatchBaseParams.Builder<Builder>() {
        /** Return rows after this row number (default 0). */
        fun after(after: Long) = apply { additionalQueryParams.put("after", after.toString()) }

        /** Rows a page, 1 to 1,000 (default 100). */
        fun limit(limit: Long) = apply { additionalQueryParams.put("limit", limit.toString()) }

        fun build(): BatchResultsParams =
            BatchResultsParams(additionalHeaders.build(), additionalQueryParams.build())
    }
}

/** For the batch calls that take only an id. */
internal object BatchNoParams : Params {
    override fun _headers(): Headers = Headers.builder().build()

    override fun _queryParams(): QueryParams = QueryParams.builder().build()
}
