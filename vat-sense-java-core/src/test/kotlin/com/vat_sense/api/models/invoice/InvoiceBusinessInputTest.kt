// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceBusinessInputTest {

    @Test
    fun create() {
        val invoiceBusinessInput =
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

        assertThat(invoiceBusinessInput.address())
            .isEqualTo("123 Example Street\nLondon\nSW3 1GL\nUnited Kingdom")
        assertThat(invoiceBusinessInput.name()).isEqualTo("VAT Sense")
        assertThat(invoiceBusinessInput.vatNumber()).isEqualTo("GB12345678")
        assertThat(invoiceBusinessInput.bankAccount()).contains("bank_account")
        assertThat(invoiceBusinessInput.companyNumber()).contains("9839222")
        assertThat(invoiceBusinessInput.email()).contains("dev@stainless.com")
        assertThat(invoiceBusinessInput.logo()).contains("https://example.com")
        assertThat(invoiceBusinessInput.phone()).contains("phone")
        assertThat(invoiceBusinessInput.website()).contains("https://example.com")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceBusinessInput =
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

        val roundtrippedInvoiceBusinessInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceBusinessInput),
                jacksonTypeRef<InvoiceBusinessInput>(),
            )

        assertThat(roundtrippedInvoiceBusinessInput).isEqualTo(invoiceBusinessInput)
    }
}
