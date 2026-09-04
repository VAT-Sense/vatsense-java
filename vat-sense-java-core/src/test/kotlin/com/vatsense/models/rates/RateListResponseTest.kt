// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateListResponseTest {

    @Test
    fun create() {
        val rateListResponse =
            RateListResponse.builder()
                .code(200L)
                .addData(
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
                                .taxName("vat")
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
                                .taxName("vat")
                                .types(false)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        assertThat(rateListResponse.code()).contains(200L)
        assertThat(rateListResponse.data().getOrNull())
            .containsExactly(
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
                            .taxName("vat")
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
                            .taxName("vat")
                            .types(false)
                            .build()
                    )
                    .build()
            )
        assertThat(rateListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rateListResponse =
            RateListResponse.builder()
                .code(200L)
                .addData(
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
                                .taxName("vat")
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
                                .taxName("vat")
                                .types(false)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedRateListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateListResponse),
                jacksonTypeRef<RateListResponse>(),
            )

        assertThat(roundtrippedRateListResponse).isEqualTo(rateListResponse)
    }
}
