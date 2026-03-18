// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import com.vatsense.models.invoice.item.InvoiceItem
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceListResponseTest {

    @Test
    fun create() {
        val invoiceListResponse =
            InvoiceListResponse.builder()
                .code(200L)
                .addData(
                    Invoice.builder()
                        .id("in5aeae457cda2a")
                        .business(
                            Invoice.Business.builder()
                                .address("address")
                                .companyNumber("company_number")
                                .logo("logo")
                                .name("name")
                                .vatNumber("vat_number")
                                .build()
                        )
                        .conversion(
                            InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()
                        )
                        .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .currencyCode("USD")
                        .customer(
                            Invoice.Customer.builder()
                                .address("address")
                                .companyNumber("company_number")
                                .logo("logo")
                                .name("name")
                                .vatNumber("vat_number")
                                .build()
                        )
                        .date("2018-06-03 14:02:00")
                        .hasVat(true)
                        .invoiceNumber("203")
                        .invoiceUrl("https://vatsense.com/invoice/1/in5aeae457cda2a")
                        .isCopy(false)
                        .isReverseCharge(false)
                        .addItem(
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
                        .notes("notes")
                        .numItems(1L)
                        .object_(Invoice.Object.INVOICE)
                        .taxPoint("2018-06-03 14:02:00")
                        .taxType(Invoice.TaxType.INCL)
                        .totals(
                            Invoice.Totals.builder()
                                .discount(8.0)
                                .subtotal(11.99)
                                .total(14.39)
                                .vat(2.4)
                                .build()
                        )
                        .type(Invoice.Type.SALE)
                        .updated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .zeroRated(false)
                        .build()
                )
                .success(true)
                .build()

        assertThat(invoiceListResponse.code()).contains(200L)
        assertThat(invoiceListResponse.data().getOrNull())
            .containsExactly(
                Invoice.builder()
                    .id("in5aeae457cda2a")
                    .business(
                        Invoice.Business.builder()
                            .address("address")
                            .companyNumber("company_number")
                            .logo("logo")
                            .name("name")
                            .vatNumber("vat_number")
                            .build()
                    )
                    .conversion(
                        InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()
                    )
                    .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .currencyCode("USD")
                    .customer(
                        Invoice.Customer.builder()
                            .address("address")
                            .companyNumber("company_number")
                            .logo("logo")
                            .name("name")
                            .vatNumber("vat_number")
                            .build()
                    )
                    .date("2018-06-03 14:02:00")
                    .hasVat(true)
                    .invoiceNumber("203")
                    .invoiceUrl("https://vatsense.com/invoice/1/in5aeae457cda2a")
                    .isCopy(false)
                    .isReverseCharge(false)
                    .addItem(
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
                    .notes("notes")
                    .numItems(1L)
                    .object_(Invoice.Object.INVOICE)
                    .taxPoint("2018-06-03 14:02:00")
                    .taxType(Invoice.TaxType.INCL)
                    .totals(
                        Invoice.Totals.builder()
                            .discount(8.0)
                            .subtotal(11.99)
                            .total(14.39)
                            .vat(2.4)
                            .build()
                    )
                    .type(Invoice.Type.SALE)
                    .updated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .zeroRated(false)
                    .build()
            )
        assertThat(invoiceListResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceListResponse =
            InvoiceListResponse.builder()
                .code(200L)
                .addData(
                    Invoice.builder()
                        .id("in5aeae457cda2a")
                        .business(
                            Invoice.Business.builder()
                                .address("address")
                                .companyNumber("company_number")
                                .logo("logo")
                                .name("name")
                                .vatNumber("vat_number")
                                .build()
                        )
                        .conversion(
                            InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()
                        )
                        .created(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .currencyCode("USD")
                        .customer(
                            Invoice.Customer.builder()
                                .address("address")
                                .companyNumber("company_number")
                                .logo("logo")
                                .name("name")
                                .vatNumber("vat_number")
                                .build()
                        )
                        .date("2018-06-03 14:02:00")
                        .hasVat(true)
                        .invoiceNumber("203")
                        .invoiceUrl("https://vatsense.com/invoice/1/in5aeae457cda2a")
                        .isCopy(false)
                        .isReverseCharge(false)
                        .addItem(
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
                        .notes("notes")
                        .numItems(1L)
                        .object_(Invoice.Object.INVOICE)
                        .taxPoint("2018-06-03 14:02:00")
                        .taxType(Invoice.TaxType.INCL)
                        .totals(
                            Invoice.Totals.builder()
                                .discount(8.0)
                                .subtotal(11.99)
                                .total(14.39)
                                .vat(2.4)
                                .build()
                        )
                        .type(Invoice.Type.SALE)
                        .updated(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .zeroRated(false)
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedInvoiceListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceListResponse),
                jacksonTypeRef<InvoiceListResponse>(),
            )

        assertThat(roundtrippedInvoiceListResponse).isEqualTo(invoiceListResponse)
    }
}
