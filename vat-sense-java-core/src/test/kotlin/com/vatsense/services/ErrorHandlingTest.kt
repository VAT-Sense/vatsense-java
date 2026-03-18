// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.vatsense.client.VatSenseClient
import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.core.JsonValue
import com.vatsense.core.http.Headers
import com.vatsense.core.jsonMapper
import com.vatsense.errors.BadRequestException
import com.vatsense.errors.InternalServerException
import com.vatsense.errors.NotFoundException
import com.vatsense.errors.PermissionDeniedException
import com.vatsense.errors.RateLimitException
import com.vatsense.errors.UnauthorizedException
import com.vatsense.errors.UnexpectedStatusCodeException
import com.vatsense.errors.UnprocessableEntityException
import com.vatsense.errors.VatSenseException
import com.vatsense.models.rates.RateListParams
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: VatSenseClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            VatSenseOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .username("My Username")
                .password("My Password")
                .build()
    }

    @Test
    fun ratesList400() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList400WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList401() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList401WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList403() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList403WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList404() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList404WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList422() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList422WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList429() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList429WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList500() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList500WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList999() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesList999WithRawResponse() {
        val rateService = client.rates().withRawResponse()
        stubFor(
            get(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun ratesListInvalidJsonBody() {
        val rateService = client.rates()
        stubFor(
            get(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<VatSenseException> {
                rateService.list(
                    RateListParams.builder()
                        .countryCode("GB")
                        .eu(true)
                        .ipAddress("86.27.166.97")
                        .period(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
