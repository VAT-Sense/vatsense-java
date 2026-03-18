// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.invoice.CreateInvoice
import com.vatsense.models.invoice.InvoiceCreateParams
import com.vatsense.models.invoice.InvoiceDeleteParams
import com.vatsense.models.invoice.InvoiceDeleteResponse
import com.vatsense.models.invoice.InvoiceListParams
import com.vatsense.models.invoice.InvoiceListResponse
import com.vatsense.models.invoice.InvoiceResponse
import com.vatsense.models.invoice.InvoiceRetrieveParams
import com.vatsense.models.invoice.InvoiceUpdateParams
import com.vatsense.services.async.invoice.ItemServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** VAT-compliant invoice management */
interface InvoiceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvoiceServiceAsync

    /** VAT-compliant invoice management */
    fun item(): ItemServiceAsync

    /**
     * Create a new VAT-compliant invoice. VAT Sense will automatically calculate the totals based
     * on the items provided.
     *
     * Not available with sandbox API keys.
     */
    fun create(params: InvoiceCreateParams): CompletableFuture<InvoiceResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** @see create */
    fun create(
        createInvoice: CreateInvoice,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        create(InvoiceCreateParams.builder().createInvoice(createInvoice).build(), requestOptions)

    /** @see create */
    fun create(createInvoice: CreateInvoice): CompletableFuture<InvoiceResponse> =
        create(createInvoice, RequestOptions.none())

    /** Retrieve a specific invoice by its ID. */
    fun retrieve(invoiceId: String): CompletableFuture<InvoiceResponse> =
        retrieve(invoiceId, InvoiceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        invoiceId: String,
        params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        retrieve(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        invoiceId: String,
        params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
    ): CompletableFuture<InvoiceResponse> = retrieve(invoiceId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InvoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** @see retrieve */
    fun retrieve(params: InvoiceRetrieveParams): CompletableFuture<InvoiceResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        invoiceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvoiceResponse> =
        retrieve(invoiceId, InvoiceRetrieveParams.none(), requestOptions)

    /** Update an existing invoice. Only the fields provided will be updated. */
    fun update(invoiceId: String, params: InvoiceUpdateParams): CompletableFuture<InvoiceResponse> =
        update(invoiceId, params, RequestOptions.none())

    /** @see update */
    fun update(
        invoiceId: String,
        params: InvoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        update(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see update */
    fun update(params: InvoiceUpdateParams): CompletableFuture<InvoiceResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: InvoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** Retrieve a paginated list of all invoices. */
    fun list(): CompletableFuture<InvoiceListResponse> = list(InvoiceListParams.none())

    /** @see list */
    fun list(
        params: InvoiceListParams = InvoiceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceListResponse>

    /** @see list */
    fun list(
        params: InvoiceListParams = InvoiceListParams.none()
    ): CompletableFuture<InvoiceListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<InvoiceListResponse> =
        list(InvoiceListParams.none(), requestOptions)

    /** Permanently delete an invoice. */
    fun delete(invoiceId: String): CompletableFuture<InvoiceDeleteResponse> =
        delete(invoiceId, InvoiceDeleteParams.none())

    /** @see delete */
    fun delete(
        invoiceId: String,
        params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceDeleteResponse> =
        delete(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        invoiceId: String,
        params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
    ): CompletableFuture<InvoiceDeleteResponse> = delete(invoiceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InvoiceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceDeleteResponse>

    /** @see delete */
    fun delete(params: InvoiceDeleteParams): CompletableFuture<InvoiceDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        invoiceId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InvoiceDeleteResponse> =
        delete(invoiceId, InvoiceDeleteParams.none(), requestOptions)

    /**
     * A view of [InvoiceServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InvoiceServiceAsync.WithRawResponse

        /** VAT-compliant invoice management */
        fun item(): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /invoice`, but is otherwise the same as
         * [InvoiceServiceAsync.create].
         */
        fun create(
            params: InvoiceCreateParams
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InvoiceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>

        /** @see create */
        fun create(
            createInvoice: CreateInvoice,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            create(
                InvoiceCreateParams.builder().createInvoice(createInvoice).build(),
                requestOptions,
            )

        /** @see create */
        fun create(
            createInvoice: CreateInvoice
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            create(createInvoice, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /invoice/{invoice_id}`, but is otherwise the same as
         * [InvoiceServiceAsync.retrieve].
         */
        fun retrieve(invoiceId: String): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            retrieve(invoiceId, InvoiceRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            invoiceId: String,
            params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            retrieve(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            invoiceId: String,
            params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            retrieve(invoiceId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: InvoiceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>

        /** @see retrieve */
        fun retrieve(
            params: InvoiceRetrieveParams
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            invoiceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            retrieve(invoiceId, InvoiceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /invoice/{invoice_id}`, but is otherwise the same
         * as [InvoiceServiceAsync.update].
         */
        fun update(
            invoiceId: String,
            params: InvoiceUpdateParams,
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(invoiceId, params, RequestOptions.none())

        /** @see update */
        fun update(
            invoiceId: String,
            params: InvoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see update */
        fun update(
            params: InvoiceUpdateParams
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: InvoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>

        /**
         * Returns a raw HTTP response for `get /invoice`, but is otherwise the same as
         * [InvoiceServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<InvoiceListResponse>> =
            list(InvoiceListParams.none())

        /** @see list */
        fun list(
            params: InvoiceListParams = InvoiceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceListResponse>>

        /** @see list */
        fun list(
            params: InvoiceListParams = InvoiceListParams.none()
        ): CompletableFuture<HttpResponseFor<InvoiceListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<InvoiceListResponse>> =
            list(InvoiceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /invoice/{invoice_id}`, but is otherwise the same
         * as [InvoiceServiceAsync.delete].
         */
        fun delete(invoiceId: String): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>> =
            delete(invoiceId, InvoiceDeleteParams.none())

        /** @see delete */
        fun delete(
            invoiceId: String,
            params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>> =
            delete(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see delete */
        fun delete(
            invoiceId: String,
            params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>> =
            delete(invoiceId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: InvoiceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>>

        /** @see delete */
        fun delete(
            params: InvoiceDeleteParams
        ): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            invoiceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InvoiceDeleteResponse>> =
            delete(invoiceId, InvoiceDeleteParams.none(), requestOptions)
    }
}
