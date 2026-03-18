// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice.item

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemRetrieveParamsTest {

    @Test
    fun create() {
        ItemRetrieveParams.builder().invoiceId("in5aeae457cda2a").itemId("ii5aeae457ce201").build()
    }

    @Test
    fun pathParams() {
        val params =
            ItemRetrieveParams.builder()
                .invoiceId("in5aeae457cda2a")
                .itemId("ii5aeae457ce201")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("in5aeae457cda2a")
        assertThat(params._pathParam(1)).isEqualTo("ii5aeae457ce201")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
