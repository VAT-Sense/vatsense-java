// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.validate.ValidateCheckParams
import com.vatsense.models.validate.ValidateCheckResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** VAT and EORI number validation */
interface ValidateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateServiceAsync

    /**
     * Check whether a given VAT number or EORI number is valid against live government records.
     *
     * **VAT validation** checks against UK (HMRC), EU (VIES), Australia, Norway, Switzerland, South
     * Africa, and Brazil records.
     *
     * **EORI validation** checks against UK and EU records only.
     *
     * If the external validation service is temporarily unavailable, the API returns a `412` error
     * and the request does not count against your usage quota.
     *
     * Provide either `vat_number` or `eori_number`, but not both.
     */
    fun check(): CompletableFuture<ValidateCheckResponse> = check(ValidateCheckParams.none())

    /** @see check */
    fun check(
        params: ValidateCheckParams = ValidateCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ValidateCheckResponse>

    /** @see check */
    fun check(
        params: ValidateCheckParams = ValidateCheckParams.none()
    ): CompletableFuture<ValidateCheckResponse> = check(params, RequestOptions.none())

    /** @see check */
    fun check(requestOptions: RequestOptions): CompletableFuture<ValidateCheckResponse> =
        check(ValidateCheckParams.none(), requestOptions)

    /**
     * A view of [ValidateServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ValidateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /validate`, but is otherwise the same as
         * [ValidateServiceAsync.check].
         */
        fun check(): CompletableFuture<HttpResponseFor<ValidateCheckResponse>> =
            check(ValidateCheckParams.none())

        /** @see check */
        fun check(
            params: ValidateCheckParams = ValidateCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ValidateCheckResponse>>

        /** @see check */
        fun check(
            params: ValidateCheckParams = ValidateCheckParams.none()
        ): CompletableFuture<HttpResponseFor<ValidateCheckResponse>> =
            check(params, RequestOptions.none())

        /** @see check */
        fun check(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ValidateCheckResponse>> =
            check(ValidateCheckParams.none(), requestOptions)
    }
}
