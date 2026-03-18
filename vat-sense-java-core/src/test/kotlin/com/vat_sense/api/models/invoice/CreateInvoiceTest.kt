// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import com.vat_sense.api.models.invoice.item.InvoiceItemInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreateInvoiceTest {

    @Test
    fun create() {
        val createInvoice =
            CreateInvoice.builder()
                .business(
                    InvoiceBusinessInput.builder()
                        .address("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
                        .name("VAT Sense")
                        .vatNumber("GB12345678")
                        .bankAccount("bank_account")
                        .companyNumber("9839222")
                        .email("dev@stainless.com")
                        .logo("https://example.com")
                        .phone("phone")
                        .website("https://example.com")
                        .build()
                )
                .currencyCode("USD")
                .date("2018-06-03 14:02:00")
                .addItem(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .discountRate(40.0)
                        .build()
                )
                .taxPoint("2018-06-03 14:02:00")
                .conversion(
                    InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()
                )
                .customer(
                    InvoiceCustomerInput.builder()
                        .name("Demo Co.")
                        .address("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
                        .companyNumber("5584922")
                        .countryCode("country_code")
                        .email("dev@stainless.com")
                        .logo("https://example.com")
                        .vatNumber("GB912343332")
                        .build()
                )
                .hasVat(true)
                .invoiceNumber("203")
                .isCopy(true)
                .isReverseCharge(true)
                .notes("notes")
                .padInvoiceNumber(2L)
                .serial("serial")
                .taxType(CreateInvoice.TaxType.INCL)
                .type(CreateInvoice.Type.SALE)
                .zeroRated(true)
                .build()

        assertThat(createInvoice.business())
            .isEqualTo(
                InvoiceBusinessInput.builder()
                    .address("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
                    .name("VAT Sense")
                    .vatNumber("GB12345678")
                    .bankAccount("bank_account")
                    .companyNumber("9839222")
                    .email("dev@stainless.com")
                    .logo("https://example.com")
                    .phone("phone")
                    .website("https://example.com")
                    .build()
            )
        assertThat(createInvoice.currencyCode()).isEqualTo("USD")
        assertThat(createInvoice.date()).isEqualTo("2018-06-03 14:02:00")
        assertThat(createInvoice.items())
            .containsExactly(
                InvoiceItemInput.builder()
                    .item("Standard payment plan")
                    .priceEach(19.99)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .discountRate(40.0)
                    .build()
            )
        assertThat(createInvoice.taxPoint()).isEqualTo("2018-06-03 14:02:00")
        assertThat(createInvoice.conversion())
            .contains(InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build())
        assertThat(createInvoice.customer())
            .contains(
                InvoiceCustomerInput.builder()
                    .name("Demo Co.")
                    .address("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
                    .companyNumber("5584922")
                    .countryCode("country_code")
                    .email("dev@stainless.com")
                    .logo("https://example.com")
                    .vatNumber("GB912343332")
                    .build()
            )
        assertThat(createInvoice.hasVat()).contains(true)
        assertThat(createInvoice.invoiceNumber()).contains("203")
        assertThat(createInvoice.isCopy()).contains(true)
        assertThat(createInvoice.isReverseCharge()).contains(true)
        assertThat(createInvoice.notes()).contains("notes")
        assertThat(createInvoice.padInvoiceNumber()).contains(2L)
        assertThat(createInvoice.serial()).contains("serial")
        assertThat(createInvoice.taxType()).contains(CreateInvoice.TaxType.INCL)
        assertThat(createInvoice.type()).contains(CreateInvoice.Type.SALE)
        assertThat(createInvoice.zeroRated()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val createInvoice =
            CreateInvoice.builder()
                .business(
                    InvoiceBusinessInput.builder()
                        .address("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
                        .name("VAT Sense")
                        .vatNumber("GB12345678")
                        .bankAccount("bank_account")
                        .companyNumber("9839222")
                        .email("dev@stainless.com")
                        .logo("https://example.com")
                        .phone("phone")
                        .website("https://example.com")
                        .build()
                )
                .currencyCode("USD")
                .date("2018-06-03 14:02:00")
                .addItem(
                    InvoiceItemInput.builder()
                        .item("Standard payment plan")
                        .priceEach(19.99)
                        .quantity(1.0)
                        .vatRate(20.0)
                        .discountRate(40.0)
                        .build()
                )
                .taxPoint("2018-06-03 14:02:00")
                .conversion(
                    InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()
                )
                .customer(
                    InvoiceCustomerInput.builder()
                        .name("Demo Co.")
                        .address("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
                        .companyNumber("5584922")
                        .countryCode("country_code")
                        .email("dev@stainless.com")
                        .logo("https://example.com")
                        .vatNumber("GB912343332")
                        .build()
                )
                .hasVat(true)
                .invoiceNumber("203")
                .isCopy(true)
                .isReverseCharge(true)
                .notes("notes")
                .padInvoiceNumber(2L)
                .serial("serial")
                .taxType(CreateInvoice.TaxType.INCL)
                .type(CreateInvoice.Type.SALE)
                .zeroRated(true)
                .build()

        val roundtrippedCreateInvoice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(createInvoice),
                jacksonTypeRef<CreateInvoice>(),
            )

        assertThat(roundtrippedCreateInvoice).isEqualTo(createInvoice)
    }
}
