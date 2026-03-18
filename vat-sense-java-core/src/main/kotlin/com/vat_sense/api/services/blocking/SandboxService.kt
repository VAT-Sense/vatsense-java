// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.models.sandbox.SandboxGenerateKeyParams
import com.vat_sense.api.models.sandbox.SandboxGenerateKeyResponse
import java.util.function.Consumer

/** Temporary sandbox API keys for testing */
interface SandboxService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SandboxService

    /**
     * Generate a temporary sandbox API key for testing. Sandbox keys have limited request
     * allowances and restricted endpoint access (no invoice endpoints). Rate limited to 1 key per
     * IP address per 6 hours.
     */
    fun generateKey(): SandboxGenerateKeyResponse = generateKey(SandboxGenerateKeyParams.none())

    /** @see generateKey */
    fun generateKey(
        params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SandboxGenerateKeyResponse

    /** @see generateKey */
    fun generateKey(
        params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none()
    ): SandboxGenerateKeyResponse = generateKey(params, RequestOptions.none())

    /** @see generateKey */
    fun generateKey(requestOptions: RequestOptions): SandboxGenerateKeyResponse =
        generateKey(SandboxGenerateKeyParams.none(), requestOptions)

    /** A view of [SandboxService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SandboxService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /sandbox/key`, but is otherwise the same as
         * [SandboxService.generateKey].
         */
        @MustBeClosed
        fun generateKey(): HttpResponseFor<SandboxGenerateKeyResponse> =
            generateKey(SandboxGenerateKeyParams.none())

        /** @see generateKey */
        @MustBeClosed
        fun generateKey(
            params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SandboxGenerateKeyResponse>

        /** @see generateKey */
        @MustBeClosed
        fun generateKey(
            params: SandboxGenerateKeyParams = SandboxGenerateKeyParams.none()
        ): HttpResponseFor<SandboxGenerateKeyResponse> = generateKey(params, RequestOptions.none())

        /** @see generateKey */
        @MustBeClosed
        fun generateKey(
            requestOptions: RequestOptions
        ): HttpResponseFor<SandboxGenerateKeyResponse> =
            generateKey(SandboxGenerateKeyParams.none(), requestOptions)
    }
}
