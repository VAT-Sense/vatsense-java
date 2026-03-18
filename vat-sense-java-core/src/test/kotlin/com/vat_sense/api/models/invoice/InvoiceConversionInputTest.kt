// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.invoice

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InvoiceConversionInputTest {

    @Test
    fun create() {
        val invoiceConversionInput =
            InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()

        assertThat(invoiceConversionInput.currencyCode()).isEqualTo("GBP")
        assertThat(invoiceConversionInput.rate()).isEqualTo(1.523)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invoiceConversionInput =
            InvoiceConversionInput.builder().currencyCode("GBP").rate(1.523).build()

        val roundtrippedInvoiceConversionInput =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(invoiceConversionInput),
                jacksonTypeRef<InvoiceConversionInput>(),
            )

        assertThat(roundtrippedInvoiceConversionInput).isEqualTo(invoiceConversionInput)
    }
}
