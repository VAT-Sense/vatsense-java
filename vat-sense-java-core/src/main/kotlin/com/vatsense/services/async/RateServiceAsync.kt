// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.rates.FindRate
import com.vatsense.models.rates.RateCalculatePriceParams
import com.vatsense.models.rates.RateCalculatePriceResponse
import com.vatsense.models.rates.RateDetailsParams
import com.vatsense.models.rates.RateFindParams
import com.vatsense.models.rates.RateListParams
import com.vatsense.models.rates.RateListResponse
import com.vatsense.models.rates.RateListTypesParams
import com.vatsense.models.rates.RateListTypesResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** VAT/GST rate lookups for countries worldwide */
interface RateServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateServiceAsync

    /**
     * Returns a list of VAT/GST rates for all countries, sorted alphabetically by country code.
     * Each rate is returned as a rate object containing the standard rate and any other applicable
     * rates.
     *
     * You can optionally filter by country code, IP address, or EU membership.
     */
    fun list(): CompletableFuture<RateListResponse> = list(RateListParams.none())

    /** @see list */
    fun list(
        params: RateListParams = RateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RateListResponse>

    /** @see list */
    fun list(params: RateListParams = RateListParams.none()): CompletableFuture<RateListResponse> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<RateListResponse> =
        list(RateListParams.none(), requestOptions)

    /**
     * Combines the functionality of the "Find a tax rate" and "VAT price calculation" endpoints to
     * return the particular VAT price for an applicable VAT rate. Requires both a location
     * (country_code or ip_address) and a price to calculate.
     */
    fun calculatePrice(
        params: RateCalculatePriceParams
    ): CompletableFuture<RateCalculatePriceResponse> = calculatePrice(params, RequestOptions.none())

    /** @see calculatePrice */
    fun calculatePrice(
        params: RateCalculatePriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RateCalculatePriceResponse>

    /**
     * Get detailed tax rate information for a location, including all applicable rate classes
     * (standard, reduced, zero, etc.).
     */
    fun details(): CompletableFuture<FindRate> = details(RateDetailsParams.none())

    /** @see details */
    fun details(
        params: RateDetailsParams = RateDetailsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FindRate>

    /** @see details */
    fun details(params: RateDetailsParams = RateDetailsParams.none()): CompletableFuture<FindRate> =
        details(params, RequestOptions.none())

    /** @see details */
    fun details(requestOptions: RequestOptions): CompletableFuture<FindRate> =
        details(RateDetailsParams.none(), requestOptions)

    /**
     * A handy endpoint for finding a rate that applies to a particular country and optional product
     * type, based on country code or IP address.
     *
     * If no type is provided, or no specific rate is applied to the given type, then the standard
     * rate will be returned if the country is subject to tax.
     *
     * If the country is not subject to VAT/GST then an error response will be returned, indicating
     * no tax applies.
     */
    fun find(): CompletableFuture<FindRate> = find(RateFindParams.none())

    /** @see find */
    fun find(
        params: RateFindParams = RateFindParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FindRate>

    /** @see find */
    fun find(params: RateFindParams = RateFindParams.none()): CompletableFuture<FindRate> =
        find(params, RequestOptions.none())

    /** @see find */
    fun find(requestOptions: RequestOptions): CompletableFuture<FindRate> =
        find(RateFindParams.none(), requestOptions)

    /** Returns a list of all available product types that can be used to filter tax rates. */
    fun listTypes(): CompletableFuture<RateListTypesResponse> =
        listTypes(RateListTypesParams.none())

    /** @see listTypes */
    fun listTypes(
        params: RateListTypesParams = RateListTypesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RateListTypesResponse>

    /** @see listTypes */
    fun listTypes(
        params: RateListTypesParams = RateListTypesParams.none()
    ): CompletableFuture<RateListTypesResponse> = listTypes(params, RequestOptions.none())

    /** @see listTypes */
    fun listTypes(requestOptions: RequestOptions): CompletableFuture<RateListTypesResponse> =
        listTypes(RateListTypesParams.none(), requestOptions)

    /** A view of [RateServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /rates`, but is otherwise the same as
         * [RateServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<RateListResponse>> =
            list(RateListParams.none())

        /** @see list */
        fun list(
            params: RateListParams = RateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RateListResponse>>

        /** @see list */
        fun list(
            params: RateListParams = RateListParams.none()
        ): CompletableFuture<HttpResponseFor<RateListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<RateListResponse>> =
            list(RateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/price`, but is otherwise the same as
         * [RateServiceAsync.calculatePrice].
         */
        fun calculatePrice(
            params: RateCalculatePriceParams
        ): CompletableFuture<HttpResponseFor<RateCalculatePriceResponse>> =
            calculatePrice(params, RequestOptions.none())

        /** @see calculatePrice */
        fun calculatePrice(
            params: RateCalculatePriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RateCalculatePriceResponse>>

        /**
         * Returns a raw HTTP response for `get /rates/tax_rate`, but is otherwise the same as
         * [RateServiceAsync.details].
         */
        fun details(): CompletableFuture<HttpResponseFor<FindRate>> =
            details(RateDetailsParams.none())

        /** @see details */
        fun details(
            params: RateDetailsParams = RateDetailsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FindRate>>

        /** @see details */
        fun details(
            params: RateDetailsParams = RateDetailsParams.none()
        ): CompletableFuture<HttpResponseFor<FindRate>> = details(params, RequestOptions.none())

        /** @see details */
        fun details(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<FindRate>> =
            details(RateDetailsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/rate`, but is otherwise the same as
         * [RateServiceAsync.find].
         */
        fun find(): CompletableFuture<HttpResponseFor<FindRate>> = find(RateFindParams.none())

        /** @see find */
        fun find(
            params: RateFindParams = RateFindParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FindRate>>

        /** @see find */
        fun find(
            params: RateFindParams = RateFindParams.none()
        ): CompletableFuture<HttpResponseFor<FindRate>> = find(params, RequestOptions.none())

        /** @see find */
        fun find(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<FindRate>> =
            find(RateFindParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/types`, but is otherwise the same as
         * [RateServiceAsync.listTypes].
         */
        fun listTypes(): CompletableFuture<HttpResponseFor<RateListTypesResponse>> =
            listTypes(RateListTypesParams.none())

        /** @see listTypes */
        fun listTypes(
            params: RateListTypesParams = RateListTypesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RateListTypesResponse>>

        /** @see listTypes */
        fun listTypes(
            params: RateListTypesParams = RateListTypesParams.none()
        ): CompletableFuture<HttpResponseFor<RateListTypesResponse>> =
            listTypes(params, RequestOptions.none())

        /** @see listTypes */
        fun listTypes(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<RateListTypesResponse>> =
            listTypes(RateListTypesParams.none(), requestOptions)
    }
}
