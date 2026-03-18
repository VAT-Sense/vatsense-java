// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice.item

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceItemTest {

    @Test
    fun create() {
        val invoiceItem =
            InvoiceItem.builder()
                .id("ii5aeae457ce201")
                .discountRate(40.0)
                .item("Standard payment plan")
                .object_(InvoiceItem.Object.ITEM)
                .priceEach(19.99)
                .priceTotal(11.99)
                .quantity(1.0)
                .vatRate(20.0)
                .build()

        assertThat(invoiceItem.id()).contains("ii5aeae457ce201")
        assertThat(invoiceItem.discountRate()).contains(40.0)
        assertThat(invoiceItem.item()).contains("Standard payment plan")
        assertThat(invoiceItem.object_()).contains(InvoiceItem.Object.ITEM)
        assertThat(invoiceItem.priceEach()).contains(19.99)
        assertThat(invoiceItem.priceTotal()).contains(11.99)
        assertThat(invoiceItem.quantity()).contains(1.0)
        assertThat(invoiceItem.vatRate()).contains(20.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceItem =
            InvoiceItem.builder()
                .id("ii5aeae457ce201")
                .discountRate(40.0)
                .item("Standard payment plan")
                .object_(InvoiceItem.Object.ITEM)
                .priceEach(19.99)
                .priceTotal(11.99)
                .quantity(1.0)
                .vatRate(20.0)
                .build()

        val roundtrippedInvoiceItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceItem),
                jacksonTypeRef<InvoiceItem>(),
            )

        assertThat(roundtrippedInvoiceItem).isEqualTo(invoiceItem)
    }
}
