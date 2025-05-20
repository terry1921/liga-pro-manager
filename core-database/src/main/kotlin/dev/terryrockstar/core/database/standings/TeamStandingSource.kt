package dev.terryrockstar.core.database.standings

import dev.terryrockstar.core.model.standings.TeamStanding

interface TeamStandingSource {

    suspend fun saveStandings(list: List<TeamStanding>)

    suspend fun getStandings(): List<TeamStanding>
}
