// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import com.vatsense.models.countries.CountryListParams
import com.vatsense.models.countries.CountryListProvincesParams
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
