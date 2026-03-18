// File generated from our OpenAPI spec by Stainless.

package com.vatsense.core

import java.util.Objects

/** A class for configuring which security schemes are enabled for a request. */
class SecurityOptions
private constructor(
    /** Whether the basicAuth security scheme is enabled. */
    @get:JvmName("basicAuth") val basicAuth: Boolean
) {

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [SecurityOptions]. */
        @JvmStatic fun builder() = Builder()

        /** Returns a [Security] instance with all security schemes enabled. */
        @JvmStatic fun all(): SecurityOptions = builder().basicAuth(true).build()

        /** Returns a [Security] instance with no security schemes enabled. */
        @JvmStatic fun none(): SecurityOptions = builder().build()
    }

    /** A builder for [SecurityOptions]. */
    class Builder internal constructor() {

        private var basicAuth: Boolean = false

        @JvmSynthetic
        internal fun from(securityOptions: SecurityOptions) = apply {
            basicAuth = securityOptions.basicAuth
        }

        /** Whether the basicAuth security scheme is enabled. */
        fun basicAuth(basicAuth: Boolean) = apply { this.basicAuth = basicAuth }

        /**
         * Returns an immutable instance of [SecurityOptions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): SecurityOptions = SecurityOptions(basicAuth)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SecurityOptions && basicAuth == other.basicAuth
    }

    override fun hashCode(): Int = Objects.hash(basicAuth)

    override fun toString() = "SecurityOptions{basicAuth=$basicAuth}"
}
