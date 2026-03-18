// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.models.rates

import com.vat_sense.api.core.http.QueryParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RateFindParamsTest {

    @Test
    fun create() {
        RateFindParams.builder()
            .countryCode("GB")
            .eu(true)
            .ipAddress("86.27.166.97")
            .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .provinceCode("ON")
            .type("ebooks")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            RateFindParams.builder()
                .countryCode("GB")
                .eu(true)
                .ipAddress("86.27.166.97")
                .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .provinceCode("ON")
                .type("ebooks")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("country_code", "GB")
                    .put("eu", "true")
                    .put("ip_address", "86.27.166.97")
                    .put("period", "2019-12-27T18:11:19.117Z")
                    .put("province_code", "ON")
                    .put("type", "ebooks")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = RateFindParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
