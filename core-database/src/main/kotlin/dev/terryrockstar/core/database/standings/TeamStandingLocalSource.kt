package dev.terryrockstar.core.database.standings

import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.standings.TeamStanding
import jakarta.inject.Inject
import timber.log.Timber

class TeamStandingLocalSource @Inject constructor(private val dao: TeamStandingDao) :
    TeamStandingSource {

    override suspend fun saveStandings(list: List<TeamStanding>) {
        Timber.d("saveStandings")
        dao.insertAll(list.map { it.toEntity() })
    }

    override suspend fun getStandings(): List<TeamStanding> =
        dao.getAllStandings().map { it.toModel() }
}
