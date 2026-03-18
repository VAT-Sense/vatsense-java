// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.usage.UsageRetrieveParams
import com.vatsense.models.usage.UsageRetrieveResponse
import java.util.function.Consumer

/** API usage statistics */
interface UsageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService

    /** Check your used and remaining API requests. */
    fun retrieve(): UsageRetrieveResponse = retrieve(UsageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UsageRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: UsageRetrieveParams = UsageRetrieveParams.none()): UsageRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): UsageRetrieveResponse =
        retrieve(UsageRetrieveParams.none(), requestOptions)

    /** A view of [UsageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /usage`, but is otherwise the same as
         * [UsageService.retrieve].
         */
        @MustBeClosed
        fun retrieve(): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(UsageRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UsageRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none()
        ): HttpResponseFor<UsageRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(requestOptions: RequestOptions): HttpResponseFor<UsageRetrieveResponse> =
            retrieve(UsageRetrieveParams.none(), requestOptions)
    }
}
