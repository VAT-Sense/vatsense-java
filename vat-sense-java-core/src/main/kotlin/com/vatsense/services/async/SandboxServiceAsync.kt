// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.sandbox.SandboxGenerateKeyParams
import com.vatsense.models.sandbox.SandboxGenerateKeyResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Temporary sandbox API keys for testing */
interface SandboxServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SandboxServiceAsync

    /**
     * Generate a temporary sandbox API key for testing. Sandbox keys have limited request
     * allowances and restricted endpoint access (no invoice endpoints). Rate limited to 1 key per
     * IP address per 6 hours.
     */
    fun generateKey(): CompletableFuture<SandboxGenerateKeyResponse> =
        generateKey(SandboxGenerateKeyParams.none())

    /** @see generateKey */
    fun generateKey(
        params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SandboxGenerateKeyResponse>

    /** @see generateKey */
    fun generateKey(
        params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none()
    ): CompletableFuture<SandboxGenerateKeyResponse> = generateKey(params, RequestOptions.none())

    /** @see generateKey */
    fun generateKey(requestOptions: RequestOptions): CompletableFuture<SandboxGenerateKeyResponse> =
        generateKey(SandboxGenerateKeyParams.none(), requestOptions)

    /**
     * A view of [SandboxServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SandboxServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /sandbox/key`, but is otherwise the same as
         * [SandboxServiceAsync.generateKey].
         */
        fun generateKey(): CompletableFuture<HttpResponseFor<SandboxGenerateKeyResponse>> =
            generateKey(SandboxGenerateKeyParams.none())

        /** @see generateKey */
        fun generateKey(
            params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SandboxGenerateKeyResponse>>

        /** @see generateKey */
        fun generateKey(
            params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none()
        ): CompletableFuture<HttpResponseFor<SandboxGenerateKeyResponse>> =
            generateKey(params, RequestOptions.none())

        /** @see generateKey */
        fun generateKey(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<SandboxGenerateKeyResponse>> =
            generateKey(SandboxGenerateKeyParams.none(), requestOptions)
    }
}
