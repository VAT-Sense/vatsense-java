// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClientAsync
import com.vat_sense.api.models.invoice.CreateInvoice
import com.vat_sense.api.models.invoice.InvoiceBusinessInput
import com.vat_sense.api.models.invoice.InvoiceConversionInput
import com.vat_sense.api.models.invoice.InvoiceCustomerInput
import com.vat_sense.api.models.invoice.InvoiceListParams
import com.vat_sense.api.models.invoice.InvoiceUpdateParams
import com.vat_sense.api.models.invoice.item.InvoiceItemInput
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InvoiceServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val invoiceServiceAsync = client.invoice()

        val invoiceResponseFuture =
            invoiceServiceAsync.create(
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

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val invoiceServiceAsync = client.invoice()

        val invoiceResponseFuture = invoiceServiceAsync.retrieve("in5aeae457cda2a")

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val invoiceServiceAsync = client.invoice()

        val invoiceResponseFuture =
            invoiceServiceAsync.update(
                InvoiceUpdateParams.builder()
                    .invoiceId("in5aeae457cda2a")
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
                                InvoiceConversionInput.builder()
                                    .currencyCode("GBP")
                                    .rate(1.523)
                                    .build()
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
            )

        val invoiceResponse = invoiceResponseFuture.get()
        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val invoiceServiceAsync = client.invoice()

        val invoicesFuture =
            invoiceServiceAsync.list(
                InvoiceListParams.builder().limit(1L).offset(0L).search("search").build()
            )

        val invoices = invoicesFuture.get()
        invoices.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val invoiceServiceAsync = client.invoice()

        val invoiceFuture = invoiceServiceAsync.delete("in5aeae457cda2a")

        val invoice = invoiceFuture.get()
        invoice.validate()
    }
}
