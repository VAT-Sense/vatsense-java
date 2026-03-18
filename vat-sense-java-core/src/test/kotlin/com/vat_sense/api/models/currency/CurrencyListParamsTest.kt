// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.currency

import com.vat_sense.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyListParamsTest {

    @Test
    fun create() {
        CurrencyListParams.builder().from("USD,CAD,AUD").to(CurrencyListParams.To.GBP).build()
    }

    @Test
    fun queryParams() {
        val params =
            CurrencyListParams.builder().from("USD,CAD,AUD").to(CurrencyListParams.To.GBP).build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(QueryParams.builder().put("from", "USD,CAD,AUD").put("to", "GBP").build())
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = CurrencyListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
