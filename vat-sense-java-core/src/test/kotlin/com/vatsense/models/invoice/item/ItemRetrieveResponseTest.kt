// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice.item

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ItemRetrieveResponseTest {

    @Test
    fun create() {
        val itemRetrieveResponse =
            ItemRetrieveResponse.builder()
                .code(200L)
                .data(
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
                )
                .success(true)
                .build()

        assertThat(itemRetrieveResponse.code()).contains(200L)
        assertThat(itemRetrieveResponse.data())
            .contains(
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
            )
        assertThat(itemRetrieveResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val itemRetrieveResponse =
            ItemRetrieveResponse.builder()
                .code(200L)
                .data(
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
                )
                .success(true)
                .build()

        val roundtrippedItemRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(itemRetrieveResponse),
                jacksonTypeRef<ItemRetrieveResponse>(),
            )

        assertThat(roundtrippedItemRetrieveResponse).isEqualTo(itemRetrieveResponse)
    }
}
