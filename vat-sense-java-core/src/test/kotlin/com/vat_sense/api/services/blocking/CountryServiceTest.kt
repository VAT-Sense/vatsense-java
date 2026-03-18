// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClient
import com.vat_sense.api.models.countries.CountryListParams
import com.vat_sense.api.models.countries.CountryListProvincesParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CountryServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val countryService = client.countries()

        val countries =
            countryService.list(
                CountryListParams.builder().countryCode("GB").ipAddress("86.27.166.97").build()
            )

        countries.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listProvinces() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val countryService = client.countries()

        val response =
            countryService.listProvinces(
                CountryListProvincesParams.builder().countryCode("CA").build()
            )

        response.validate()
    }
}
