// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.handlers.errorBodyHandler
import com.vatsense.core.handlers.errorHandler
import com.vatsense.core.handlers.jsonHandler
import com.vatsense.core.http.HttpMethod
import com.vatsense.core.http.HttpRequest
import com.vatsense.core.http.HttpResponse
import com.vatsense.core.http.HttpResponse.Handler
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.core.http.parseable
import com.vatsense.core.prepare
import com.vatsense.models.currency.CurrencyCalculateVatPriceParams
import com.vatsense.models.currency.CurrencyCalculateVatPriceResponse
import com.vatsense.models.currency.CurrencyConvertParams
import com.vatsense.models.currency.CurrencyConvertResponse
import com.vatsense.models.currency.CurrencyListParams
import com.vatsense.models.currency.CurrencyListResponse
import java.util.function.Consumer

/** Currency exchange rates and conversion */
class CurrencyServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CurrencyService {

    private val withRawResponse: CurrencyService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CurrencyService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CurrencyService =
        CurrencyServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CurrencyListParams,
        requestOptions: RequestOptions,
    ): CurrencyListResponse =
        // get /currency
        withRawResponse().list(params, requestOptions).parse()

    override fun calculateVatPrice(
        params: CurrencyCalculateVatPriceParams,
        requestOptions: RequestOptions,
    ): CurrencyCalculateVatPriceResponse =
        // get /currency/price
        withRawResponse().calculateVatPrice(params, requestOptions).parse()

    override fun convert(
        params: CurrencyConvertParams,
        requestOptions: RequestOptions,
    ): CurrencyConvertResponse =
        // get /currency/convert
        withRawResponse().convert(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CurrencyService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CurrencyService.WithRawResponse =
            CurrencyServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CurrencyListResponse> =
            jsonHandler<CurrencyListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CurrencyListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CurrencyListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency")
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

        private val calculateVatPriceHandler: Handler<CurrencyCalculateVatPriceResponse> =
            jsonHandler<CurrencyCalculateVatPriceResponse>(clientOptions.jsonMapper)

        override fun calculateVatPrice(
            params: CurrencyCalculateVatPriceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CurrencyCalculateVatPriceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency", "price")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { calculateVatPriceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val convertHandler: Handler<CurrencyConvertResponse> =
            jsonHandler<CurrencyConvertResponse>(clientOptions.jsonMapper)

        override fun convert(
            params: CurrencyConvertParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CurrencyConvertResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("currency", "convert")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
