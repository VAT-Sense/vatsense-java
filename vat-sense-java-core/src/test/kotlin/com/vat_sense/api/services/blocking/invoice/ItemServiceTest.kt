// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking.invoice

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClient
import com.vat_sense.api.models.invoice.item.InvoiceItemInput
import com.vat_sense.api.models.invoice.item.ItemAddParams
import com.vat_sense.api.models.invoice.item.ItemDeleteParams
import com.vat_sense.api.models.invoice.item.ItemRetrieveParams
import com.vat_sense.api.models.invoice.item.ItemUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ItemServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val itemService = client.invoice().item()

        val item =
            itemService.retrieve(
                ItemRetrieveParams.builder()
                    .invoiceId("in5aeae457cda2a")
                    .itemId("ii5aeae457ce201")
                    .build()
            )

        item.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val itemService = client.invoice().item()

        val invoiceResponse =
            itemService.update(
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

        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val itemService = client.invoice().item()

        val invoiceResponse =
            itemService.delete(
                ItemDeleteParams.builder()
                    .invoiceId("in5aeae457cda2a")
                    .itemId("ii5aeae457ce201")
                    .build()
            )

        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun add() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val itemService = client.invoice().item()

        val invoiceResponse =
            itemService.add(
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

        invoiceResponse.validate()
    }
}
