// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.usage

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.vat_sense.api.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UsageRetrieveResponseTest {

    @Test
    fun create() {
        val usageRetrieveResponse =
            UsageRetrieveResponse.builder()
                .code(200L)
                .data(
                    UsageRetrieveResponse.Data.builder()
                        .requests(
                            UsageRetrieveResponse.Data.Requests.builder()
                                .remaining(77L)
                                .total(100L)
                                .used(23L)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        assertThat(usageRetrieveResponse.code()).contains(200L)
        assertThat(usageRetrieveResponse.data())
            .contains(
                UsageRetrieveResponse.Data.builder()
                    .requests(
                        UsageRetrieveResponse.Data.Requests.builder()
                            .remaining(77L)
                            .total(100L)
                            .used(23L)
                            .build()
                    )
                    .build()
            )
        assertThat(usageRetrieveResponse.success()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val usageRetrieveResponse =
            UsageRetrieveResponse.builder()
                .code(200L)
                .data(
                    UsageRetrieveResponse.Data.builder()
                        .requests(
                            UsageRetrieveResponse.Data.Requests.builder()
                                .remaining(77L)
                                .total(100L)
                                .used(23L)
                                .build()
                        )
                        .build()
                )
                .success(true)
                .build()

        val roundtrippedUsageRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(usageRetrieveResponse),
                jacksonTypeRef<UsageRetrieveResponse>(),
            )

        assertThat(roundtrippedUsageRetrieveResponse).isEqualTo(usageRetrieveResponse)
    }
}
