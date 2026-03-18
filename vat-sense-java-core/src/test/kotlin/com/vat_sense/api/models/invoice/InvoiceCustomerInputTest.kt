// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceCustomerInputTest {

    @Test
    fun create() {
        val invoiceCustomerInput =
            InvoiceCustomerInput.builder()
                .name("Demo Co.")
                .address("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
                .companyNumber("5584922")
                .countryCode("country_code")
                .email("dev@stainless.com")
                .logo("https://example.com")
                .vatNumber("GB912343332")
                .build()

        assertThat(invoiceCustomerInput.name()).isEqualTo("Demo Co.")
        assertThat(invoiceCustomerInput.address())
            .contains("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
        assertThat(invoiceCustomerInput.companyNumber()).contains("5584922")
        assertThat(invoiceCustomerInput.countryCode()).contains("country_code")
        assertThat(invoiceCustomerInput.email()).contains("dev@stainless.com")
        assertThat(invoiceCustomerInput.logo()).contains("https://example.com")
        assertThat(invoiceCustomerInput.vatNumber()).contains("GB912343332")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceCustomerInput =
            InvoiceCustomerInput.builder()
                .name("Demo Co.")
                .address("65 Demo Road\nLondon\nSW1 3DE\nUnited Kingdom")
                .companyNumber("5584922")
                .countryCode("country_code")
                .email("dev@stainless.com")
                .logo("https://example.com")
                .vatNumber("GB912343332")
                .build()

        val roundtrippedInvoiceCustomerInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceCustomerInput),
                jacksonTypeRef<InvoiceCustomerInput>(),
            )

        assertThat(roundtrippedInvoiceCustomerInput).isEqualTo(invoiceCustomerInput)
    }
}
