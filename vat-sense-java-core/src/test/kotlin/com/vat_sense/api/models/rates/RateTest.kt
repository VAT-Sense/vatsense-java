// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateTest {

    @Test
    fun create() {
        val rate =
            Rate.builder()
                .countryCode("FR")
                .countryName("France")
                .eu(true)
                .object_(Rate.Object.RATE)
                .addOther(
                    Rate.Other.builder()
                        .class_("standard")
                        .description("")
                        .object_(TaxRate.Object.TAX_RATE)
                        .rate(20.0)
                        .types(false)
                        .province("province")
                        .build()
                )
                .standard(
                    TaxRate.builder()
                        .class_("standard")
                        .description("")
                        .object_(TaxRate.Object.TAX_RATE)
                        .rate(20.0)
                        .types(false)
                        .build()
                )
                .build()

        assertThat(rate.countryCode()).contains("FR")
        assertThat(rate.countryName()).contains("France")
        assertThat(rate.eu()).contains(true)
        assertThat(rate.object_()).contains(Rate.Object.RATE)
        assertThat(rate.other().getOrNull())
            .containsExactly(
                Rate.Other.builder()
                    .class_("standard")
                    .description("")
                    .object_(TaxRate.Object.TAX_RATE)
                    .rate(20.0)
                    .types(false)
                    .province("province")
                    .build()
            )
        assertThat(rate.standard())
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
        val rate =
            Rate.builder()
                .countryCode("FR")
                .countryName("France")
                .eu(true)
                .object_(Rate.Object.RATE)
                .addOther(
                    Rate.Other.builder()
                        .class_("standard")
                        .description("")
                        .object_(TaxRate.Object.TAX_RATE)
                        .rate(20.0)
                        .types(false)
                        .province("province")
                        .build()
                )
                .standard(
                    TaxRate.builder()
                        .class_("standard")
                        .description("")
                        .object_(TaxRate.Object.TAX_RATE)
                        .rate(20.0)
                        .types(false)
                        .build()
                )
                .build()

        val roundtrippedRate =
            jsonMapper.readValue(jsonMapper.writeValueAsString(rate), jacksonTypeRef<Rate>())

        assertThat(roundtrippedRate).isEqualTo(rate)
    }
}
