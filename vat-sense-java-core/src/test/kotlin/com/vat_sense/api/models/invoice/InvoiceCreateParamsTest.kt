// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.vat_sense.api.models.invoice.item.InvoiceItemInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceCreateParamsTest {

    @Test
    fun create() {
        InvoiceCreateParams.builder()
            .createInvoice(
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
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            InvoiceCreateParams.builder()
                .createInvoice(
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
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
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
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            InvoiceCreateParams.builder()
                .createInvoice(
                    CreateInvoice.builder()
                        .business(
                            InvoiceBusinessInput.builder()
                                .address("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
                                .name("VAT Sense")
                                .vatNumber("GB12345678")
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
                                .build()
                        )
                        .taxPoint("2018-06-03 14:02:00")
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body)
            .isEqualTo(
                CreateInvoice.builder()
                    .business(
                        InvoiceBusinessInput.builder()
                            .address("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
                            .name("VAT Sense")
                            .vatNumber("GB12345678")
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
                            .build()
                    )
                    .taxPoint("2018-06-03 14:02:00")
                    .build()
            )
    }
}
