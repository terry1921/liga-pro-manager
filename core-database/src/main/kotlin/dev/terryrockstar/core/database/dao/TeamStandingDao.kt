package dev.terryrockstar.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.terryrockstar.core.database.entity.TeamStandingEntity

@Dao
interface TeamStandingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamStandingEntity>)

    @Query("SELECT * FROM standings ORDER BY points DESC")
    suspend fun getAllStandings(): List<TeamStandingEntity>
}
