// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice.item

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemAddParamsTest {

    @Test
    fun create() {
        ItemAddParams.builder()
            .invoiceId("in5aeae457cda2a")
            .addItem(
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
            ItemAddParams.builder()
                .invoiceId("in5aeae457cda2a")
                .addItem(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .build()
                )
                .build()

        assertThat(params._pathParam(0)).isEqualTo("in5aeae457cda2a")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            ItemAddParams.builder()
                .invoiceId("in5aeae457cda2a")
                .addItem(
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

        assertThat(body.items())
            .containsExactly(
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
            ItemAddParams.builder()
                .invoiceId("in5aeae457cda2a")
                .addItem(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.items())
            .containsExactly(
                InvoiceItemInput.builder()
                    .item("Standard payment plan")
                    .priceEach(19.99)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .build()
            )
    }
}
