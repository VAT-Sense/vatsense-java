// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.currency.CurrencyCalculateVatPriceParams
import com.vatsense.models.currency.CurrencyCalculateVatPriceResponse
import com.vatsense.models.currency.CurrencyConvertParams
import com.vatsense.models.currency.CurrencyConvertResponse
import com.vatsense.models.currency.CurrencyListParams
import com.vatsense.models.currency.CurrencyListResponse
import java.util.function.Consumer

/** Currency exchange rates and conversion */
interface CurrencyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CurrencyService

    /**
     * Returns a list of all currency conversion rates sourced from HMRC (GBP) and the European
     * Central Bank (EUR).
     *
     * You can optionally filter by source and target currency.
     */
    fun list(): CurrencyListResponse = list(CurrencyListParams.none())

    /** @see list */
    fun list(
        params: CurrencyListParams = CurrencyListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CurrencyListResponse

    /** @see list */
    fun list(params: CurrencyListParams = CurrencyListParams.none()): CurrencyListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CurrencyListResponse =
        list(CurrencyListParams.none(), requestOptions)

    /**
     * Calculate the inclusive and exclusive VAT price on a given amount and VAT rate. This is a
     * standalone calculation that does not look up rates by country.
     */
    fun calculateVatPrice(
        params: CurrencyCalculateVatPriceParams
    ): CurrencyCalculateVatPriceResponse = calculateVatPrice(params, RequestOptions.none())

    /** @see calculateVatPrice */
    fun calculateVatPrice(
        params: CurrencyCalculateVatPriceParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CurrencyCalculateVatPriceResponse

    /**
     * Convert a foreign currency amount to either GBP or EUR using official exchange rates.
     *
     * GBP rates are from HMRC (updated on the 1st of every month). EUR rates are from the European
     * Central Bank (updated around 16:00 CET on working days).
     */
    fun convert(params: CurrencyConvertParams): CurrencyConvertResponse =
        convert(params, RequestOptions.none())

    /** @see convert */
    fun convert(
        params: CurrencyConvertParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CurrencyConvertResponse

    /** A view of [CurrencyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CurrencyService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /currency`, but is otherwise the same as
         * [CurrencyService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<CurrencyListResponse> = list(CurrencyListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: CurrencyListParams = CurrencyListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CurrencyListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: CurrencyListParams = CurrencyListParams.none()
        ): HttpResponseFor<CurrencyListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<CurrencyListResponse> =
            list(CurrencyListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /currency/price`, but is otherwise the same as
         * [CurrencyService.calculateVatPrice].
         */
        @MustBeClosed
        fun calculateVatPrice(
            params: CurrencyCalculateVatPriceParams
        ): HttpResponseFor<CurrencyCalculateVatPriceResponse> =
            calculateVatPrice(params, RequestOptions.none())

        /** @see calculateVatPrice */
        @MustBeClosed
        fun calculateVatPrice(
            params: CurrencyCalculateVatPriceParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CurrencyCalculateVatPriceResponse>

        /**
         * Returns a raw HTTP response for `get /currency/convert`, but is otherwise the same as
         * [CurrencyService.convert].
         */
        @MustBeClosed
        fun convert(params: CurrencyConvertParams): HttpResponseFor<CurrencyConvertResponse> =
            convert(params, RequestOptions.none())

        /** @see convert */
        @MustBeClosed
        fun convert(
            params: CurrencyConvertParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CurrencyConvertResponse>
    }
}
