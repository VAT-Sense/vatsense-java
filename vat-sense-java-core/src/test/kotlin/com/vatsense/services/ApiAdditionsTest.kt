package com.vatsense.services

import com.github.tomakehurst.wiremock.client.WireMock.absent
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.vatsense.client.VatSenseClient
import com.vatsense.client.okhttp.VatSenseOkHttpClient
import com.vatsense.models.invoice.CreateInvoice
import com.vatsense.models.invoice.InvoiceBusinessInput
import com.vatsense.models.invoice.InvoiceCreateParams
import com.vatsense.models.invoice.item.InvoiceItemInput
import com.vatsense.models.rates.RateListParams
import com.vatsense.models.validate.ValidateCheckParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

/** The API additions of November 2026, sent to WireMock. */
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ApiAdditionsTest {

    private lateinit var client: VatSenseClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            VatSenseOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .username("user")
                .password("key")
                .build()
    }

    private fun createInvoice(originalInvoiceId: String? = null): CreateInvoice =
        CreateInvoice.builder()
            .business(
                InvoiceBusinessInput.builder()
                    .name("VAT Sense")
                    .address("London")
                    .vatNumber("GB12345678")
                    .build()
            )
            .currencyCode("GBP")
            .date("2026-11-05")
            .taxPoint("2026-11-05")
            .addItem(
                InvoiceItemInput.builder()
                    .item("Plan")
                    .priceEach(10.0)
                    .quantity(1.0)
                    .vatRate(20.0)
                    .build()
            )
            .apply { originalInvoiceId?.let { originalInvoiceId(it) } }
            .build()

    @Test
    fun invoiceCreateSendsIdempotencyKeyHeader() {
        stubFor(post(anyUrl()).willReturn(okJson("""{"success":true,"code":200,"data":{}}""")))

        client
            .invoice()
            .create(
                InvoiceCreateParams.builder()
                    .createInvoice(createInvoice("in5aeae457cda2a"))
                    .idempotencyKey("order-203")
                    .build()
            )

        verify(
            postRequestedFor(urlPathEqualTo("/invoice"))
                .withHeader("Idempotency-Key", equalTo("order-203"))
                .withRequestBody(
                    matchingJsonPath("$.original_invoice_id", equalTo("in5aeae457cda2a"))
                )
        )
    }

    @Test
    fun invoiceCreateWithoutKeySendsNoHeader() {
        stubFor(post(anyUrl()).willReturn(okJson("""{"success":true,"code":200,"data":{}}""")))

        client
            .invoice()
            .create(InvoiceCreateParams.builder().createInvoice(createInvoice()).build())

        verify(postRequestedFor(urlPathEqualTo("/invoice")).withHeader("Idempotency-Key", absent()))
    }

    @Test
    fun validateSendsMatchParametersAndReadsMatch() {
        stubFor(
            get(anyUrl())
                .willReturn(
                    okJson(
                        """{"success":true,"code":200,"data":{"valid":true,"match":{"result":"likely","score":90,"fields":{"company_name":{"result":"match","score":100,"vies":null}}}}}"""
                    )
                )
        )

        val result =
            client
                .validate()
                .check(
                    ValidateCheckParams.builder()
                        .vatNumber("GB288305674")
                        .matchCompanyName("Weio Ltd")
                        .matchPostcode("SW3 1GL")
                        .build()
                )

        verify(
            getRequestedFor(urlPathEqualTo("/validate"))
                .withQueryParam("match_company_name", equalTo("Weio Ltd"))
                .withQueryParam("match_postcode", equalTo("SW3 1GL"))
        )
        val match = result.data().get().match().get()
        assertThat(match.result()).contains("likely")
        assertThat(match.score()).contains(90L)
        assertThat(match.fields().get()["company_name"]!!.score()).contains(100L)
        assertThat(match.fields().get()["company_name"]!!.vies()).isEmpty
        assertThat(result.isValid()).isTrue()
    }

    @Test
    fun ratesListSendsProvinces() {
        stubFor(get(anyUrl()).willReturn(okJson("""{"success":true,"code":200,"data":[]}""")))

        client.rates().list(RateListParams.builder().provinces(false).build())

        verify(
            getRequestedFor(urlPathEqualTo("/rates")).withQueryParam("provinces", equalTo("false"))
        )
    }
}
