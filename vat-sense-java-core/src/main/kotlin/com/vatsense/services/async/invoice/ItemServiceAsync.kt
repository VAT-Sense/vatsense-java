// File generated from our OpenAPI spec by Stainless.

package com.vatsense.services.async.invoice

import com.vatsense.core.ClientOptions
import com.vatsense.core.RequestOptions
import com.vatsense.core.http.HttpResponseFor
import com.vatsense.models.invoice.InvoiceResponse
import com.vatsense.models.invoice.item.ItemAddParams
import com.vatsense.models.invoice.item.ItemDeleteParams
import com.vatsense.models.invoice.item.ItemRetrieveParams
import com.vatsense.models.invoice.item.ItemRetrieveResponse
import com.vatsense.models.invoice.item.ItemUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** VAT-compliant invoice management */
interface ItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync

    /** Retrieve a specific line item from an invoice. */
    fun retrieve(
        itemId: String,
        params: ItemRetrieveParams,
    ): CompletableFuture<ItemRetrieveResponse> = retrieve(itemId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        itemId: String,
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemRetrieveResponse> =
        retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: ItemRetrieveParams): CompletableFuture<ItemRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ItemRetrieveResponse>

    /** Update a specific line item on an invoice. */
    fun update(itemId: String, params: ItemUpdateParams): CompletableFuture<InvoiceResponse> =
        update(itemId, params, RequestOptions.none())

    /** @see update */
    fun update(
        itemId: String,
        params: ItemUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        update(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see update */
    fun update(params: ItemUpdateParams): CompletableFuture<InvoiceResponse> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: ItemUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** Remove a specific line item from an invoice. */
    fun delete(itemId: String, params: ItemDeleteParams): CompletableFuture<InvoiceResponse> =
        delete(itemId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        itemId: String,
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        delete(params.toBuilder().itemId(itemId).build(), requestOptions)

    /** @see delete */
    fun delete(params: ItemDeleteParams): CompletableFuture<InvoiceResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ItemDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** Add one or more line items to an existing invoice. */
    fun add(invoiceId: String, params: ItemAddParams): CompletableFuture<InvoiceResponse> =
        add(invoiceId, params, RequestOptions.none())

    /** @see add */
    fun add(
        invoiceId: String,
        params: ItemAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse> =
        add(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

    /** @see add */
    fun add(params: ItemAddParams): CompletableFuture<InvoiceResponse> =
        add(params, RequestOptions.none())

    /** @see add */
    fun add(
        params: ItemAddParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InvoiceResponse>

    /** A view of [ItemServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemServiceAsync.retrieve].
         */
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
        ): CompletableFuture<HttpResponseFor<ItemRetrieveResponse>> =
            retrieve(itemId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            itemId: String,
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemRetrieveResponse>> =
            retrieve(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: ItemRetrieveParams
        ): CompletableFuture<HttpResponseFor<ItemRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ItemRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `patch /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemServiceAsync.update].
         */
        fun update(
            itemId: String,
            params: ItemUpdateParams,
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(itemId, params, RequestOptions.none())

        /** @see update */
        fun update(
            itemId: String,
            params: ItemUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see update */
        fun update(params: ItemUpdateParams): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: ItemUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>

        /**
         * Returns a raw HTTP response for `delete /invoice/{invoice_id}/item/{item_id}`, but is
         * otherwise the same as [ItemServiceAsync.delete].
         */
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            delete(itemId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            itemId: String,
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            delete(params.toBuilder().itemId(itemId).build(), requestOptions)

        /** @see delete */
        fun delete(params: ItemDeleteParams): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ItemDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>

        /**
         * Returns a raw HTTP response for `post /invoice/{invoice_id}/item`, but is otherwise the
         * same as [ItemServiceAsync.add].
         */
        fun add(
            invoiceId: String,
            params: ItemAddParams,
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            add(invoiceId, params, RequestOptions.none())

        /** @see add */
        fun add(
            invoiceId: String,
            params: ItemAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            add(params.toBuilder().invoiceId(invoiceId).build(), requestOptions)

        /** @see add */
        fun add(params: ItemAddParams): CompletableFuture<HttpResponseFor<InvoiceResponse>> =
            add(params, RequestOptions.none())

        /** @see add */
        fun add(
            params: ItemAddParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InvoiceResponse>>
    }
}
