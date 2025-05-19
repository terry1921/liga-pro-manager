package dev.terryrockstar.core.database.standings

import dev.terryrockstar.core.model.standings.TeamStanding

interface TeamStandingSource {

    suspend fun insertStandings(list: List<TeamStanding>)

    suspend fun getStandings(): List<TeamStanding>
}
