// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.models.rates.RateCalculatePriceParams
import com.vatsense.models.rates.RateDetailsParams
import com.vatsense.models.rates.RateFindParams
import com.vatsense.models.rates.RateListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class RateServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val rateService = client.rates()

        val rates =
            rateService.list(
                RateListParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        rates.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun calculatePrice() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val rateService = client.rates()

        val response =
            rateService.calculatePrice(
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

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun details() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val rateService = client.rates()

        val findRate =
            rateService.details(
                RateDetailsParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .provinceCode("ON")
                    .type("ebooks")
                    .build()
            )

        findRate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun find() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val rateService = client.rates()

        val findRate =
            rateService.find(
                RateFindParams.builder()
                    .countryCode("GB")
                    .eu(true)
                    .ipAddress("86.27.166.97")
                    .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .provinceCode("ON")
                    .type("ebooks")
                    .build()
            )

        findRate.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listTypes() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val rateService = client.rates()

        val response = rateService.listTypes()

        response.validate()
    }
}
