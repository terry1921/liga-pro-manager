package dev.terryrockstar.core.network.okhttp

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

interface NetworkClient {
    fun client(): OkHttpClient
    fun newCall(request: Request): Call
}
