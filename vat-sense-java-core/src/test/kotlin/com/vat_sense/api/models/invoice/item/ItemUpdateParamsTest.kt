// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice.item

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemUpdateParamsTest {

    @Test
    fun create() {
        ItemUpdateParams.builder()
            .invoiceId("in5aeae457cda2a")
            .itemId("ii5aeae457ce201")
            .invoiceItemInput(
                InvoiceItemInput.builder()
                    .item("Standard payment plan")
                    .priceEach(19.99)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .discountRate(40.0)
                    .build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            ItemUpdateParams.builder()
                .invoiceId("in5aeae457cda2a")
                .itemId("ii5aeae457ce201")
                .invoiceItemInput(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("in5aeae457cda2a")
        assertThat(params._pathParam(1)).isEqualTo("ii5aeae457ce201")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ItemUpdateParams.builder()
                .invoiceId("in5aeae457cda2a")
                .itemId("ii5aeae457ce201")
                .invoiceItemInput(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .discountRate(40.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                InvoiceItemInput.builder()
                    .item("Standard payment plan")
                    .priceEach(19.99)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .discountRate(40.0)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            ItemUpdateParams.builder()
                .invoiceId("in5aeae457cda2a")
                .itemId("ii5aeae457ce201")
                .invoiceItemInput(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                InvoiceItemInput.builder()
                    .item("Standard payment plan")
                    .priceEach(19.99)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .build()
            )
    }
}
