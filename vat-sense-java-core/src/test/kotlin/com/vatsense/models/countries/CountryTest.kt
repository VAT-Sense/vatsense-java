// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.countries

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CountryTest {

    @Test
    fun create() {
        val country =
            Country.builder()
                .countryCode("GB")
                .countryName("United Kingdom")
                .eu(false)
                .latitude(54.0)
                .longitude(-2.0)
                .object_(Country.Object.COUNTRY)
                .vat(true)
                .build()

        assertThat(country.countryCode()).contains("GB")
        assertThat(country.countryName()).contains("United Kingdom")
        assertThat(country.eu()).contains(false)
        assertThat(country.latitude()).contains(54.0)
        assertThat(country.longitude()).contains(-2.0)
        assertThat(country.object_()).contains(Country.Object.COUNTRY)
        assertThat(country.vat()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val country =
            Country.builder()
                .countryCode("GB")
                .countryName("United Kingdom")
                .eu(false)
                .latitude(54.0)
                .longitude(-2.0)
                .object_(Country.Object.COUNTRY)
                .vat(true)
                .build()

        val roundtrippedCountry =
            jsonMapper.readValue(jsonMapper.writeValueAsString(country), jacksonTypeRef<Country>())

        assertThat(roundtrippedCountry).isEqualTo(country)
    }
}
