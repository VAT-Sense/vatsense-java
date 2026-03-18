// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

import com.vatsense.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountryListProvincesParamsTest {

    @Test
    fun create() {
        CountryListProvincesParams.builder().countryCode("CA").build()
    }

    @Test
    fun queryParams() {
        val params = CountryListProvincesParams.builder().countryCode("CA").build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().put("country_code", "CA").build())
    }
}
