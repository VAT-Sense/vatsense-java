package com.vatsense.webhooks

import com.vatsense.errors.VatSenseException

/** The event's signature is missing, malformed, too old or does not match. */
class WebhookSignatureException(message: String) : VatSenseException(message)
