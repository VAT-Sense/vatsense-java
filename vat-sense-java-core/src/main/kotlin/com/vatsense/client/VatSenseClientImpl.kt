// File generated from our OpenAPI spec by Stainless.

package com.vatsense.client

import com.vatsense.core.ClientOptions
import com.vatsense.core.getPackageVersion
import com.vatsense.services.blocking.CountryService
import com.vatsense.services.blocking.CountryServiceImpl
import com.vatsense.services.blocking.CurrencyService
import com.vatsense.services.blocking.CurrencyServiceImpl
import com.vatsense.services.blocking.InvoiceService
import com.vatsense.services.blocking.InvoiceServiceImpl
import com.vatsense.services.blocking.RateService
import com.vatsense.services.blocking.RateServiceImpl
import com.vatsense.services.blocking.SandboxService
import com.vatsense.services.blocking.SandboxServiceImpl
import com.vatsense.services.blocking.UsageService
import com.vatsense.services.blocking.UsageServiceImpl
import com.vatsense.services.blocking.ValidateService
import com.vatsense.services.blocking.ValidateServiceImpl
import java.util.function.Consumer

class VatSenseClientImpl(private val clientOptions: ClientOptions) : VatSenseClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: VatSenseClientAsync by lazy { VatSenseClientAsyncImpl(clientOptions) }

    private val withRawResponse: VatSenseClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val rates: RateService by lazy { RateServiceImpl(clientOptionsWithUserAgent) }

    private val countries: CountryService by lazy { CountryServiceImpl(clientOptionsWithUserAgent) }

    private val validate: ValidateService by lazy {
        ValidateServiceImpl(clientOptionsWithUserAgent)
    }

    private val currency: CurrencyService by lazy {
        CurrencyServiceImpl(clientOptionsWithUserAgent)
    }

    private val invoice: InvoiceService by lazy { InvoiceServiceImpl(clientOptionsWithUserAgent) }

    private val usage: UsageService by lazy { UsageServiceImpl(clientOptionsWithUserAgent) }

    private val sandbox: SandboxService by lazy { SandboxServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): VatSenseClientAsync = async

    override fun withRawResponse(): VatSenseClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VatSenseClient =
        VatSenseClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** VAT/GST rate lookups for countries worldwide */
    override fun rates(): RateService = rates

    /** Country and province information */
    override fun countries(): CountryService = countries

    /** VAT and EORI number validation */
    override fun validate(): ValidateService = validate

    /** Currency exchange rates and conversion */
    override fun currency(): CurrencyService = currency

    /** VAT-compliant invoice management */
    override fun invoice(): InvoiceService = invoice

    /** API usage statistics */
    override fun usage(): UsageService = usage

    /** Temporary sandbox API keys for testing */
    override fun sandbox(): SandboxService = sandbox

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VatSenseClient.WithRawResponse {

        private val rates: RateService.WithRawResponse by lazy {
            RateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val countries: CountryService.WithRawResponse by lazy {
            CountryServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val validate: ValidateService.WithRawResponse by lazy {
            ValidateServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val currency: CurrencyService.WithRawResponse by lazy {
            CurrencyServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val invoice: InvoiceService.WithRawResponse by lazy {
            InvoiceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val usage: UsageService.WithRawResponse by lazy {
            UsageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val sandbox: SandboxService.WithRawResponse by lazy {
            SandboxServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VatSenseClient.WithRawResponse =
            VatSenseClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** VAT/GST rate lookups for countries worldwide */
        override fun rates(): RateService.WithRawResponse = rates

        /** Country and province information */
        override fun countries(): CountryService.WithRawResponse = countries

        /** VAT and EORI number validation */
        override fun validate(): ValidateService.WithRawResponse = validate

        /** Currency exchange rates and conversion */
        override fun currency(): CurrencyService.WithRawResponse = currency

        /** VAT-compliant invoice management */
        override fun invoice(): InvoiceService.WithRawResponse = invoice

        /** API usage statistics */
        override fun usage(): UsageService.WithRawResponse = usage

        /** Temporary sandbox API keys for testing */
        override fun sandbox(): SandboxService.WithRawResponse = sandbox
    }
}
