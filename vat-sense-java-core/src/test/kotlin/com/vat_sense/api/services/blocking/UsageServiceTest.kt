// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking

import com.vat_sense.api.client.okhttp.VatSenseOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class UsageServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val usageService = client.usage()

        val usage = usageService.retrieve()

        usage.validate()
    }
}
