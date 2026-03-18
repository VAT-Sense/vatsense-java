// File generated from our OpenAPI spec by Stainless.

package com.vatsense.models.rates

import com.vatsense.core.http.QueryParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateListParamsTest {

    @Test
    fun create() {
        RateListParams.builder()
            .countryCode("GB")
            .eu(true)
            .ipAddress("86.27.166.97")
            .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RateListParams.builder()
                .countryCode("GB")
                .eu(true)
                .ipAddress("86.27.166.97")
                .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("country_code", "GB")
                    .put("eu", "true")
                    .put("ip_address", "86.27.166.97")
                    .put("period", "2019-12-27T18:11:19.117Z")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RateListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
