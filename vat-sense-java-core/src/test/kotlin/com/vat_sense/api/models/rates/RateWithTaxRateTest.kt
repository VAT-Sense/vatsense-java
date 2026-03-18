// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateWithTaxRateTest {

    @Test
    fun create() {
        val rateWithTaxRate =
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
                        .types(false)
                        .build()
                )
                .build()

        assertThat(rateWithTaxRate.countryCode()).contains("FR")
        assertThat(rateWithTaxRate.countryName()).contains("France")
        assertThat(rateWithTaxRate.eu()).contains(true)
        assertThat(rateWithTaxRate.object_()).contains(RateWithTaxRate.Object.RATE)
        assertThat(rateWithTaxRate.taxRate())
            .contains(
                TaxRate.builder()
                    .class_("standard")
                    .description("")
                    .object_(TaxRate.Object.TAX_RATE)
                    .rate(20.0)
                    .types(false)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rateWithTaxRate =
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
                        .types(false)
                        .build()
                )
                .build()

        val roundtrippedRateWithTaxRate =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateWithTaxRate),
                jacksonTypeRef<RateWithTaxRate>(),
            )

        assertThat(roundtrippedRateWithTaxRate).isEqualTo(rateWithTaxRate)
    }
}
