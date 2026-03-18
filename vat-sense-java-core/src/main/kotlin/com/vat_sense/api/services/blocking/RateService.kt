// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.models.rates.FindRate
import com.vat_sense.api.models.rates.RateCalculatePriceParams
import com.vat_sense.api.models.rates.RateCalculatePriceResponse
import com.vat_sense.api.models.rates.RateDetailsParams
import com.vat_sense.api.models.rates.RateFindParams
import com.vat_sense.api.models.rates.RateListParams
import com.vat_sense.api.models.rates.RateListResponse
import com.vat_sense.api.models.rates.RateListTypesParams
import com.vat_sense.api.models.rates.RateListTypesResponse
import java.util.function.Consumer

/** VAT/GST rate lookups for countries worldwide */
interface RateService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateService

    /**
     * Returns a list of VAT/GST rates for all countries, sorted alphabetically by country code.
     * Each rate is returned as a rate object containing the standard rate and any other applicable
     * rates.
     *
     * You can optionally filter by country code, IP address, or EU membership.
     */
    fun list(): RateListResponse = list(RateListParams.none())

    /** @see list */
    fun list(
        params: RateListParams = RateListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RateListResponse

    /** @see list */
    fun list(params: RateListParams = RateListParams.none()): RateListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): RateListResponse =
        list(RateListParams.none(), requestOptions)

    /**
     * Combines the functionality of the "Find a tax rate" and "VAT price calculation" endpoints to
     * return the particular VAT price for an applicable VAT rate. Requires both a location
     * (country_code or ip_address) and a price to calculate.
     */
    fun calculatePrice(params: RateCalculatePriceParams): RateCalculatePriceResponse =
        calculatePrice(params, RequestOptions.none())

    /** @see calculatePrice */
    fun calculatePrice(
        params: RateCalculatePriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RateCalculatePriceResponse

    /**
     * Get detailed tax rate information for a location, including all applicable rate classes
     * (standard, reduced, zero, etc.).
     */
    fun details(): FindRate = details(RateDetailsParams.none())

    /** @see details */
    fun details(
        params: RateDetailsParams = RateDetailsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FindRate

    /** @see details */
    fun details(params: RateDetailsParams = RateDetailsParams.none()): FindRate =
        details(params, RequestOptions.none())

    /** @see details */
    fun details(requestOptions: RequestOptions): FindRate =
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
    fun find(): FindRate = find(RateFindParams.none())

    /** @see find */
    fun find(
        params: RateFindParams = RateFindParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FindRate

    /** @see find */
    fun find(params: RateFindParams = RateFindParams.none()): FindRate =
        find(params, RequestOptions.none())

    /** @see find */
    fun find(requestOptions: RequestOptions): FindRate = find(RateFindParams.none(), requestOptions)

    /** Returns a list of all available product types that can be used to filter tax rates. */
    fun listTypes(): RateListTypesResponse = listTypes(RateListTypesParams.none())

    /** @see listTypes */
    fun listTypes(
        params: RateListTypesParams = RateListTypesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RateListTypesResponse

    /** @see listTypes */
    fun listTypes(params: RateListTypesParams = RateListTypesParams.none()): RateListTypesResponse =
        listTypes(params, RequestOptions.none())

    /** @see listTypes */
    fun listTypes(requestOptions: RequestOptions): RateListTypesResponse =
        listTypes(RateListTypesParams.none(), requestOptions)

    /** A view of [RateService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RateService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /rates`, but is otherwise the same as
         * [RateService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<RateListResponse> = list(RateListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: RateListParams = RateListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RateListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: RateListParams = RateListParams.none()
        ): HttpResponseFor<RateListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<RateListResponse> =
            list(RateListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/price`, but is otherwise the same as
         * [RateService.calculatePrice].
         */
        @MustBeClosed
        fun calculatePrice(
            params: RateCalculatePriceParams
        ): HttpResponseFor<RateCalculatePriceResponse> =
            calculatePrice(params, RequestOptions.none())

        /** @see calculatePrice */
        @MustBeClosed
        fun calculatePrice(
            params: RateCalculatePriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RateCalculatePriceResponse>

        /**
         * Returns a raw HTTP response for `get /rates/tax_rate`, but is otherwise the same as
         * [RateService.details].
         */
        @MustBeClosed fun details(): HttpResponseFor<FindRate> = details(RateDetailsParams.none())

        /** @see details */
        @MustBeClosed
        fun details(
            params: RateDetailsParams = RateDetailsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FindRate>

        /** @see details */
        @MustBeClosed
        fun details(
            params: RateDetailsParams = RateDetailsParams.none()
        ): HttpResponseFor<FindRate> = details(params, RequestOptions.none())

        /** @see details */
        @MustBeClosed
        fun details(requestOptions: RequestOptions): HttpResponseFor<FindRate> =
            details(RateDetailsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/rate`, but is otherwise the same as
         * [RateService.find].
         */
        @MustBeClosed fun find(): HttpResponseFor<FindRate> = find(RateFindParams.none())

        /** @see find */
        @MustBeClosed
        fun find(
            params: RateFindParams = RateFindParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FindRate>

        /** @see find */
        @MustBeClosed
        fun find(params: RateFindParams = RateFindParams.none()): HttpResponseFor<FindRate> =
            find(params, RequestOptions.none())

        /** @see find */
        @MustBeClosed
        fun find(requestOptions: RequestOptions): HttpResponseFor<FindRate> =
            find(RateFindParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /rates/types`, but is otherwise the same as
         * [RateService.listTypes].
         */
        @MustBeClosed
        fun listTypes(): HttpResponseFor<RateListTypesResponse> =
            listTypes(RateListTypesParams.none())

        /** @see listTypes */
        @MustBeClosed
        fun listTypes(
            params: RateListTypesParams = RateListTypesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RateListTypesResponse>

        /** @see listTypes */
        @MustBeClosed
        fun listTypes(
            params: RateListTypesParams = RateListTypesParams.none()
        ): HttpResponseFor<RateListTypesResponse> = listTypes(params, RequestOptions.none())

        /** @see listTypes */
        @MustBeClosed
        fun listTypes(requestOptions: RequestOptions): HttpResponseFor<RateListTypesResponse> =
            listTypes(RateListTypesParams.none(), requestOptions)
    }
}
