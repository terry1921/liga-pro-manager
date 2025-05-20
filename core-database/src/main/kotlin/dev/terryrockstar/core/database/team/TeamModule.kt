package dev.terryrockstar.core.database.team

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TeamModule {

    @Binds
    @Singleton
    abstract fun bindTeamSource(localSource: TeamLocalSource): TeamSource
}
