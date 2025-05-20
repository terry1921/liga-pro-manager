package dev.terryrockstar.core.database.team

import dev.terryrockstar.core.model.team.PlayerData
import dev.terryrockstar.core.model.team.TeamData
import dev.terryrockstar.core.model.team.TeamDetailData

interface TeamSource {

    suspend fun saveTeams(list: List<TeamData>)

    suspend fun getTeams(): List<TeamData>

    suspend fun getTeamDetail(id: Int): TeamDetailData?

    suspend fun savePlayers(list: List<PlayerData>)
}
