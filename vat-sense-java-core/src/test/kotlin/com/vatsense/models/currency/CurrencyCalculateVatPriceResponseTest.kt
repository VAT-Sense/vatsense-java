// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.currency

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyCalculateVatPriceResponseTest {

    @Test
    fun create() {
        val currencyCalculateVatPriceResponse =
            CurrencyCalculateVatPriceResponse.builder()
                .code(200L)
                .data(
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
                .success(true)
                .build()

        assertThat(currencyCalculateVatPriceResponse.code()).contains(200L)
        assertThat(currencyCalculateVatPriceResponse.data())
            .contains(
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
        assertThat(currencyCalculateVatPriceResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val currencyCalculateVatPriceResponse =
            CurrencyCalculateVatPriceResponse.builder()
                .code(200L)
                .data(
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
                .success(true)
                .build()

        val roundtrippedCurrencyCalculateVatPriceResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(currencyCalculateVatPriceResponse),
                jacksonTypeRef<CurrencyCalculateVatPriceResponse>(),
            )

        assertThat(roundtrippedCurrencyCalculateVatPriceResponse)
            .isEqualTo(currencyCalculateVatPriceResponse)
    }
}
