// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.SecurityOptions
import com.vatsense.core.handlers.errorBodyHandler
import com.vatsense.core.handlers.errorHandler
import com.vatsense.core.handlers.jsonHandler
import com.vatsense.core.http.HttpMethod
import com.vatsense.core.http.HttpRequest
import com.vatsense.core.http.HttpResponse
import com.vatsense.core.http.HttpResponse.Handler
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.core.http.json
import com.vatsense.core.http.parseable
import com.vatsense.core.prepare
import com.vatsense.models.sandbox.SandboxGenerateKeyParams
import com.vatsense.models.sandbox.SandboxGenerateKeyResponse
import java.util.function.Consumer

/** Temporary sandbox API keys for testing */
class SandboxServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SandboxService {

    private val withRawResponse: SandboxService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SandboxService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SandboxService =
        SandboxServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun generateKey(
        params: SandboxGenerateKeyParams,
        requestOptions: RequestOptions,
    ): SandboxGenerateKeyResponse =
        // post /sandbox/key
        withRawResponse().generateKey(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SandboxService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SandboxService.WithRawResponse =
            SandboxServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val generateKeyHandler: Handler<SandboxGenerateKeyResponse> =
            jsonHandler<SandboxGenerateKeyResponse>(clientOptions.jsonMapper)

        override fun generateKey(
            params: SandboxGenerateKeyParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SandboxGenerateKeyResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("sandbox", "key")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, SecurityOptions.none())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { generateKeyHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
