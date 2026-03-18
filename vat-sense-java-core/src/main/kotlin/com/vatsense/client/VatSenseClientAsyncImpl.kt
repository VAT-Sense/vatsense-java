// File generated from our OpenAPI spec by Stainless.

package com.vatsense.client

import com.vatsense.core.ClientOptions
import com.vatsense.core.getPackageVersion
import com.vatsense.services.async.CountryServiceAsync
import com.vatsense.services.async.CountryServiceAsyncImpl
import com.vatsense.services.async.CurrencyServiceAsync
import com.vatsense.services.async.CurrencyServiceAsyncImpl
import com.vatsense.services.async.InvoiceServiceAsync
import com.vatsense.services.async.InvoiceServiceAsyncImpl
import com.vatsense.services.async.RateServiceAsync
import com.vatsense.services.async.RateServiceAsyncImpl
import com.vatsense.services.async.SandboxServiceAsync
import com.vatsense.services.async.SandboxServiceAsyncImpl
import com.vatsense.services.async.UsageServiceAsync
import com.vatsense.services.async.UsageServiceAsyncImpl
import com.vatsense.services.async.ValidateServiceAsync
import com.vatsense.services.async.ValidateServiceAsyncImpl
import java.util.function.Consumer

class VatSenseClientAsyncImpl(private val clientOptions: ClientOptions) : VatSenseClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: VatSenseClient by lazy { VatSenseClientImpl(clientOptions) }

    private val withRawResponse: VatSenseClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val rates: RateServiceAsync by lazy { RateServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val countries: CountryServiceAsync by lazy {
        CountryServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val validate: ValidateServiceAsync by lazy {
        ValidateServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val currency: CurrencyServiceAsync by lazy {
        CurrencyServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val invoice: InvoiceServiceAsync by lazy {
        InvoiceServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val usage: UsageServiceAsync by lazy {
        UsageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val sandbox: SandboxServiceAsync by lazy {
        SandboxServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): VatSenseClient = sync

    override fun withRawResponse(): VatSenseClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VatSenseClientAsync =
        VatSenseClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** VAT/GST rate lookups for countries worldwide */
    override fun rates(): RateServiceAsync = rates

    /** Country and province information */
    override fun countries(): CountryServiceAsync = countries

    /** VAT and EORI number validation */
    override fun validate(): ValidateServiceAsync = validate

    /** Currency exchange rates and conversion */
    override fun currency(): CurrencyServiceAsync = currency

    /** VAT-compliant invoice management */
    override fun invoice(): InvoiceServiceAsync = invoice

    /** API usage statistics */
    override fun usage(): UsageServiceAsync = usage

    /** Temporary sandbox API keys for testing */
    override fun sandbox(): SandboxServiceAsync = sandbox

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VatSenseClientAsync.WithRawResponse {

        private val rates: RateServiceAsync.WithRawResponse by lazy {
            RateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val countries: CountryServiceAsync.WithRawResponse by lazy {
            CountryServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val validate: ValidateServiceAsync.WithRawResponse by lazy {
            ValidateServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val currency: CurrencyServiceAsync.WithRawResponse by lazy {
            CurrencyServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val invoice: InvoiceServiceAsync.WithRawResponse by lazy {
            InvoiceServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val usage: UsageServiceAsync.WithRawResponse by lazy {
            UsageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val sandbox: SandboxServiceAsync.WithRawResponse by lazy {
            SandboxServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VatSenseClientAsync.WithRawResponse =
            VatSenseClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** VAT/GST rate lookups for countries worldwide */
        override fun rates(): RateServiceAsync.WithRawResponse = rates

        /** Country and province information */
        override fun countries(): CountryServiceAsync.WithRawResponse = countries

        /** VAT and EORI number validation */
        override fun validate(): ValidateServiceAsync.WithRawResponse = validate

        /** Currency exchange rates and conversion */
        override fun currency(): CurrencyServiceAsync.WithRawResponse = currency

        /** VAT-compliant invoice management */
        override fun invoice(): InvoiceServiceAsync.WithRawResponse = invoice

        /** API usage statistics */
        override fun usage(): UsageServiceAsync.WithRawResponse = usage

        /** Temporary sandbox API keys for testing */
        override fun sandbox(): SandboxServiceAsync.WithRawResponse = sandbox
    }
}
