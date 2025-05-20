package dev.terryrockstar.core.data.standing

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal fun interface StandingModule {
    @Binds
    fun bindStandingUseCase(standingUseCase: StandingUseCaseImpl): StandingUseCase
}
