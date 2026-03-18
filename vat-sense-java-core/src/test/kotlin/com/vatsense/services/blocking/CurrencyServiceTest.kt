// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.models.currency.CurrencyCalculateVatPriceParams
import com.vatsense.models.currency.CurrencyConvertParams
import com.vatsense.models.currency.CurrencyListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CurrencyServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val currencyService = client.currency()

        val currencies =
            currencyService.list(
                CurrencyListParams.builder()
                    .from("USD,CAD,AUD")
                    .to(CurrencyListParams.To.GBP)
                    .build()
            )

        currencies.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun calculateVatPrice() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val currencyService = client.currency()

        val response =
            currencyService.calculateVatPrice(
                CurrencyCalculateVatPriceParams.builder()
                    .price("20.00")
                    .taxType(CurrencyCalculateVatPriceParams.TaxType.EXCL)
                    .vatRate(5.0)
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun convert() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val currencyService = client.currency()

        val response =
            currencyService.convert(
                CurrencyConvertParams.builder()
                    .amount("39.99")
                    .from("USD")
                    .to(CurrencyConvertParams.To.GBP)
                    .build()
            )

        response.validate()
    }
}
