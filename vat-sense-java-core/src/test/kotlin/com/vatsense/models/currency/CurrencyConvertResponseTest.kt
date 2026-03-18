// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.currency

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyConvertResponseTest {

    @Test
    fun create() {
        val currencyConvertResponse =
            CurrencyConvertResponse.builder()
                .code(200L)
                .data(
                    CurrencyConvertResponse.Data.builder()
                        .amount(39.99)
                        .converted(28.43)
                        .from("USD")
                        .object_(CurrencyConvertResponse.Data.Object.CONVERSION)
                        .rate(1.4065)
                        .to("GBP")
                        .build()
                )
                .success(true)
                .build()

        assertThat(currencyConvertResponse.code()).contains(200L)
        assertThat(currencyConvertResponse.data())
            .contains(
                CurrencyConvertResponse.Data.builder()
                    .amount(39.99)
                    .converted(28.43)
                    .from("USD")
                    .object_(CurrencyConvertResponse.Data.Object.CONVERSION)
                    .rate(1.4065)
                    .to("GBP")
                    .build()
            )
        assertThat(currencyConvertResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val currencyConvertResponse =
            CurrencyConvertResponse.builder()
                .code(200L)
                .data(
                    CurrencyConvertResponse.Data.builder()
                        .amount(39.99)
                        .converted(28.43)
                        .from("USD")
                        .object_(CurrencyConvertResponse.Data.Object.CONVERSION)
                        .rate(1.4065)
                        .to("GBP")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedCurrencyConvertResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(currencyConvertResponse),
                jacksonTypeRef<CurrencyConvertResponse>(),
            )

        assertThat(roundtrippedCurrencyConvertResponse).isEqualTo(currencyConvertResponse)
    }
}
