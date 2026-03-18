// File generated from our OpenAPI spec by Stainless.

package com.vatsense.client

import com.vatsense.core.ClientOptions
import com.vatsense.services.blocking.CountryService
import com.vatsense.services.blocking.CurrencyService
import com.vatsense.services.blocking.InvoiceService
import com.vatsense.services.blocking.RateService
import com.vatsense.services.blocking.SandboxService
import com.vatsense.services.blocking.UsageService
import com.vatsense.services.blocking.ValidateService
import java.util.function.Consumer

/**
 * A client for interacting with the Vat Sense REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface VatSenseClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): VatSenseClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VatSenseClient

    /** VAT/GST rate lookups for countries worldwide */
    fun rates(): RateService

    /** Country and province information */
    fun countries(): CountryService

    /** VAT and EORI number validation */
    fun validate(): ValidateService

    /** Currency exchange rates and conversion */
    fun currency(): CurrencyService

    /** VAT-compliant invoice management */
    fun invoice(): InvoiceService

    /** API usage statistics */
    fun usage(): UsageService

    /** Temporary sandbox API keys for testing */
    fun sandbox(): SandboxService

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [VatSenseClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VatSenseClient.WithRawResponse

        /** VAT/GST rate lookups for countries worldwide */
        fun rates(): RateService.WithRawResponse

        /** Country and province information */
        fun countries(): CountryService.WithRawResponse

        /** VAT and EORI number validation */
        fun validate(): ValidateService.WithRawResponse

        /** Currency exchange rates and conversion */
        fun currency(): CurrencyService.WithRawResponse

        /** VAT-compliant invoice management */
        fun invoice(): InvoiceService.WithRawResponse

        /** API usage statistics */
        fun usage(): UsageService.WithRawResponse

        /** Temporary sandbox API keys for testing */
        fun sandbox(): SandboxService.WithRawResponse
    }
}
