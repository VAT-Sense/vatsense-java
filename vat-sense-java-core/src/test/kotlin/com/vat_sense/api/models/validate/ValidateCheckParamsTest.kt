// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.validate

import com.vat_sense.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidateCheckParamsTest {

    @Test
    fun create() {
        ValidateCheckParams.builder()
            .eoriNumber("GB123456789123")
            .requesterVatNumber("GB288305674")
            .vatNumber("GB288305674")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            ValidateCheckParams.builder()
                .eoriNumber("GB123456789123")
                .requesterVatNumber("GB288305674")
                .vatNumber("GB288305674")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("eori_number", "GB123456789123")
                    .put("requester_vat_number", "GB288305674")
                    .put("vat_number", "GB288305674")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = ValidateCheckParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
