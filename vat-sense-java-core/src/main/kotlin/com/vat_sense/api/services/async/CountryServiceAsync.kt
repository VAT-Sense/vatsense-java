// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.models.countries.CountryListParams
import com.vat_sense.api.models.countries.CountryListProvincesParams
import com.vat_sense.api.models.countries.CountryListProvincesResponse
import com.vat_sense.api.models.countries.CountryListResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Country and province information */
interface CountryServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CountryServiceAsync

    /**
     * Returns a list of all countries, including whether they are subject to VAT/GST and whether
     * they are subject to EU VAT. Each country is returned as a country object.
     *
     * You can optionally filter by country code or IP address.
     */
    fun list(): CompletableFuture<CountryListResponse> = list(CountryListParams.none())

    /** @see list */
    fun list(
        params: CountryListParams = CountryListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CountryListResponse>

    /** @see list */
    fun list(
        params: CountryListParams = CountryListParams.none()
    ): CompletableFuture<CountryListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<CountryListResponse> =
        list(CountryListParams.none(), requestOptions)

    /** Retrieve a list of all provinces within a given country. */
    fun listProvinces(
        params: CountryListProvincesParams
    ): CompletableFuture<CountryListProvincesResponse> =
        listProvinces(params, RequestOptions.none())

    /** @see listProvinces */
    fun listProvinces(
        params: CountryListProvincesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CountryListProvincesResponse>

    /**
     * A view of [CountryServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CountryServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /countries`, but is otherwise the same as
         * [CountryServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<CountryListResponse>> =
            list(CountryListParams.none())

        /** @see list */
        fun list(
            params: CountryListParams = CountryListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CountryListResponse>>

        /** @see list */
        fun list(
            params: CountryListParams = CountryListParams.none()
        ): CompletableFuture<HttpResponseFor<CountryListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<CountryListResponse>> =
            list(CountryListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /countries/provinces`, but is otherwise the same as
         * [CountryServiceAsync.listProvinces].
         */
        fun listProvinces(
            params: CountryListProvincesParams
        ): CompletableFuture<HttpResponseFor<CountryListProvincesResponse>> =
            listProvinces(params, RequestOptions.none())

        /** @see listProvinces */
        fun listProvinces(
            params: CountryListProvincesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CountryListProvincesResponse>>
    }
}
