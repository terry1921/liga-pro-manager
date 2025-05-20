package dev.terryrockstar.core.database.standings

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TeamStandingModule {

    @Binds
    @Singleton
    abstract fun bindTeamStandingSource(localSource: TeamStandingLocalSource): TeamStandingSource
}
