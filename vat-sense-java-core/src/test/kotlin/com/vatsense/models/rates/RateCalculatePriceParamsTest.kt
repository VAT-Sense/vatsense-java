// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.vatsense.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateCalculatePriceParamsTest {

    @Test
    fun create() {
        RateCalculatePriceParams.builder()
            .price("20.00")
            .taxType(RateCalculatePriceParams.TaxType.EXCL)
            .countryCode("GB")
            .eu(true)
            .ipAddress("86.27.166.97")
            .provinceCode("ON")
            .type("ebooks")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RateCalculatePriceParams.builder()
                .price("20.00")
                .taxType(RateCalculatePriceParams.TaxType.EXCL)
                .countryCode("GB")
                .eu(true)
                .ipAddress("86.27.166.97")
                .provinceCode("ON")
                .type("ebooks")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("price", "20.00")
                    .put("tax_type", "excl")
                    .put("country_code", "GB")
                    .put("eu", "true")
                    .put("ip_address", "86.27.166.97")
                    .put("province_code", "ON")
                    .put("type", "ebooks")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            RateCalculatePriceParams.builder()
                .price("20.00")
                .taxType(RateCalculatePriceParams.TaxType.EXCL)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("price", "20.00").put("tax_type", "excl").build())
    }
}
