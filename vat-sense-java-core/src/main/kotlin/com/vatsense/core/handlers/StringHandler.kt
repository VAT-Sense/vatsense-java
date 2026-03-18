@file:JvmName("StringHandler")

package com.vatsense.core.handlers

import com.vatsense.core.http.HttpResponse
import com.vatsense.core.http.HttpResponse.Handler

@JvmSynthetic internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
