// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClientAsync
import com.vat_sense.api.models.rates.RateCalculatePriceParams
import com.vat_sense.api.models.rates.RateDetailsParams
import com.vat_sense.api.models.rates.RateFindParams
import com.vat_sense.api.models.rates.RateListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RateServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val rateServiceAsync = client.rates()

        val ratesFuture =
            rateServiceAsync.list(
                RateListParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val rates = ratesFuture.get()
        rates.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun calculatePrice() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val rateServiceAsync = client.rates()

        val responseFuture =
            rateServiceAsync.calculatePrice(
                RateCalculatePriceParams.builder()
                    .price("20.00")
                    .taxType(RateCalculatePriceParams.TaxType.EXCL)
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .provinceCode("ON")
                    .type("ebooks")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun details() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val rateServiceAsync = client.rates()

        val findRateFuture =
            rateServiceAsync.details(
                RateDetailsParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .provinceCode("ON")
                    .type("ebooks")
                    .build()
            )

        val findRate = findRateFuture.get()
        findRate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun find() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val rateServiceAsync = client.rates()

        val findRateFuture =
            rateServiceAsync.find(
                RateFindParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .provinceCode("ON")
                    .type("ebooks")
                    .build()
            )

        val findRate = findRateFuture.get()
        findRate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listTypes() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val rateServiceAsync = client.rates()

        val responseFuture = rateServiceAsync.listTypes()

        val response = responseFuture.get()
        response.validate()
    }
}
