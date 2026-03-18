// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.currency

import com.vatsense.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyConvertParamsTest {

    @Test
    fun create() {
        CurrencyConvertParams.builder()
            .amount("39.99")
            .from("USD")
            .to(CurrencyConvertParams.To.GBP)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CurrencyConvertParams.builder()
                .amount("39.99")
                .from("USD")
                .to(CurrencyConvertParams.To.GBP)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("amount", "39.99")
                    .put("from", "USD")
                    .put("to", "GBP")
                    .build()
            )
    }
}
