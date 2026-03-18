// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import com.vatsense.models.currency.CurrencyCalculateVatPriceParams
import com.vatsense.models.currency.CurrencyConvertParams
import com.vatsense.models.currency.CurrencyListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CurrencyServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val currencyServiceAsync = client.currency()

        val currenciesFuture =
            currencyServiceAsync.list(
                CurrencyListParams.builder()
                    .from("USD,CAD,AUD")
                    .to(CurrencyListParams.To.GBP)
                    .build()
            )

        val currencies = currenciesFuture.get()
        currencies.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun calculateVatPrice() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val currencyServiceAsync = client.currency()

        val responseFuture =
            currencyServiceAsync.calculateVatPrice(
                CurrencyCalculateVatPriceParams.builder()
                    .price("20.00")
                    .taxType(CurrencyCalculateVatPriceParams.TaxType.EXCL)
                    .vatRate(5.0)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun convert() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val currencyServiceAsync = client.currency()

        val responseFuture =
            currencyServiceAsync.convert(
                CurrencyConvertParams.builder()
                    .amount("39.99")
                    .from("USD")
                    .to(CurrencyConvertParams.To.GBP)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
