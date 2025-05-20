package dev.terryrockstar.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.terryrockstar.core.database.entity.TeamEntity

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teams: List<TeamEntity>)

    @Query("SELECT * FROM teams ORDER BY name ASC")
    suspend fun getAllTeams(): List<TeamEntity>

    @Query("SELECT * FROM teams WHERE id = :id")
    suspend fun getTeamById(id: Int): TeamEntity?
}
