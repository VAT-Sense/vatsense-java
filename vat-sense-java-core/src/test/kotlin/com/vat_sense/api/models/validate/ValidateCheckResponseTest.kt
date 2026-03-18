// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.validate

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ValidateCheckResponseTest {

    @Test
    fun create() {
        val validateCheckResponse =
            ValidateCheckResponse.builder()
                .code(200L)
                .data(
                    ValidateCheckResponse.Data.builder()
                        .company(
                            ValidateCheckResponse.Data.Company.ValidationCompany.builder()
                                .companyAddress(
                                    "142 CROMWELL ROAD\nLONDON\nGREATER LONDON\n\n\nSW7 4EF"
                                )
                                .companyName("WEIO LTD")
                                .countryCode("GB")
                                .vatNumber("288305674")
                                .build()
                        )
                        .consultationNumber("WAPIAAAAXT9mrLue")
                        .valid(true)
                        .build()
                )
                .success(true)
                .build()

        assertThat(validateCheckResponse.code()).contains(200L)
        assertThat(validateCheckResponse.data())
            .contains(
                ValidateCheckResponse.Data.builder()
                    .company(
                        ValidateCheckResponse.Data.Company.ValidationCompany.builder()
                            .companyAddress(
                                "142 CROMWELL ROAD\nLONDON\nGREATER LONDON\n\n\nSW7 4EF"
                            )
                            .companyName("WEIO LTD")
                            .countryCode("GB")
                            .vatNumber("288305674")
                            .build()
                    )
                    .consultationNumber("WAPIAAAAXT9mrLue")
                    .valid(true)
                    .build()
            )
        assertThat(validateCheckResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val validateCheckResponse =
            ValidateCheckResponse.builder()
                .code(200L)
                .data(
                    ValidateCheckResponse.Data.builder()
                        .company(
                            ValidateCheckResponse.Data.Company.ValidationCompany.builder()
                                .companyAddress(
                                    "142 CROMWELL ROAD\nLONDON\nGREATER LONDON\n\n\nSW7 4EF"
                                )
                                .companyName("WEIO LTD")
                                .countryCode("GB")
                                .vatNumber("288305674")
                                .build()
                        )
                        .consultationNumber("WAPIAAAAXT9mrLue")
                        .valid(true)
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedValidateCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(validateCheckResponse),
                jacksonTypeRef<ValidateCheckResponse>(),
            )

        assertThat(roundtrippedValidateCheckResponse).isEqualTo(validateCheckResponse)
    }
}
