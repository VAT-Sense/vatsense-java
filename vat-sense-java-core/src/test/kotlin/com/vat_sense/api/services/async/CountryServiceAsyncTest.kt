// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClientAsync
import com.vat_sense.api.models.countries.CountryListParams
import com.vat_sense.api.models.countries.CountryListProvincesParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CountryServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val countryServiceAsync = client.countries()

        val countriesFuture =
            countryServiceAsync.list(
                CountryListParams.builder().countryCode("GB").ipAddress("86.27.166.97").build()
            )

        val countries = countriesFuture.get()
        countries.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listProvinces() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val countryServiceAsync = client.countries()

        val responseFuture =
            countryServiceAsync.listProvinces(
                CountryListProvincesParams.builder().countryCode("CA").build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
