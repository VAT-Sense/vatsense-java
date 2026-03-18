// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.services.blocking.invoice

import com.google.errorprone.annotations.MustBeClosed
import com.vat_sense.api.core.ClientOptions
import com.vat_sense.api.core.RequestOptions
import com.vat_sense.api.core.http.HttpResponseFor
import com.vat_sense.api.models.invoice.InvoiceResponse
import com.vat_sense.api.models.invoice.item.ItemAddParams
import com.vat_sense.api.models.invoice.item.ItemDeleteParams
import com.vat_sense.api.models.invoice.item.ItemRetrieveParams
import com.vat_sense.api.models.invoice.item.ItemRetrieveResponse
import com.vat_sense.api.models.invoice.item.ItemUpdateParams
import java.util.function.Consumer

/** VAT-compliant invoice management */
interface ItemService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService

    /** Retrieve a specific line item from an invoice. */
    fun retrieve(itemId: String, params: ItemRetrieveParams): ItemRetrieveResponse =
        retrieve(itemId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        itemId: String,
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemRetrieveResponse = retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ItemRetrieveParams): ItemRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ItemRetrieveResponse

    /** Update a specific line item on an invoice. */
    fun update(itemId: String, params: ItemUpdateParams): InvoiceResponse =
        update(itemId, params, RequestOptions.none())

    /** @see update */
    fun update(
        itemId: String,
        params: ItemUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse = update(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see update */
    fun update(params: ItemUpdateParams): InvoiceResponse = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ItemUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** Remove a specific line item from an invoice. */
    fun delete(itemId: String, params: ItemDeleteParams): InvoiceResponse =
        delete(itemId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        itemId: String,
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse = delete(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ItemDeleteParams): InvoiceResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** Add one or more line items to an existing invoice. */
    fun add(invoiceId: String, params: ItemAddParams): InvoiceResponse =
        add(invoiceId, params, RequestOptions.none())

    /** @see add */
    fun add(
        invoiceId: String,
        params: ItemAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse = add(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see add */
    fun add(params: ItemAddParams): InvoiceResponse = add(params, RequestOptions.none())

    /** @see add */
    fun add(
        params: ItemAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InvoiceResponse

    /** A view of [ItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
        ): HttpResponseFor<ItemRetrieveResponse> = retrieve(itemId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemRetrieveResponse> =
            retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ItemRetrieveParams): HttpResponseFor<ItemRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ItemRetrieveResponse>

        /**
         * Returns a raw HTTP response for `patch /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemService.update].
         */
        @MustBeClosed
        fun update(itemId: String, params: ItemUpdateParams): HttpResponseFor<InvoiceResponse> =
            update(itemId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            itemId: String,
            params: ItemUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            update(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: ItemUpdateParams): HttpResponseFor<InvoiceResponse> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: ItemUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>

        /**
         * Returns a raw HTTP response for `delete /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemService.delete].
         */
        @MustBeClosed
        fun delete(itemId: String, params: ItemDeleteParams): HttpResponseFor<InvoiceResponse> =
            delete(itemId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            delete(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: ItemDeleteParams): HttpResponseFor<InvoiceResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>

        /**
         * Returns a raw HTTP response for `post /invoice/{invoice_id}/item`, but is otherwise the
         * same as [ItemService.add].
         */
        @MustBeClosed
        fun add(invoiceId: String, params: ItemAddParams): HttpResponseFor<InvoiceResponse> =
            add(invoiceId, params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(
            invoiceId: String,
            params: ItemAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse> =
            add(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see add */
        @MustBeClosed
        fun add(params: ItemAddParams): HttpResponseFor<InvoiceResponse> =
            add(params, RequestOptions.none())

        /** @see add */
        @MustBeClosed
        fun add(
            params: ItemAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InvoiceResponse>
    }
}
