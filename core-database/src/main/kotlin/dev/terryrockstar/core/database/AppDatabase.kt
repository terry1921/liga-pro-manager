package dev.terryrockstar.core.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.MatchEntity
import dev.terryrockstar.core.database.entity.TeamStandingEntity

@Database(
    entities = [TeamStandingEntity::class, MatchEntity::class],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamStandingDao(): TeamStandingDao
    abstract fun matchDao(): MatchDao
}
