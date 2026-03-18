// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.client.okhttp.VatSenseOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UsageServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClientAsync.builder()
                .username("My Username")
                .password("My Password")
                .build()
        val usageServiceAsync = client.usage()

        val usageFuture = usageServiceAsync.retrieve()

        val usage = usageFuture.get()
        usage.validate()
    }
}
