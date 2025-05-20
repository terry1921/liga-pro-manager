package dev.terryrockstar.core.database.team

import dev.terryrockstar.core.database.dao.PlayerDao
import dev.terryrockstar.core.database.dao.TeamDao
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.team.PlayerData
import dev.terryrockstar.core.model.team.TeamData
import dev.terryrockstar.core.model.team.TeamDetailData
import javax.inject.Inject

class TeamLocalSource @Inject constructor(
    private val teamDao: TeamDao,
    private val playerDao: PlayerDao
) : TeamSource {

    override suspend fun saveTeams(list: List<TeamData>) {
        teamDao.insertAll(list.map { it.toEntity() })
    }

    override suspend fun getTeams(): List<TeamData> = teamDao.getAllTeams().map { it.toCard() }

    override suspend fun getTeamDetail(id: Int): TeamDetailData? = teamDao.getTeamById(id)?.let {
        TeamDetailData(
            id = it.id,
            name = it.name,
            players = playerDao.getPlayersByTeamId(id).map { p -> p.toCard() }
        )
    }

    override suspend fun savePlayers(list: List<PlayerData>) {
        playerDao.insertPlayers(list.map { it.toEntity() })
    }
}
