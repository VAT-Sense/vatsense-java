// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import com.vatsense.models.validate.ValidateCheckParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ValidateServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun check() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val validateServiceAsync = client.validate()

        val responseFuture =
            validateServiceAsync.check(
                ValidateCheckParams.builder()
                    .eoriNumber("GB123456789123")
                    .requesterVatNumber("GB288305674")
                    .vatNumber("GB288305674")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
