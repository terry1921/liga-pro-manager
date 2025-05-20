package dev.terryrockstar.core.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.dao.PlayerDao
import dev.terryrockstar.core.database.dao.TeamDao
import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.MatchEntity
import dev.terryrockstar.core.database.entity.PlayerEntity
import dev.terryrockstar.core.database.entity.TeamEntity
import dev.terryrockstar.core.database.entity.TeamStandingEntity

@Database(
    entities = [
        TeamStandingEntity::class,
        MatchEntity::class,
        TeamEntity::class,
        PlayerEntity::class
    ],
    version = 3,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 2, to = 3) // Example migration, adjust as needed
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamStandingDao(): TeamStandingDao

    abstract fun matchDao(): MatchDao

    abstract fun teamDao(): TeamDao

    abstract fun playerDao(): PlayerDao
}
