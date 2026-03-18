// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice.item

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceItemInputTest {

    @Test
    fun create() {
        val invoiceItemInput =
            InvoiceItemInput.builder()
                .item("Standard payment plan")
                .priceEach(19.99)
                .quantity(1.0)
                .vatRate(20.0)
                .discountRate(40.0)
                .build()

        assertThat(invoiceItemInput.item()).isEqualTo("Standard payment plan")
        assertThat(invoiceItemInput.priceEach()).isEqualTo(19.99)
        assertThat(invoiceItemInput.quantity()).isEqualTo(1.0)
        assertThat(invoiceItemInput.vatRate()).isEqualTo(20.0)
        assertThat(invoiceItemInput.discountRate()).contains(40.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceItemInput =
            InvoiceItemInput.builder()
                .item("Standard payment plan")
                .priceEach(19.99)
                .quantity(1.0)
                .vatRate(20.0)
                .discountRate(40.0)
                .build()

        val roundtrippedInvoiceItemInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceItemInput),
                jacksonTypeRef<InvoiceItemInput>(),
            )

        assertThat(roundtrippedInvoiceItemInput).isEqualTo(invoiceItemInput)
    }
}
