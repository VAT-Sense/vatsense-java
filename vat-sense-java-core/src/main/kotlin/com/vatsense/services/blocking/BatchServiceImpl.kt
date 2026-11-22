// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.services.blocking

import com.vatsense.core.ClientOptions
import com.vatsense.core.Params
import com.vatsense.core.RequestOptions
import com.vatsense.core.handlers.errorBodyHandler
import com.vatsense.core.handlers.errorHandler
import com.vatsense.core.handlers.jsonHandler
import com.vatsense.core.handlers.stringHandler
import com.vatsense.core.http.HttpMethod
import com.vatsense.core.http.HttpResponse
import com.vatsense.core.http.HttpResponse.Handler
import com.vatsense.models.batches.BatchContinueParams
import com.vatsense.models.batches.BatchCreateParams
import com.vatsense.models.batches.BatchDeleteResponse
import com.vatsense.models.batches.BatchListParams
import com.vatsense.models.batches.BatchListResponse
import com.vatsense.models.batches.BatchNoParams
import com.vatsense.models.batches.BatchResponse
import com.vatsense.models.batches.BatchResultsParams
import com.vatsense.models.batches.BatchResultsResponse
import com.vatsense.models.batches.BatchStartParams
import com.vatsense.services.BatchRequests
import java.util.function.Consumer

/** Bulk validation: check many VAT numbers in one batch */
class BatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchService {

    private val errorHandler: Handler<HttpResponse> =
        errorHandler(errorBodyHandler(clientOptions.jsonMapper))

    private val batchHandler: Handler<BatchResponse> =
        jsonHandler<BatchResponse>(clientOptions.jsonMapper)

    private val listHandler: Handler<BatchListResponse> =
        jsonHandler<BatchListResponse>(clientOptions.jsonMapper)

    private val resultsHandler: Handler<BatchResultsResponse> =
        jsonHandler<BatchResultsResponse>(clientOptions.jsonMapper)

    private val deleteHandler: Handler<BatchDeleteResponse> =
        jsonHandler<BatchDeleteResponse>(clientOptions.jsonMapper)

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService =
        BatchServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    private fun <T> send(
        handler: Handler<T>,
        requestOptions: RequestOptions,
        method: HttpMethod,
        params: Params,
        vararg segments: String,
    ): T {
        val request = BatchRequests.build(clientOptions, method, params, *segments)
        val options = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
        val response = clientOptions.httpClient.execute(request, options)
        return errorHandler.handle(response).use { handler.handle(it) }
    }

    override fun create(params: BatchCreateParams, requestOptions: RequestOptions): BatchResponse =
        // post /batches
        send(batchHandler, requestOptions, HttpMethod.POST, params, "batches")

    override fun list(params: BatchListParams, requestOptions: RequestOptions): BatchListResponse =
        // get /batches
        send(listHandler, requestOptions, HttpMethod.GET, params, "batches")

    override fun retrieve(batchId: String, requestOptions: RequestOptions): BatchResponse =
        // get /batches/{batch_id}
        send(batchHandler, requestOptions, HttpMethod.GET, BatchNoParams, "batches", batchId)

    override fun delete(batchId: String, requestOptions: RequestOptions): BatchDeleteResponse =
        // delete /batches/{batch_id}
        send(deleteHandler, requestOptions, HttpMethod.DELETE, BatchNoParams, "batches", batchId)

    override fun start(
        batchId: String,
        params: BatchStartParams,
        requestOptions: RequestOptions,
    ): BatchResponse =
        // post /batches/{batch_id}/start
        send(batchHandler, requestOptions, HttpMethod.POST, params, "batches", batchId, "start")

    override fun pause(batchId: String, requestOptions: RequestOptions): BatchResponse =
        // post /batches/{batch_id}/pause
        send(
            batchHandler,
            requestOptions,
            HttpMethod.POST,
            BatchNoParams,
            "batches",
            batchId,
            "pause",
        )

    override fun continueBatch(
        batchId: String,
        params: BatchContinueParams,
        requestOptions: RequestOptions,
    ): BatchResponse =
        // post /batches/{batch_id}/continue
        send(batchHandler, requestOptions, HttpMethod.POST, params, "batches", batchId, "continue")

    override fun complete(batchId: String, requestOptions: RequestOptions): BatchResponse =
        // post /batches/{batch_id}/complete
        send(
            batchHandler,
            requestOptions,
            HttpMethod.POST,
            BatchNoParams,
            "batches",
            batchId,
            "complete",
        )

    override fun results(
        batchId: String,
        params: BatchResultsParams,
        requestOptions: RequestOptions,
    ): BatchResultsResponse =
        // get /batches/{batch_id}/results
        send(resultsHandler, requestOptions, HttpMethod.GET, params, "batches", batchId, "results")

    override fun resultsCsv(batchId: String, requestOptions: RequestOptions): String =
        // get /batches/{batch_id}/results.csv
        send(
            stringHandler(),
            requestOptions,
            HttpMethod.GET,
            BatchNoParams,
            "batches",
            batchId,
            "results.csv",
        )
}
