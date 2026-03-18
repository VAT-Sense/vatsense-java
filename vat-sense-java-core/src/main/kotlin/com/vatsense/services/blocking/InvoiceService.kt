// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import com.vatsense.services.blocking.invoice.ItemService
import java.util.function.Consumer

/** VAT-compliant invoice management */
interface InvoiceService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvoiceService

    /** VAT-compliant invoice management */
    fun item(): ItemService

    /**
     * Create a new VAT-compliant invoice. VAT Sense will automatically calculate the totals based
     * on the items provided.
     *
     * Not available with sandbox API keys.
     */
    fun create(params: InvoiceCreateParams): InvoiceResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InvoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** @see create */
    fun create(
        createInvoice: CreateInvoice,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse =
        create(InvoiceCreateParams.builder().createInvoice(createInvoice).build(), requestOptions)

    /** @see create */
    fun create(createInvoice: CreateInvoice): InvoiceResponse =
        create(createInvoice, RequestOptions.none())

    /** Retrieve a specific invoice by its ID. */
    fun retrieve(invoiceId: String): InvoiceResponse =
        retrieve(invoiceId, InvoiceRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        invoiceId: String,
        params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse = retrieve(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        invoiceId: String,
        params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
    ): InvoiceResponse = retrieve(invoiceId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InvoiceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** @see retrieve */
    fun retrieve(params: InvoiceRetrieveParams): InvoiceResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(invoiceId: String, requestOptions: RequestOptions): InvoiceResponse =
        retrieve(invoiceId, InvoiceRetrieveParams.none(), requestOptions)

    /** Update an existing invoice. Only the fields provided will be updated. */
    fun update(invoiceId: String, params: InvoiceUpdateParams): InvoiceResponse =
        update(invoiceId, params, RequestOptions.none())

    /** @see update */
    fun update(
        invoiceId: String,
        params: InvoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse = update(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see update */
    fun update(params: InvoiceUpdateParams): InvoiceResponse = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: InvoiceUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** Retrieve a paginated list of all invoices. */
    fun list(): InvoiceListResponse = list(InvoiceListParams.none())

    /** @see list */
    fun list(
        params: InvoiceListParams = InvoiceListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceListResponse

    /** @see list */
    fun list(params: InvoiceListParams = InvoiceListParams.none()): InvoiceListResponse =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): InvoiceListResponse =
        list(InvoiceListParams.none(), requestOptions)

    /** Permanently delete an invoice. */
    fun delete(invoiceId: String): InvoiceDeleteResponse =
        delete(invoiceId, InvoiceDeleteParams.none())

    /** @see delete */
    fun delete(
        invoiceId: String,
        params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceDeleteResponse =
        delete(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        invoiceId: String,
        params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
    ): InvoiceDeleteResponse = delete(invoiceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InvoiceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceDeleteResponse

    /** @see delete */
    fun delete(params: InvoiceDeleteParams): InvoiceDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(invoiceId: String, requestOptions: RequestOptions): InvoiceDeleteResponse =
        delete(invoiceId, InvoiceDeleteParams.none(), requestOptions)

    /** A view of [InvoiceService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): InvoiceService.WithRawResponse

        /** VAT-compliant invoice management */
        fun item(): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /invoice`, but is otherwise the same as
         * [InvoiceService.create].
         */
        @MustBeClosed
        fun create(params: InvoiceCreateParams): HttpResponseFor<InvoiceResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InvoiceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            createInvoice: CreateInvoice,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            create(
                InvoiceCreateParams.builder().createInvoice(createInvoice).build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(createInvoice: CreateInvoice): HttpResponseFor<InvoiceResponse> =
            create(createInvoice, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `get /invoice/{invoice_id}`, but is otherwise the same as
         * [InvoiceService.retrieve].
         */
        @MustBeClosed
        fun retrieve(invoiceId: String): HttpResponseFor<InvoiceResponse> =
            retrieve(invoiceId, InvoiceRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            invoiceId: String,
            params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            retrieve(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            invoiceId: String,
            params: InvoiceRetrieveParams = InvoiceRetrieveParams.none(),
        ): HttpResponseFor<InvoiceResponse> = retrieve(invoiceId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InvoiceRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: InvoiceRetrieveParams): HttpResponseFor<InvoiceResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            invoiceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceResponse> =
            retrieve(invoiceId, InvoiceRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `patch /invoice/{invoice_id}`, but is otherwise the same
         * as [InvoiceService.update].
         */
        @MustBeClosed
        fun update(
            invoiceId: String,
            params: InvoiceUpdateParams,
        ): HttpResponseFor<InvoiceResponse> = update(invoiceId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            invoiceId: String,
            params: InvoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            update(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: InvoiceUpdateParams): HttpResponseFor<InvoiceResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: InvoiceUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>

        /**
         * Returns a raw HTTP response for `get /invoice`, but is otherwise the same as
         * [InvoiceService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<InvoiceListResponse> = list(InvoiceListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InvoiceListParams = InvoiceListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: InvoiceListParams = InvoiceListParams.none()
        ): HttpResponseFor<InvoiceListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<InvoiceListResponse> =
            list(InvoiceListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /invoice/{invoice_id}`, but is otherwise the same
         * as [InvoiceService.delete].
         */
        @MustBeClosed
        fun delete(invoiceId: String): HttpResponseFor<InvoiceDeleteResponse> =
            delete(invoiceId, InvoiceDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            invoiceId: String,
            params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceDeleteResponse> =
            delete(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            invoiceId: String,
            params: InvoiceDeleteParams = InvoiceDeleteParams.none(),
        ): HttpResponseFor<InvoiceDeleteResponse> = delete(invoiceId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: InvoiceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: InvoiceDeleteParams): HttpResponseFor<InvoiceDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            invoiceId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InvoiceDeleteResponse> =
            delete(invoiceId, InvoiceDeleteParams.none(), requestOptions)
    }
}
