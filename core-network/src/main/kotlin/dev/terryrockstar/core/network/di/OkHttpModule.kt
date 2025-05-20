package dev.terryrockstar.core.network.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.terryrockstar.core.network.interceptor.MyInterceptor
import dev.terryrockstar.core.network.okhttp.NetworkClient
import dev.terryrockstar.core.network.okhttp.OkHttpNetworkClient
import dev.terryrockstar.core.network.utils.Constants
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideNetworkClient(okHttpClientFactory: OkHttpClientFactory): NetworkClient {
        return OkHttpNetworkClient(okHttpClientFactory.create(isRedirect = false).build())
    }

    @AssistedFactory
    fun interface OkHttpClientFactory {
        fun create(isRedirect: Boolean): OkHttpClientBuilder
    }

    open class OkHttpClientBuilder @AssistedInject constructor(
        @Assisted val isRedirect: Boolean
    ) {
        fun build(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(MyInterceptor())
                .followRedirects(isRedirect)
                .followSslRedirects(isRedirect)
                .connectTimeout(Constants.TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .readTimeout(Constants.TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(Constants.TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
                .build()
        }
    }
}
