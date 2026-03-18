// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClient
import com.vat_sense.api.models.invoice.CreateInvoice
import com.vat_sense.api.models.invoice.InvoiceBusinessInput
import com.vat_sense.api.models.invoice.InvoiceConversionInput
import com.vat_sense.api.models.invoice.InvoiceCustomerInput
import com.vat_sense.api.models.invoice.InvoiceListParams
import com.vat_sense.api.models.invoice.InvoiceUpdateParams
import com.vat_sense.api.models.invoice.item.InvoiceItemInput
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InvoiceServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val invoiceService = client.invoice()

        val invoiceResponse =
            invoiceService.create(
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

        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val invoiceService = client.invoice()

        val invoiceResponse = invoiceService.retrieve("in5aeae457cda2a")

        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun update() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val invoiceService = client.invoice()

        val invoiceResponse =
            invoiceService.update(
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

        invoiceResponse.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val invoiceService = client.invoice()

        val invoices =
            invoiceService.list(
                InvoiceListParams.builder().limit(1L).offset(0L).search("search").build()
            )

        invoices.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val invoiceService = client.invoice()

        val invoice = invoiceService.delete("in5aeae457cda2a")

        invoice.validate()
    }
}
