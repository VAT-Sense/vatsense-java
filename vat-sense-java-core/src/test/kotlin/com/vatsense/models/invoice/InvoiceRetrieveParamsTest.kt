// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceRetrieveParamsTest {

    @Test
    fun create() {
        InvoiceRetrieveParams.builder().invoiceId("in5aeae457cda2a").build()
    }

    @Test
    fun pathParams() {
        val params = InvoiceRetrieveParams.builder().invoiceId("in5aeae457cda2a").build()

        assertThat(params._pathParam(0)).isEqualTo("in5aeae457cda2a")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
