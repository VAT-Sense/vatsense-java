// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.sandbox

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vatsense.core.jsonMapper
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SandboxGenerateKeyResponseTest {

    @Test
    fun create() {
        val sandboxGenerateKeyResponse =
            SandboxGenerateKeyResponse.builder()
                .code(201L)
                .data(
                    SandboxGenerateKeyResponse.Data.builder()
                        .allowedEndpoints(
                            listOf(
                                "GET /1.0",
                                "GET /1.0/rates",
                                "GET /1.0/rates/rate",
                                "GET /1.0/rates/tax_rate",
                                "GET /1.0/rates/types",
                                "GET /1.0/rates/price",
                                "GET /1.0/countries",
                                "GET /1.0/countries/country",
                                "GET /1.0/currency",
                                "GET /1.0/currency/convert",
                                "GET /1.0/validate",
                                "GET /1.0/usage",
                            )
                        )
                        .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .key("tmp_abc123def456")
                        .requestsRemaining(50L)
                        .signupUrl("https://vatsense.com")
                        .build()
                )
                .success(true)
                .build()

        assertThat(sandboxGenerateKeyResponse.code()).contains(201L)
        assertThat(sandboxGenerateKeyResponse.data())
            .contains(
                SandboxGenerateKeyResponse.Data.builder()
                    .allowedEndpoints(
                        listOf(
                            "GET /1.0",
                            "GET /1.0/rates",
                            "GET /1.0/rates/rate",
                            "GET /1.0/rates/tax_rate",
                            "GET /1.0/rates/types",
                            "GET /1.0/rates/price",
                            "GET /1.0/countries",
                            "GET /1.0/countries/country",
                            "GET /1.0/currency",
                            "GET /1.0/currency/convert",
                            "GET /1.0/validate",
                            "GET /1.0/usage",
                        )
                    )
                    .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .key("tmp_abc123def456")
                    .requestsRemaining(50L)
                    .signupUrl("https://vatsense.com")
                    .build()
            )
        assertThat(sandboxGenerateKeyResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val sandboxGenerateKeyResponse =
            SandboxGenerateKeyResponse.builder()
                .code(201L)
                .data(
                    SandboxGenerateKeyResponse.Data.builder()
                        .allowedEndpoints(
                            listOf(
                                "GET /1.0",
                                "GET /1.0/rates",
                                "GET /1.0/rates/rate",
                                "GET /1.0/rates/tax_rate",
                                "GET /1.0/rates/types",
                                "GET /1.0/rates/price",
                                "GET /1.0/countries",
                                "GET /1.0/countries/country",
                                "GET /1.0/currency",
                                "GET /1.0/currency/convert",
                                "GET /1.0/validate",
                                "GET /1.0/usage",
                            )
                        )
                        .expiresAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .key("tmp_abc123def456")
                        .requestsRemaining(50L)
                        .signupUrl("https://vatsense.com")
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedSandboxGenerateKeyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(sandboxGenerateKeyResponse),
                jacksonTypeRef<SandboxGenerateKeyResponse>(),
            )

        assertThat(roundtrippedSandboxGenerateKeyResponse).isEqualTo(sandboxGenerateKeyResponse)
    }
}
