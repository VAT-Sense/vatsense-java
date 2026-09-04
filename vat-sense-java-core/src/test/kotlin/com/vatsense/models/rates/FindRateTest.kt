// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FindRateTest {

    @Test
    fun create() {
        val findRate =
            FindRate.builder()
                .code(200L)
                .data(
                    RateWithTaxRate.builder()
                        .countryCode("FR")
                        .countryName("France")
                        .eu(true)
                        .object_(RateWithTaxRate.Object.RATE)
                        .taxRate(
                            TaxRate.builder()
                                .class_("standard")
                                .description("")
                                .object_(TaxRate.Object.TAX_RATE)
                                .rate(20.0)
                                .taxName("vat")
                                .types(false)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        assertThat(findRate.code()).contains(200L)
        assertThat(findRate.data())
            .contains(
                RateWithTaxRate.builder()
                    .countryCode("FR")
                    .countryName("France")
                    .eu(true)
                    .object_(RateWithTaxRate.Object.RATE)
                    .taxRate(
                        TaxRate.builder()
                            .class_("standard")
                            .description("")
                            .object_(TaxRate.Object.TAX_RATE)
                            .rate(20.0)
                            .taxName("vat")
                            .types(false)
                            .build()
                    )
                    .build()
            )
        assertThat(findRate.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val findRate =
            FindRate.builder()
                .code(200L)
                .data(
                    RateWithTaxRate.builder()
                        .countryCode("FR")
                        .countryName("France")
                        .eu(true)
                        .object_(RateWithTaxRate.Object.RATE)
                        .taxRate(
                            TaxRate.builder()
                                .class_("standard")
                                .description("")
                                .object_(TaxRate.Object.TAX_RATE)
                                .rate(20.0)
                                .taxName("vat")
                                .types(false)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedFindRate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(findRate),
                jacksonTypeRef<FindRate>(),
            )

        assertThat(roundtrippedFindRate).isEqualTo(findRate)
    }
}
