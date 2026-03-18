// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateListTypesResponseTest {

    @Test
    fun create() {
        val rateListTypesResponse =
            RateListTypesResponse.builder()
                .code(200L)
                .data(
                    listOf(
                        "accommodation",
                        "admission to cultural events",
                        "admission to entertainment events",
                        "admission to sporting events",
                        "advertising",
                        "agricultural supplies",
                        "baby foodstuffs",
                        "bikes",
                        "books",
                        "childrens clothing",
                        "domestic fuel",
                        "domestic services",
                        "ebooks",
                        "electricity",
                        "electronic services",
                        "foodstuffs",
                        "hotels",
                        "medical",
                        "newspapers",
                        "passenger transport",
                        "pharmaceuticals",
                        "property renovations",
                        "restaurants",
                        "social housing",
                        "water",
                        "wine",
                    )
                )
                .success(true)
                .build()

        assertThat(rateListTypesResponse.code()).contains(200L)
        assertThat(rateListTypesResponse.data().getOrNull())
            .containsExactly(
                "accommodation",
                "admission to cultural events",
                "admission to entertainment events",
                "admission to sporting events",
                "advertising",
                "agricultural supplies",
                "baby foodstuffs",
                "bikes",
                "books",
                "childrens clothing",
                "domestic fuel",
                "domestic services",
                "ebooks",
                "electricity",
                "electronic services",
                "foodstuffs",
                "hotels",
                "medical",
                "newspapers",
                "passenger transport",
                "pharmaceuticals",
                "property renovations",
                "restaurants",
                "social housing",
                "water",
                "wine",
            )
        assertThat(rateListTypesResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rateListTypesResponse =
            RateListTypesResponse.builder()
                .code(200L)
                .data(
                    listOf(
                        "accommodation",
                        "admission to cultural events",
                        "admission to entertainment events",
                        "admission to sporting events",
                        "advertising",
                        "agricultural supplies",
                        "baby foodstuffs",
                        "bikes",
                        "books",
                        "childrens clothing",
                        "domestic fuel",
                        "domestic services",
                        "ebooks",
                        "electricity",
                        "electronic services",
                        "foodstuffs",
                        "hotels",
                        "medical",
                        "newspapers",
                        "passenger transport",
                        "pharmaceuticals",
                        "property renovations",
                        "restaurants",
                        "social housing",
                        "water",
                        "wine",
                    )
                )
                .success(true)
                .build()

        val roundtrippedRateListTypesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateListTypesResponse),
                jacksonTypeRef<RateListTypesResponse>(),
            )

        assertThat(roundtrippedRateListTypesResponse).isEqualTo(rateListTypesResponse)
    }
}
