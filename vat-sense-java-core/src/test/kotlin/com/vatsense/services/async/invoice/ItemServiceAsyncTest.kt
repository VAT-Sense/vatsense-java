// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async.invoice

import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import com.vatsense.models.invoice.item.InvoiceItemInput
import com.vatsense.models.invoice.item.ItemAddParams
import com.vatsense.models.invoice.item.ItemDeleteParams
import com.vatsense.models.invoice.item.ItemRetrieveParams
import com.vatsense.models.invoice.item.ItemUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ItemServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val itemServiceAsync = client.invoice().item()

        val itemFuture =
            itemServiceAsync.retrieve(
                ItemRetrieveParams.builder()
                    .invoiceId("in5aeae457cda2a")
                    .itemId("ii5aeae457ce201")
                    .build()
            )

        val item = itemFuture.get()
        item.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val itemServiceAsync = client.invoice().item()

        val invoiceResponseFuture =
            itemServiceAsync.update(
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
            )

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val itemServiceAsync = client.invoice().item()

        val invoiceResponseFuture =
            itemServiceAsync.delete(
                ItemDeleteParams.builder()
                    .invoiceId("in5aeae457cda2a")
                    .itemId("ii5aeae457ce201")
                    .build()
            )

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun add() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val itemServiceAsync = client.invoice().item()

        val invoiceResponseFuture =
            itemServiceAsync.add(
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
            )

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }
}
