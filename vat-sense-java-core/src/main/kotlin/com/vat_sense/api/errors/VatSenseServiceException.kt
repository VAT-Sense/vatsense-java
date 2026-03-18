// File generated from our OpenAPI spec by Stainless.

package com.vat_sense.api.errors

import com.vat_sense.api.core.JsonValue
import com.vat_sense.api.core.http.Headers

abstract class VatSenseServiceException
protected constructor(message: String, cause: Throwable? = null) :
    VatSenseException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
