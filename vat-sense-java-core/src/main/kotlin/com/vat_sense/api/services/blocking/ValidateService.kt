// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.models.validate.ValidateCheckParams
import com.vat_sense.api.models.validate.ValidateCheckResponse
import java.util.function.Consumer

/** VAT and EORI number validation */
interface ValidateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateService

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
    fun check(): ValidateCheckResponse = check(ValidateCheckParams.none())

    /** @see check */
    fun check(
        params: ValidateCheckParams = ValidateCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ValidateCheckResponse

    /** @see check */
    fun check(params: ValidateCheckParams = ValidateCheckParams.none()): ValidateCheckResponse =
        check(params, RequestOptions.none())

    /** @see check */
    fun check(requestOptions: RequestOptions): ValidateCheckResponse =
        check(ValidateCheckParams.none(), requestOptions)

    /** A view of [ValidateService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ValidateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /validate`, but is otherwise the same as
         * [ValidateService.check].
         */
        @MustBeClosed
        fun check(): HttpResponseFor<ValidateCheckResponse> = check(ValidateCheckParams.none())

        /** @see check */
        @MustBeClosed
        fun check(
            params: ValidateCheckParams = ValidateCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ValidateCheckResponse>

        /** @see check */
        @MustBeClosed
        fun check(
            params: ValidateCheckParams = ValidateCheckParams.none()
        ): HttpResponseFor<ValidateCheckResponse> = check(params, RequestOptions.none())

        /** @see check */
        @MustBeClosed
        fun check(requestOptions: RequestOptions): HttpResponseFor<ValidateCheckResponse> =
            check(ValidateCheckParams.none(), requestOptions)
    }
}
