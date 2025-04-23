package dev.terryrockstar.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.match.MatchRepository
import dev.terryrockstar.core.database.standings.TeamStandingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, BuildConfig.DATABASE_NAME).build()

    @Provides
    fun provideTeamStandingDao(db: AppDatabase): TeamStandingDao = db.teamStandingDao()

    @Provides
    fun provideTeamStandingRepository(dao: TeamStandingDao): TeamStandingRepository =
        TeamStandingRepository(dao)

    @Provides
    fun provideMatchDao(db: AppDatabase): MatchDao = db.matchDao()

    @Provides
    fun provideMatchRepository(dao: MatchDao): MatchRepository =
        MatchRepository(dao)
}
