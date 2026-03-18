// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.async

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SandboxServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun generateKey() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val sandboxServiceAsync = client.sandbox()

        val responseFuture = sandboxServiceAsync.generateKey()

        val response = responseFuture.get()
        response.validate()
    }
}
