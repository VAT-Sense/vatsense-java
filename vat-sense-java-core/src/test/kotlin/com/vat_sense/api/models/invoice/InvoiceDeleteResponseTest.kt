// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceDeleteResponseTest {

    @Test
    fun create() {
        val invoiceDeleteResponse = InvoiceDeleteResponse.builder().code(200L).success(true).build()

        assertThat(invoiceDeleteResponse.code()).isEqualTo(200L)
        assertThat(invoiceDeleteResponse.success()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceDeleteResponse = InvoiceDeleteResponse.builder().code(200L).success(true).build()

        val roundtrippedInvoiceDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceDeleteResponse),
                jacksonTypeRef<InvoiceDeleteResponse>(),
            )

        assertThat(roundtrippedInvoiceDeleteResponse).isEqualTo(invoiceDeleteResponse)
    }
}
