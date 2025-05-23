package dev.terryrockstar.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.terryrockstar.core.database.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players WHERE teamId = :teamId")
    fun getPlayersByTeamId(teamId: Int): Flow<List<PlayerEntity>>

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<PlayerEntity>)
}
