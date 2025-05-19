package dev.terryrockstar.core.database.standings

import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.standings.TeamStanding
import jakarta.inject.Inject

class TeamStandingLocalSource @Inject constructor(
    private val dao: TeamStandingDao
) : TeamStandingSource {

    override suspend fun getStandings(): List<TeamStanding> =
        dao.getAllStandings().map { it.toModel() }

    override suspend fun insertStandings(list: List<TeamStanding>) {
        dao.insertAll(list.map { it.toEntity() })
    }
}
