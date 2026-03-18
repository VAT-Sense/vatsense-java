// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.currency

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VatPriceTest {

    @Test
    fun create() {
        val vatPrice =
            VatPrice.builder()
                .object_(VatPrice.Object.VAT_PRICE)
                .price(20.0)
                .priceExclVat(20.0)
                .priceInclVat(21.1)
                .taxType(VatPrice.TaxType.EXCL)
                .vat(1.1)
                .vatRate(5.5)
                .build()

        assertThat(vatPrice.object_()).contains(VatPrice.Object.VAT_PRICE)
        assertThat(vatPrice.price()).contains(20.0)
        assertThat(vatPrice.priceExclVat()).contains(20.0)
        assertThat(vatPrice.priceInclVat()).contains(21.1)
        assertThat(vatPrice.taxType()).contains(VatPrice.TaxType.EXCL)
        assertThat(vatPrice.vat()).contains(1.1)
        assertThat(vatPrice.vatRate()).contains(5.5)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val vatPrice =
            VatPrice.builder()
                .object_(VatPrice.Object.VAT_PRICE)
                .price(20.0)
                .priceExclVat(20.0)
                .priceInclVat(21.1)
                .taxType(VatPrice.TaxType.EXCL)
                .vat(1.1)
                .vatRate(5.5)
                .build()

        val roundtrippedVatPrice =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vatPrice),
                jacksonTypeRef<VatPrice>(),
            )

        assertThat(roundtrippedVatPrice).isEqualTo(vatPrice)
    }
}
