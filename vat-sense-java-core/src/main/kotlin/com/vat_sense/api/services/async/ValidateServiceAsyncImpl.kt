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
import com.vat_sense.api.models.validate.ValidateCheckParams
import com.vat_sense.api.models.validate.ValidateCheckResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** VAT and EORI number validation */
class ValidateServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ValidateServiceAsync {

    private val withRawResponse: ValidateServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ValidateServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateServiceAsync =
        ValidateServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun check(
        params: ValidateCheckParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ValidateCheckResponse> =
        // get /validate
        withRawResponse().check(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ValidateServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ValidateServiceAsync.WithRawResponse =
            ValidateServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val checkHandler: Handler<ValidateCheckResponse> =
            jsonHandler<ValidateCheckResponse>(clientOptions.jsonMapper)

        override fun check(
            params: ValidateCheckParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ValidateCheckResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("validate")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { checkHandler.handle(it) }
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
