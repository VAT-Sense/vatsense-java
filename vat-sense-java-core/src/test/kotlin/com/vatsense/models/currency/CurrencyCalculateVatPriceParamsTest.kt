// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.currency

import com.vatsense.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CurrencyCalculateVatPriceParamsTest {

    @Test
    fun create() {
        CurrencyCalculateVatPriceParams.builder()
            .price("20.00")
            .taxType(CurrencyCalculateVatPriceParams.TaxType.EXCL)
            .vatRate(5.0)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            CurrencyCalculateVatPriceParams.builder()
                .price("20.00")
                .taxType(CurrencyCalculateVatPriceParams.TaxType.EXCL)
                .vatRate(5.0)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("price", "20.00")
                    .put("tax_type", "excl")
                    .put("vat_rate", "5.0")
                    .build()
            )
    }
}
