// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.checkRequired
import com.vat_sense.api.core.handlers.errorBodyHandler
import com.vat_sense.api.core.handlers.errorHandler
import com.vat_sense.api.core.handlers.jsonHandler
import com.vat_sense.api.core.http.HttpMethod
import com.vat_sense.api.core.http.HttpRequest
import com.vat_sense.api.core.http.HttpResponse
import com.vat_sense.api.core.http.HttpResponse.Handler
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.core.http.json
import com.vat_sense.api.core.http.parseable
import com.vat_sense.api.core.prepare
import com.vat_sense.api.models.invoice.InvoiceCreateParams
import com.vat_sense.api.models.invoice.InvoiceDeleteParams
import com.vat_sense.api.models.invoice.InvoiceDeleteResponse
import com.vat_sense.api.models.invoice.InvoiceListParams
import com.vat_sense.api.models.invoice.InvoiceListResponse
import com.vat_sense.api.models.invoice.InvoiceResponse
import com.vat_sense.api.models.invoice.InvoiceRetrieveParams
import com.vat_sense.api.models.invoice.InvoiceUpdateParams
import com.vat_sense.api.services.blocking.invoice.ItemService
import com.vat_sense.api.services.blocking.invoice.ItemServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** VAT-compliant invoice management */
class InvoiceServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InvoiceService {

    private val withRawResponse: InvoiceService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val item: ItemService by lazy { ItemServiceImpl(clientOptions) }

    override fun withRawResponse(): InvoiceService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvoiceService =
        InvoiceServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** VAT-compliant invoice management */
    override fun item(): ItemService = item

    override fun create(
        params: InvoiceCreateParams,
        requestOptions: RequestOptions,
    ): InvoiceResponse =
        // post /invoice
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: InvoiceRetrieveParams,
        requestOptions: RequestOptions,
    ): InvoiceResponse =
        // get /invoice/{invoice_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: InvoiceUpdateParams,
        requestOptions: RequestOptions,
    ): InvoiceResponse =
        // patch /invoice/{invoice_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: InvoiceListParams,
        requestOptions: RequestOptions,
    ): InvoiceListResponse =
        // get /invoice
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: InvoiceDeleteParams,
        requestOptions: RequestOptions,
    ): InvoiceDeleteResponse =
        // delete /invoice/{invoice_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InvoiceService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val item: ItemService.WithRawResponse by lazy {
            ItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvoiceService.WithRawResponse =
            InvoiceServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** VAT-compliant invoice management */
        override fun item(): ItemService.WithRawResponse = item

        private val createHandler: Handler<InvoiceResponse> =
            jsonHandler<InvoiceResponse>(clientOptions.jsonMapper)

        override fun create(
            params: InvoiceCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<InvoiceResponse> =
            jsonHandler<InvoiceResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: InvoiceRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invoiceId", params.invoiceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<InvoiceResponse> =
            jsonHandler<InvoiceResponse>(clientOptions.jsonMapper)

        override fun update(
            params: InvoiceUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invoiceId", params.invoiceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<InvoiceListResponse> =
            jsonHandler<InvoiceListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InvoiceListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<InvoiceDeleteResponse> =
            jsonHandler<InvoiceDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: InvoiceDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invoiceId", params.invoiceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
