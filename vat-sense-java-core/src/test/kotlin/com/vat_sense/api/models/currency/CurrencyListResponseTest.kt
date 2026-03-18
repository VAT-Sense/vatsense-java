// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.currency

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyListResponseTest {

    @Test
    fun create() {
        val currencyListResponse =
            CurrencyListResponse.builder()
                .code(200L)
                .addData(
                    CurrencyListResponse.Data.builder()
                        .from("USD")
                        .object_(CurrencyListResponse.Data.Object.CONVERT_RATE)
                        .rate(1.4065)
                        .to("GBP")
                        .build()
                )
                .success(true)
                .build()

        assertThat(currencyListResponse.code()).contains(200L)
        assertThat(currencyListResponse.data().getOrNull())
            .containsExactly(
                CurrencyListResponse.Data.builder()
                    .from("USD")
                    .object_(CurrencyListResponse.Data.Object.CONVERT_RATE)
                    .rate(1.4065)
                    .to("GBP")
                    .build()
            )
        assertThat(currencyListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val currencyListResponse =
            CurrencyListResponse.builder()
                .code(200L)
                .addData(
                    CurrencyListResponse.Data.builder()
                        .from("USD")
                        .object_(CurrencyListResponse.Data.Object.CONVERT_RATE)
                        .rate(1.4065)
                        .to("GBP")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedCurrencyListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(currencyListResponse),
                jacksonTypeRef<CurrencyListResponse>(),
            )

        assertThat(roundtrippedCurrencyListResponse).isEqualTo(currencyListResponse)
    }
}
