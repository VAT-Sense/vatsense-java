// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import com.vatsense.models.currency.VatPrice
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateCalculatePriceResponseTest {

    @Test
    fun create() {
        val rateCalculatePriceResponse =
            RateCalculatePriceResponse.builder()
                .code(200L)
                .data(
                    RateCalculatePriceResponse.Data.builder()
                        .countryCode("FR")
                        .countryName("France")
                        .eu(true)
                        .object_(RateCalculatePriceResponse.Data.Object.RATE)
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
                        .vatPrice(
                            VatPrice.builder()
                                .object_(VatPrice.Object.VAT_PRICE)
                                .price(20.0)
                                .priceExclVat(20.0)
                                .priceInclVat(21.1)
                                .taxType(VatPrice.TaxType.EXCL)
                                .vat(1.1)
                                .vatRate(5.5)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        assertThat(rateCalculatePriceResponse.code()).contains(200L)
        assertThat(rateCalculatePriceResponse.data())
            .contains(
                RateCalculatePriceResponse.Data.builder()
                    .countryCode("FR")
                    .countryName("France")
                    .eu(true)
                    .object_(RateCalculatePriceResponse.Data.Object.RATE)
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
                    .vatPrice(
                        VatPrice.builder()
                            .object_(VatPrice.Object.VAT_PRICE)
                            .price(20.0)
                            .priceExclVat(20.0)
                            .priceInclVat(21.1)
                            .taxType(VatPrice.TaxType.EXCL)
                            .vat(1.1)
                            .vatRate(5.5)
                            .build()
                    )
                    .build()
            )
        assertThat(rateCalculatePriceResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val rateCalculatePriceResponse =
            RateCalculatePriceResponse.builder()
                .code(200L)
                .data(
                    RateCalculatePriceResponse.Data.builder()
                        .countryCode("FR")
                        .countryName("France")
                        .eu(true)
                        .object_(RateCalculatePriceResponse.Data.Object.RATE)
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
                        .vatPrice(
                            VatPrice.builder()
                                .object_(VatPrice.Object.VAT_PRICE)
                                .price(20.0)
                                .priceExclVat(20.0)
                                .priceInclVat(21.1)
                                .taxType(VatPrice.TaxType.EXCL)
                                .vat(1.1)
                                .vatRate(5.5)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedRateCalculatePriceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(rateCalculatePriceResponse),
                jacksonTypeRef<RateCalculatePriceResponse>(),
            )

        assertThat(roundtrippedRateCalculatePriceResponse).isEqualTo(rateCalculatePriceResponse)
    }
}
