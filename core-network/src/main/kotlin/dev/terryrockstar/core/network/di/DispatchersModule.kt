package dev.terryrockstar.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.terryrockstar.core.network.AppDispatcher
import dev.terryrockstar.core.network.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
internal object DispatchersModule {

    @Provides
    @Dispatcher(AppDispatcher.IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(AppDispatcher.UNCONFINED)
    fun providesUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}
