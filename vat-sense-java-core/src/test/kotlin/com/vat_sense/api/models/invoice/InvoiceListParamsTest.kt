// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.vat_sense.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceListParamsTest {

    @Test
    fun create() {
        InvoiceListParams.builder().limit(1L).offset(0L).search("search").build()
    }

    @Test
    fun queryParams() {
        val params = InvoiceListParams.builder().limit(1L).offset(0L).search("search").build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "1")
                    .put("offset", "0")
                    .put("search", "search")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InvoiceListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
