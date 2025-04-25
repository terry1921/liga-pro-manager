package dev.terryrockstar.core.database.team

import dev.terryrockstar.core.database.dao.PlayerDao
import dev.terryrockstar.core.database.dao.TeamDao
import dev.terryrockstar.core.database.entity.PlayerEntity
import dev.terryrockstar.core.database.entity.TeamEntity
import dev.terryrockstar.core.database.entity.toCard
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.team.TeamData
import dev.terryrockstar.core.model.team.TeamDetailData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val teamDao: TeamDao,
    private val playerDao: PlayerDao
) {
    fun getTeams(): Flow<List<TeamData>> = teamDao.getAllTeams().map { it -> it.map { it.toCard() } }

    fun getTeamDetail(id: Int): Flow<TeamDetailData?> = combine(
        teamDao.getTeamById(id),
        playerDao.getPlayersByTeamId(id)
    ) { team, players ->
        team?.let {
            TeamDetailData(
                id = it.id,
                name = it.name,
                players = players.map { p -> p.toCard() }
            )
        }
    }

    suspend fun insertTeams(list: List<TeamEntity>) {
        teamDao.insertAll(list)
    }

    suspend fun insertPlayers(list: List<PlayerEntity>) {
        playerDao.insertPlayers(list)
    }
}