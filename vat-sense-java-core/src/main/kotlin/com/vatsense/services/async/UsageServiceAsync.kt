// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.usage.UsageRetrieveParams
import com.vatsense.models.usage.UsageRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** API usage statistics */
interface UsageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync

    /** Check your used and remaining API requests. */
    fun retrieve(): CompletableFuture<UsageRetrieveResponse> = retrieve(UsageRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        params: UsageRetrieveParams = UsageRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UsageRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: UsageRetrieveParams = UsageRetrieveParams.none()
    ): CompletableFuture<UsageRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(requestOptions: RequestOptions): CompletableFuture<UsageRetrieveResponse> =
        retrieve(UsageRetrieveParams.none(), requestOptions)

    /** A view of [UsageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /usage`, but is otherwise the same as
         * [UsageServiceAsync.retrieve].
         */
        fun retrieve(): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(UsageRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: UsageRetrieveParams = UsageRetrieveParams.none()
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UsageRetrieveResponse>> =
            retrieve(UsageRetrieveParams.none(), requestOptions)
    }
}
