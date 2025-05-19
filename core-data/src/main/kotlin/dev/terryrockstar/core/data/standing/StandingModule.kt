package dev.terryrockstar.core.data.standing

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StandingModule {
    @Binds
    @Singleton
    abstract fun bindStandingUseCase(standingUseCase: StandingUseCaseImp): StandingUseCase
}
