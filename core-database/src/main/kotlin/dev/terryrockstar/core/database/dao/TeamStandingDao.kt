package dev.terryrockstar.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.terryrockstar.core.database.entity.TeamStandingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamStandingDao {
    @Query("SELECT * FROM standings ORDER BY points DESC")
    fun getAllStandings(): Flow<List<TeamStandingEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamStandingEntity>)
}
