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
import com.vat_sense.api.models.countries.CountryListParams
import com.vat_sense.api.models.countries.CountryListProvincesParams
import com.vat_sense.api.models.countries.CountryListProvincesResponse
import com.vat_sense.api.models.countries.CountryListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Country and province information */
class CountryServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CountryServiceAsync {

    private val withRawResponse: CountryServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CountryServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CountryServiceAsync =
        CountryServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CountryListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CountryListResponse> =
        // get /countries
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun listProvinces(
        params: CountryListProvincesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CountryListProvincesResponse> =
        // get /countries/provinces
        withRawResponse().listProvinces(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CountryServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CountryServiceAsync.WithRawResponse =
            CountryServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CountryListResponse> =
            jsonHandler<CountryListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CountryListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CountryListResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("countries")
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

        private val listProvincesHandler: Handler<CountryListProvincesResponse> =
            jsonHandler<CountryListProvincesResponse>(clientOptions.jsonMapper)

        override fun listProvinces(
            params: CountryListProvincesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CountryListProvincesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("countries", "provinces")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listProvincesHandler.handle(it) }
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
