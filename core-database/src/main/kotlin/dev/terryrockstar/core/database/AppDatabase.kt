package dev.terryrockstar.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.TeamStandingEntity

@Database(entities = [TeamStandingEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamStandingDao(): TeamStandingDao
}
