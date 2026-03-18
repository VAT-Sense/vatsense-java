// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import com.vat_sense.api.models.invoice.item.InvoiceItem
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceTest {

    @Test
    fun create() {
        val invoice =
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

        assertThat(invoice.id()).contains("in5aeae457cda2a")
        assertThat(invoice.business())
            .contains(
                Invoice.Business.builder()
                    .address("address")
                    .companyNumber("company_number")
                    .logo("logo")
                    .name("name")
                    .vatNumber("vat_number")
                    .build()
            )
        assertThat(invoice.conversion())
            .contains(InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build())
        assertThat(invoice.created()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(invoice.currencyCode()).contains("USD")
        assertThat(invoice.customer())
            .contains(
                Invoice.Customer.builder()
                    .address("address")
                    .companyNumber("company_number")
                    .logo("logo")
                    .name("name")
                    .vatNumber("vat_number")
                    .build()
            )
        assertThat(invoice.date()).contains("2018-06-03 14:02:00")
        assertThat(invoice.hasVat()).contains(true)
        assertThat(invoice.invoiceNumber()).contains("203")
        assertThat(invoice.invoiceUrl()).contains("https://vatsense.com/invoice/1/in5aeae457cda2a")
        assertThat(invoice.isCopy()).contains(false)
        assertThat(invoice.isReverseCharge()).contains(false)
        assertThat(invoice.items().getOrNull())
            .containsExactly(
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
        assertThat(invoice.notes()).contains("notes")
        assertThat(invoice.numItems()).contains(1L)
        assertThat(invoice.object_()).contains(Invoice.Object.INVOICE)
        assertThat(invoice.taxPoint()).contains("2018-06-03 14:02:00")
        assertThat(invoice.taxType()).contains(Invoice.TaxType.INCL)
        assertThat(invoice.totals())
            .contains(
                Invoice.Totals.builder().discount(8.0).subtotal(11.99).total(14.39).vat(2.4).build()
            )
        assertThat(invoice.type()).contains(Invoice.Type.SALE)
        assertThat(invoice.updated()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(invoice.zeroRated()).contains(false)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoice =
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

        val roundtrippedInvoice =
            jsonMapper.readValue(jsonMapper.writeValueAsString(invoice), jacksonTypeRef<Invoice>())

        assertThat(roundtrippedInvoice).isEqualTo(invoice)
    }
}
