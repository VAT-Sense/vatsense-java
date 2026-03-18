// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TaxRateTest {

    @Test
    fun create() {
        val taxRate =
            TaxRate.builder()
                .class_("standard")
                .description("")
                .object_(TaxRate.Object.TAX_RATE)
                .rate(20.0)
                .types(false)
                .build()

        assertThat(taxRate.class_()).contains("standard")
        assertThat(taxRate.description()).contains("")
        assertThat(taxRate.object_()).contains(TaxRate.Object.TAX_RATE)
        assertThat(taxRate.rate()).contains(20.0)
        assertThat(taxRate.types()).contains(TaxRate.Types.ofBool(false))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val taxRate =
            TaxRate.builder()
                .class_("standard")
                .description("")
                .object_(TaxRate.Object.TAX_RATE)
                .rate(20.0)
                .types(false)
                .build()

        val roundtrippedTaxRate =
            jsonMapper.readValue(jsonMapper.writeValueAsString(taxRate), jacksonTypeRef<TaxRate>())

        assertThat(roundtrippedTaxRate).isEqualTo(taxRate)
    }
}
