// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.countries

import com.vat_sense.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountryListParamsTest {

    @Test
    fun create() {
        CountryListParams.builder().countryCode("GB").ipAddress("86.27.166.97").build()
    }

    @Test
    fun queryParams() {
        val params = CountryListParams.builder().countryCode("GB").ipAddress("86.27.166.97").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("country_code", "GB")
                    .put("ip_address", "86.27.166.97")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CountryListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
