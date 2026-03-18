// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking.invoice

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
import com.vat_sense.api.models.invoice.InvoiceResponse
import com.vat_sense.api.models.invoice.item.ItemAddParams
import com.vat_sense.api.models.invoice.item.ItemDeleteParams
import com.vat_sense.api.models.invoice.item.ItemRetrieveParams
import com.vat_sense.api.models.invoice.item.ItemRetrieveResponse
import com.vat_sense.api.models.invoice.item.ItemUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** VAT-compliant invoice management */
class ItemServiceImpl internal constructor(private val clientOptions: ClientOptions) : ItemService {

    private val withRawResponse: ItemService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ItemService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService =
        ItemServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions,
    ): ItemRetrieveResponse =
        // get /invoice/{invoice_id}/item/{item_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: ItemUpdateParams, requestOptions: RequestOptions): InvoiceResponse =
        // patch /invoice/{invoice_id}/item/{item_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun delete(params: ItemDeleteParams, requestOptions: RequestOptions): InvoiceResponse =
        // delete /invoice/{invoice_id}/item/{item_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun add(params: ItemAddParams, requestOptions: RequestOptions): InvoiceResponse =
        // post /invoice/{invoice_id}/item
        withRawResponse().add(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ItemService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ItemService.WithRawResponse =
            ItemServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<ItemRetrieveResponse> =
            jsonHandler<ItemRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ItemRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("itemId", params.itemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0), "item", params._pathParam(1))
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
            params: ItemUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("itemId", params.itemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.PATCH)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0), "item", params._pathParam(1))
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

        private val deleteHandler: Handler<InvoiceResponse> =
            jsonHandler<InvoiceResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("itemId", params.itemId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0), "item", params._pathParam(1))
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

        private val addHandler: Handler<InvoiceResponse> =
            jsonHandler<InvoiceResponse>(clientOptions.jsonMapper)

        override fun add(
            params: ItemAddParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("invoiceId", params.invoiceId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("invoice", params._pathParam(0), "item")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { addHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
