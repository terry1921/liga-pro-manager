package dev.terryrockstar.core.database.match

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MatchModule {

    @Binds
    @Singleton
    abstract fun bindMatchSource(localSource: MatchLocalSource): MatchSource
}
