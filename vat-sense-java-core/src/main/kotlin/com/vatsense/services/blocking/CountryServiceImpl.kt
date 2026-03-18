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
import com.vatsense.models.countries.CountryListParams
import com.vatsense.models.countries.CountryListProvincesParams
import com.vatsense.models.countries.CountryListProvincesResponse
import com.vatsense.models.countries.CountryListResponse
import java.util.function.Consumer

/** Country and province information */
class CountryServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CountryService {

    private val withRawResponse: CountryService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CountryService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CountryService =
        CountryServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CountryListParams,
        requestOptions: RequestOptions,
    ): CountryListResponse =
        // get /countries
        withRawResponse().list(params, requestOptions).parse()

    override fun listProvinces(
        params: CountryListProvincesParams,
        requestOptions: RequestOptions,
    ): CountryListProvincesResponse =
        // get /countries/provinces
        withRawResponse().listProvinces(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CountryService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CountryService.WithRawResponse =
            CountryServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CountryListResponse> =
            jsonHandler<CountryListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CountryListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CountryListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("countries")
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

        private val listProvincesHandler: Handler<CountryListProvincesResponse> =
            jsonHandler<CountryListProvincesResponse>(clientOptions.jsonMapper)

        override fun listProvinces(
            params: CountryListProvincesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CountryListProvincesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("countries", "provinces")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
