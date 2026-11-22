// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.services.async

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
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/**
 * Bulk validation: check many VAT numbers in one batch.
 *
 * Batch calls are free and work even when your requests are used up; each number a batch checks
 * counts as one request. With a test key a batch is answered from the test numbers, is free and
 * holds at most 1,000 numbers.
 */
interface BatchServiceAsync {

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchServiceAsync

    /** Create a batch of VAT numbers and, by default, start checking it. */
    fun create(params: BatchCreateParams): CompletableFuture<BatchResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchResponse>

    /** The account's batches, newest first. */
    fun list(): CompletableFuture<BatchListResponse> = list(BatchListParams.none())

    /** @see list */
    fun list(params: BatchListParams): CompletableFuture<BatchListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: BatchListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchListResponse>

    /** A batch and its progress. Poll until `status` is `complete`, or take the webhook. */
    fun retrieve(batchId: String): CompletableFuture<BatchResponse> =
        retrieve(batchId, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(batchId: String, requestOptions: RequestOptions): CompletableFuture<BatchResponse>

    /** Delete a draft. A batch that has started cannot be deleted (409). */
    fun delete(batchId: String): CompletableFuture<BatchDeleteResponse> =
        delete(batchId, RequestOptions.none())

    /** @see delete */
    fun delete(
        batchId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchDeleteResponse>

    /** Start a draft. */
    fun start(batchId: String): CompletableFuture<BatchResponse> =
        start(batchId, BatchStartParams.none())

    /** @see start */
    fun start(batchId: String, params: BatchStartParams): CompletableFuture<BatchResponse> =
        start(batchId, params, RequestOptions.none())

    /** @see start */
    fun start(
        batchId: String,
        params: BatchStartParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchResponse>

    /** Pause a running batch. */
    fun pause(batchId: String): CompletableFuture<BatchResponse> =
        pause(batchId, RequestOptions.none())

    /** @see pause */
    fun pause(batchId: String, requestOptions: RequestOptions): CompletableFuture<BatchResponse>

    /** Continue a paused batch. */
    fun continueBatch(batchId: String): CompletableFuture<BatchResponse> =
        continueBatch(batchId, BatchContinueParams.none())

    /** @see continueBatch */
    fun continueBatch(
        batchId: String,
        params: BatchContinueParams,
    ): CompletableFuture<BatchResponse> = continueBatch(batchId, params, RequestOptions.none())

    /** @see continueBatch */
    fun continueBatch(
        batchId: String,
        params: BatchContinueParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchResponse>

    /** Mark a paused batch complete, leaving the rest unchecked. */
    fun complete(batchId: String): CompletableFuture<BatchResponse> =
        complete(batchId, RequestOptions.none())

    /** @see complete */
    fun complete(batchId: String, requestOptions: RequestOptions): CompletableFuture<BatchResponse>

    /** The batch's checked rows as JSON. Follow `nextAfter` while `hasMore` is true. */
    fun results(batchId: String): CompletableFuture<BatchResultsResponse> =
        results(batchId, BatchResultsParams.none())

    /** @see results */
    fun results(
        batchId: String,
        params: BatchResultsParams,
    ): CompletableFuture<BatchResultsResponse> = results(batchId, params, RequestOptions.none())

    /** @see results */
    fun results(
        batchId: String,
        params: BatchResultsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BatchResultsResponse>

    /** The batch's CSV report, the same file the dashboard gives. */
    fun resultsCsv(batchId: String): CompletableFuture<String> =
        resultsCsv(batchId, RequestOptions.none())

    /** @see resultsCsv */
    fun resultsCsv(batchId: String, requestOptions: RequestOptions): CompletableFuture<String>
}
