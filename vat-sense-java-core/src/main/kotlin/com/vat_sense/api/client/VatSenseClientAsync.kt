// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.client

import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.services.async.CountryServiceAsync
import com.vat_sense.api.services.async.CurrencyServiceAsync
import com.vat_sense.api.services.async.InvoiceServiceAsync
import com.vat_sense.api.services.async.RateServiceAsync
import com.vat_sense.api.services.async.SandboxServiceAsync
import com.vat_sense.api.services.async.UsageServiceAsync
import com.vat_sense.api.services.async.ValidateServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Vat Sense REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
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
interface VatSenseClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): VatSenseClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VatSenseClientAsync

    /** VAT/GST rate lookups for countries worldwide */
    fun rates(): RateServiceAsync

    /** Country and province information */
    fun countries(): CountryServiceAsync

    /** VAT and EORI number validation */
    fun validate(): ValidateServiceAsync

    /** Currency exchange rates and conversion */
    fun currency(): CurrencyServiceAsync

    /** VAT-compliant invoice management */
    fun invoice(): InvoiceServiceAsync

    /** API usage statistics */
    fun usage(): UsageServiceAsync

    /** Temporary sandbox API keys for testing */
    fun sandbox(): SandboxServiceAsync

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

    /**
     * A view of [VatSenseClientAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VatSenseClientAsync.WithRawResponse

        /** VAT/GST rate lookups for countries worldwide */
        fun rates(): RateServiceAsync.WithRawResponse

        /** Country and province information */
        fun countries(): CountryServiceAsync.WithRawResponse

        /** VAT and EORI number validation */
        fun validate(): ValidateServiceAsync.WithRawResponse

        /** Currency exchange rates and conversion */
        fun currency(): CurrencyServiceAsync.WithRawResponse

        /** VAT-compliant invoice management */
        fun invoice(): InvoiceServiceAsync.WithRawResponse

        /** API usage statistics */
        fun usage(): UsageServiceAsync.WithRawResponse

        /** Temporary sandbox API keys for testing */
        fun sandbox(): SandboxServiceAsync.WithRawResponse
    }
}
