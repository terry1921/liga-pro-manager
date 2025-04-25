package dev.terryrockstar.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.terryrockstar.core.database.entity.TeamEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams ORDER BY name ASC")
    fun getAllTeams(): Flow<List<TeamEntity>>

    @Query("SELECT * FROM teams WHERE id = :id")
    fun getTeamById(id: Int): Flow<TeamEntity?>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamEntity>)
}