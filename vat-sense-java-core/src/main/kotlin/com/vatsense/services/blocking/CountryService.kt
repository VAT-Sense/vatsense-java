// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.countries.CountryListParams
import com.vatsense.models.countries.CountryListProvincesParams
import com.vatsense.models.countries.CountryListProvincesResponse
import com.vatsense.models.countries.CountryListResponse
import java.util.function.Consumer

/** Country and province information */
interface CountryService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CountryService

    /**
     * Returns a list of all countries, including whether they are subject to VAT/GST and whether
     * they are subject to EU VAT. Each country is returned as a country object.
     *
     * You can optionally filter by country code or IP address.
     */
    fun list(): CountryListResponse = list(CountryListParams.none())

    /** @see list */
    fun list(
        params: CountryListParams = CountryListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CountryListResponse

    /** @see list */
    fun list(params: CountryListParams = CountryListParams.none()): CountryListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CountryListResponse =
        list(CountryListParams.none(), requestOptions)

    /** Retrieve a list of all provinces within a given country. */
    fun listProvinces(params: CountryListProvincesParams): CountryListProvincesResponse =
        listProvinces(params, RequestOptions.none())

    /** @see listProvinces */
    fun listProvinces(
        params: CountryListProvincesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CountryListProvincesResponse

    /** A view of [CountryService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CountryService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /countries`, but is otherwise the same as
         * [CountryService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<CountryListResponse> = list(CountryListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CountryListParams = CountryListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CountryListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CountryListParams = CountryListParams.none()
        ): HttpResponseFor<CountryListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<CountryListResponse> =
            list(CountryListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /countries/provinces`, but is otherwise the same as
         * [CountryService.listProvinces].
         */
        @MustBeClosed
        fun listProvinces(
            params: CountryListProvincesParams
        ): HttpResponseFor<CountryListProvincesResponse> =
            listProvinces(params, RequestOptions.none())

        /** @see listProvinces */
        @MustBeClosed
        fun listProvinces(
            params: CountryListProvincesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CountryListProvincesResponse>
    }
}
