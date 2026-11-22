// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.services.blocking

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.models.batches.BatchContinueParams
import com.vatsense.models.batches.BatchCreateParams
import com.vatsense.models.batches.BatchDeleteResponse
import com.vatsense.models.batches.BatchListParams
import com.vatsense.models.batches.BatchListResponse
import com.vatsense.models.batches.BatchResponse
import com.vatsense.models.batches.BatchResultsParams
import com.vatsense.models.batches.BatchResultsResponse
import com.vatsense.models.batches.BatchStartParams
import java.util.function.Consumer

/**
 * Bulk validation: check many VAT numbers in one batch.
 *
 * Batch calls are free and work even when your requests are used up; each number a batch checks
 * counts as one request. With a test key a batch is answered from the test numbers, is free and
 * holds at most 1,000 numbers.
 */
interface BatchService {

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService

    /** Create a batch of VAT numbers and, by default, start checking it. */
    fun create(params: BatchCreateParams): BatchResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(params: BatchCreateParams, requestOptions: RequestOptions): BatchResponse

    /** The account's batches, newest first. */
    fun list(): BatchListResponse = list(BatchListParams.none())

    /** @see list */
    fun list(params: BatchListParams): BatchListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(params: BatchListParams, requestOptions: RequestOptions): BatchListResponse

    /** A batch and its progress. Poll until `status` is `complete`, or take the webhook. */
    fun retrieve(batchId: String): BatchResponse = retrieve(batchId, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(batchId: String, requestOptions: RequestOptions): BatchResponse

    /** Delete a draft. A batch that has started cannot be deleted (409). */
    fun delete(batchId: String): BatchDeleteResponse = delete(batchId, RequestOptions.none())

    /** @see delete */
    fun delete(batchId: String, requestOptions: RequestOptions): BatchDeleteResponse

    /** Start a draft. */
    fun start(batchId: String): BatchResponse = start(batchId, BatchStartParams.none())

    /** @see start */
    fun start(batchId: String, params: BatchStartParams): BatchResponse =
        start(batchId, params, RequestOptions.none())

    /** @see start */
    fun start(
        batchId: String,
        params: BatchStartParams,
        requestOptions: RequestOptions,
    ): BatchResponse

    /** Pause a running batch. */
    fun pause(batchId: String): BatchResponse = pause(batchId, RequestOptions.none())

    /** @see pause */
    fun pause(batchId: String, requestOptions: RequestOptions): BatchResponse

    /** Continue a paused batch. */
    fun continueBatch(batchId: String): BatchResponse =
        continueBatch(batchId, BatchContinueParams.none())

    /** @see continueBatch */
    fun continueBatch(batchId: String, params: BatchContinueParams): BatchResponse =
        continueBatch(batchId, params, RequestOptions.none())

    /** @see continueBatch */
    fun continueBatch(
        batchId: String,
        params: BatchContinueParams,
        requestOptions: RequestOptions,
    ): BatchResponse

    /** Mark a paused batch complete, leaving the rest unchecked. */
    fun complete(batchId: String): BatchResponse = complete(batchId, RequestOptions.none())

    /** @see complete */
    fun complete(batchId: String, requestOptions: RequestOptions): BatchResponse

    /** The batch's checked rows as JSON. Follow `nextAfter` while `hasMore` is true. */
    fun results(batchId: String): BatchResultsResponse = results(batchId, BatchResultsParams.none())

    /** @see results */
    fun results(batchId: String, params: BatchResultsParams): BatchResultsResponse =
        results(batchId, params, RequestOptions.none())

    /** @see results */
    fun results(
        batchId: String,
        params: BatchResultsParams,
        requestOptions: RequestOptions,
    ): BatchResultsResponse

    /** The batch's CSV report, the same file the dashboard gives. */
    fun resultsCsv(batchId: String): String = resultsCsv(batchId, RequestOptions.none())

    /** @see resultsCsv */
    fun resultsCsv(batchId: String, requestOptions: RequestOptions): String
}
