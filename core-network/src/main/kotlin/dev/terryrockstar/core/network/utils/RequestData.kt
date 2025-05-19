package dev.terryrockstar.core.network.utils

import dev.terryrockstar.core.network.sources.Endpoints
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import okhttp3.Headers.Companion.toHeaders
import okhttp3.Request
import timber.log.Timber

data class RequestData(
    val method: HttpMethod = HttpMethod.GET,
    val resource: String = "",
    var args: Map<String, Any> = mapOf(),
    var connectTimeout: Int = Constants.TIMEOUT
)

fun RequestData.getRequest(): Request {
    val url = getUrl()
    val header = mapOf(
        // add other headers if needed
        "Accept" to "application/json"
    ).toHeaders()

    return Request.Builder()
        .url(url)
        .method(method.method, body = null)
        .headers(header)
        .build()
}

private fun RequestData.getUrl(): String {
    var url = "${Endpoints.BASE_URL}$resource"
    try {
        url = setParams(url)
    } catch (e: UnsupportedEncodingException) {
        Timber.tag("Request").e(e.cause, e.message ?: "error convirtiendo url")
    }
    return url
}

private fun RequestData.setParams(url: String): String {
    val queryParams = args.toSortedMap().map { (key, value) ->
        "${URLEncoder.encode(key, "UTF-8")}=${URLEncoder.encode(value.toString(), "UTF-8")}"
    }.joinToString("&")
    return if (url.contains("?")) {
        if (queryParams.isEmpty()) {
            url
        } else {
            "$url&$queryParams"
        }
    } else {
        if (queryParams.isEmpty()) {
            url
        } else {
            "$url?$queryParams"
        }
    }
}
