// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.models.validate.ValidateCheckParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ValidateServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun check() {
        val client =
            VatSenseOkHttpClient.builder().username("My Username").password("My Password").build()
        val validateService = client.validate()

        val response =
            validateService.check(
                ValidateCheckParams.builder()
                    .eoriNumber("GB123456789123")
                    .requesterVatNumber("GB288305674")
                    .vatNumber("GB288305674")
                    .build()
            )

        response.validate()
    }
}
