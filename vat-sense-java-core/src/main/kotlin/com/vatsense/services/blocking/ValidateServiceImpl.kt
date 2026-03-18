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
import com.vatsense.models.validate.ValidateCheckParams
import com.vatsense.models.validate.ValidateCheckResponse
import java.util.function.Consumer

/** VAT and EORI number validation */
class ValidateServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ValidateService {

    private val withRawResponse: ValidateService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ValidateService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateService =
        ValidateServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun check(
        params: ValidateCheckParams,
        requestOptions: RequestOptions,
    ): ValidateCheckResponse =
        // get /validate
        withRawResponse().check(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ValidateService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ValidateService.WithRawResponse =
            ValidateServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val checkHandler: Handler<ValidateCheckResponse> =
            jsonHandler<ValidateCheckResponse>(clientOptions.jsonMapper)

        override fun check(
            params: ValidateCheckParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ValidateCheckResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("validate")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
