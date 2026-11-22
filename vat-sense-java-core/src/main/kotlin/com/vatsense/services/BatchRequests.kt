// Batches: bulk validation through `/batches` (November 2026).

package com.vatsense.services

import com.vatsense.core.ClientOptions
import com.vatsense.core.Params
import com.vatsense.core.http.HttpMethod
import com.vatsense.core.http.HttpRequest
import com.vatsense.core.http.json
import com.vatsense.core.prepare
import com.vatsense.models.batches.BatchBaseParams

/** Builds the requests of the batch calls, for the blocking and the async services. */
internal object BatchRequests {

    fun build(
        clientOptions: ClientOptions,
        method: HttpMethod,
        params: Params,
        vararg segments: String,
    ): HttpRequest {
        require(segments.drop(1).none { it.isEmpty() }) { "`batchId` must not be empty" }
        return HttpRequest.builder()
            .method(method)
            .baseUrl(clientOptions.baseUrl())
            .addPathSegments(*segments)
            .apply {
                if (params is BatchBaseParams) {
                    params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) }
                } else if (method == HttpMethod.POST) {
                    body(json(clientOptions.jsonMapper, emptyMap<String, Any>()))
                }
            }
            .build()
            .prepare(clientOptions, params)
    }
}
