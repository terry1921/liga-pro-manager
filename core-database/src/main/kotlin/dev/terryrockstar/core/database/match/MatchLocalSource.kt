package dev.terryrockstar.core.database.match

import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.entity.toEntity
import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.core.model.match.MatchDetailData
import javax.inject.Inject

class MatchLocalSource @Inject constructor(private val dao: MatchDao) : MatchSource {

    override suspend fun saveMatches(matches: List<MatchDetailData>) {
        dao.insertAll(matches.map { it.toEntity() })
    }

    override suspend fun getCardMatches(): List<MatchData> = dao.getAllMatches().map { it.toCard() }
}
