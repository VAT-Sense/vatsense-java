// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.handlers.errorBodyHandler
import com.vat_sense.api.core.handlers.errorHandler
import com.vat_sense.api.core.handlers.jsonHandler
import com.vat_sense.api.core.http.HttpMethod
import com.vat_sense.api.core.http.HttpRequest
import com.vat_sense.api.core.http.HttpResponse
import com.vat_sense.api.core.http.HttpResponse.Handler
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.core.http.parseable
import com.vat_sense.api.core.prepareAsync
import com.vat_sense.api.models.currency.CurrencyCalculateVatPriceParams
import com.vat_sense.api.models.currency.CurrencyCalculateVatPriceResponse
import com.vat_sense.api.models.currency.CurrencyConvertParams
import com.vat_sense.api.models.currency.CurrencyConvertResponse
import com.vat_sense.api.models.currency.CurrencyListParams
import com.vat_sense.api.models.currency.CurrencyListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Currency exchange rates and conversion */
class CurrencyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CurrencyServiceAsync {

    private val withRawResponse: CurrencyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CurrencyServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CurrencyServiceAsync =
        CurrencyServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CurrencyListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CurrencyListResponse> =
        // get /currency
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun calculateVatPrice(
        params: CurrencyCalculateVatPriceParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CurrencyCalculateVatPriceResponse> =
        // get /currency/price
        withRawResponse().calculateVatPrice(params, requestOptions).thenApply { it.parse() }

    override fun convert(
        params: CurrencyConvertParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CurrencyConvertResponse> =
        // get /currency/convert
        withRawResponse().convert(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CurrencyServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CurrencyServiceAsync.WithRawResponse =
            CurrencyServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CurrencyListResponse> =
            jsonHandler<CurrencyListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CurrencyListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CurrencyListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val calculateVatPriceHandler: Handler<CurrencyCalculateVatPriceResponse> =
            jsonHandler<CurrencyCalculateVatPriceResponse>(clientOptions.jsonMapper)

        override fun calculateVatPrice(
            params: CurrencyCalculateVatPriceParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CurrencyCalculateVatPriceResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency", "price")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { calculateVatPriceHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val convertHandler: Handler<CurrencyConvertResponse> =
            jsonHandler<CurrencyConvertResponse>(clientOptions.jsonMapper)

        override fun convert(
            params: CurrencyConvertParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CurrencyConvertResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency", "convert")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { convertHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
