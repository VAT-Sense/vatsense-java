// File generated from our OpenAPI spec by Stainless.

package com.vatsense.errors

import com.vatsense.core.JsonValue
import com.vatsense.core.http.Headers

abstract class VatSenseServiceException
protected constructor(message: String, cause: Throwable? = null) :
    VatSenseException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
