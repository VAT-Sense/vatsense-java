// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

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
import com.vat_sense.api.core.prepare
import com.vat_sense.api.models.rates.FindRate
import com.vat_sense.api.models.rates.RateCalculatePriceParams
import com.vat_sense.api.models.rates.RateCalculatePriceResponse
import com.vat_sense.api.models.rates.RateDetailsParams
import com.vat_sense.api.models.rates.RateFindParams
import com.vat_sense.api.models.rates.RateListParams
import com.vat_sense.api.models.rates.RateListResponse
import com.vat_sense.api.models.rates.RateListTypesParams
import com.vat_sense.api.models.rates.RateListTypesResponse
import java.util.function.Consumer

/** VAT/GST rate lookups for countries worldwide */
class RateServiceImpl internal constructor(private val clientOptions: ClientOptions) : RateService {

    private val withRawResponse: RateService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RateService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateService =
        RateServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(params: RateListParams, requestOptions: RequestOptions): RateListResponse =
        // get /rates
        withRawResponse().list(params, requestOptions).parse()

    override fun calculatePrice(
        params: RateCalculatePriceParams,
        requestOptions: RequestOptions,
    ): RateCalculatePriceResponse =
        // get /rates/price
        withRawResponse().calculatePrice(params, requestOptions).parse()

    override fun details(params: RateDetailsParams, requestOptions: RequestOptions): FindRate =
        // get /rates/tax_rate
        withRawResponse().details(params, requestOptions).parse()

    override fun find(params: RateFindParams, requestOptions: RequestOptions): FindRate =
        // get /rates/rate
        withRawResponse().find(params, requestOptions).parse()

    override fun listTypes(
        params: RateListTypesParams,
        requestOptions: RequestOptions,
    ): RateListTypesResponse =
        // get /rates/types
        withRawResponse().listTypes(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RateService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RateService.WithRawResponse =
            RateServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<RateListResponse> =
            jsonHandler<RateListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: RateListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RateListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("rates")
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

        private val calculatePriceHandler: Handler<RateCalculatePriceResponse> =
            jsonHandler<RateCalculatePriceResponse>(clientOptions.jsonMapper)

        override fun calculatePrice(
            params: RateCalculatePriceParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RateCalculatePriceResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("rates", "price")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { calculatePriceHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val detailsHandler: Handler<FindRate> =
            jsonHandler<FindRate>(clientOptions.jsonMapper)

        override fun details(
            params: RateDetailsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FindRate> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("rates", "tax_rate")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { detailsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val findHandler: Handler<FindRate> = jsonHandler<FindRate>(clientOptions.jsonMapper)

        override fun find(
            params: RateFindParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FindRate> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("rates", "rate")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { findHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listTypesHandler: Handler<RateListTypesResponse> =
            jsonHandler<RateListTypesResponse>(clientOptions.jsonMapper)

        override fun listTypes(
            params: RateListTypesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RateListTypesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("rates", "types")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listTypesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
