package dev.terryrockstar.core.network.okhttp

import javax.inject.Inject
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

class OkHttpNetworkClient @Inject constructor(
    private val okHttpClient: OkHttpClient
) : NetworkClient {
    override fun client(): OkHttpClient = okHttpClient
    override fun newCall(request: Request): Call {
        return okHttpClient.newCall(request)
    }
}
