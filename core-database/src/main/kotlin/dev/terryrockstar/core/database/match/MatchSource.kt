package dev.terryrockstar.core.database.match

import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.core.model.match.MatchDetailData

interface MatchSource {
    suspend fun saveMatches(matches: List<MatchDetailData>)
    suspend fun getCardMatches(): List<MatchData>
}
