// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountryListProvincesResponseTest {

    @Test
    fun create() {
        val countryListProvincesResponse =
            CountryListProvincesResponse.builder()
                .code(200L)
                .addData(
                    CountryListProvincesResponse.Data.builder()
                        .countryCode("CA")
                        .object_(CountryListProvincesResponse.Data.Object.PROVINCE)
                        .provinceCode("ON")
                        .provinceName("Ontario")
                        .build()
                )
                .success(true)
                .build()

        assertThat(countryListProvincesResponse.code()).contains(200L)
        assertThat(countryListProvincesResponse.data().getOrNull())
            .containsExactly(
                CountryListProvincesResponse.Data.builder()
                    .countryCode("CA")
                    .object_(CountryListProvincesResponse.Data.Object.PROVINCE)
                    .provinceCode("ON")
                    .provinceName("Ontario")
                    .build()
            )
        assertThat(countryListProvincesResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val countryListProvincesResponse =
            CountryListProvincesResponse.builder()
                .code(200L)
                .addData(
                    CountryListProvincesResponse.Data.builder()
                        .countryCode("CA")
                        .object_(CountryListProvincesResponse.Data.Object.PROVINCE)
                        .provinceCode("ON")
                        .provinceName("Ontario")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedCountryListProvincesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(countryListProvincesResponse),
                jacksonTypeRef<CountryListProvincesResponse>(),
            )

        assertThat(roundtrippedCountryListProvincesResponse).isEqualTo(countryListProvincesResponse)
    }
}
