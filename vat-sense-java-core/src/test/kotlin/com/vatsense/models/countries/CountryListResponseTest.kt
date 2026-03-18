// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountryListResponseTest {

    @Test
    fun create() {
        val countryListResponse =
            CountryListResponse.builder()
                .code(200L)
                .addData(
                    Country.builder()
                        .countryCode("GB")
                        .countryName("United Kingdom")
                        .eu(false)
                        .latitude(54.0)
                        .longitude(-2.0)
                        .object_(Country.Object.COUNTRY)
                        .vat(true)
                        .build()
                )
                .success(true)
                .build()

        assertThat(countryListResponse.code()).contains(200L)
        assertThat(countryListResponse.data().getOrNull())
            .containsExactly(
                Country.builder()
                    .countryCode("GB")
                    .countryName("United Kingdom")
                    .eu(false)
                    .latitude(54.0)
                    .longitude(-2.0)
                    .object_(Country.Object.COUNTRY)
                    .vat(true)
                    .build()
            )
        assertThat(countryListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val countryListResponse =
            CountryListResponse.builder()
                .code(200L)
                .addData(
                    Country.builder()
                        .countryCode("GB")
                        .countryName("United Kingdom")
                        .eu(false)
                        .latitude(54.0)
                        .longitude(-2.0)
                        .object_(Country.Object.COUNTRY)
                        .vat(true)
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedCountryListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(countryListResponse),
                jacksonTypeRef<CountryListResponse>(),
            )

        assertThat(roundtrippedCountryListResponse).isEqualTo(countryListResponse)
    }
}
