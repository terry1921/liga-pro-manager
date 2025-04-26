package dev.terryrockstar.core.database.standings

import dev.terryrockstar.core.database.dao.TeamStandingDao
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.standings.TeamStanding
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamStandingRepository
@Inject
constructor(private val dao: TeamStandingDao) {
    fun getStandings(): Flow<List<TeamStanding>> = dao.getAllStandings().map { list ->
        list.map { it.toModel() }
    }

    suspend fun insertStandings(list: List<TeamStanding>) {
        dao.insertAll(list.map { it.toEntity() })
    }
}
