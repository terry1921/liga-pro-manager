package dev.terryrockstar.core.database.match

import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.entity.MatchEntity
import dev.terryrockstar.core.model.match.MatchData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MatchRepository @Inject constructor(
    private val matchDao: MatchDao
) {
    fun getMatches(): Flow<List<MatchData>> =
        matchDao.getAllMatches().map { it.map { entity -> entity.toCard() } }

    suspend fun preload(matches: List<MatchEntity>) {
        matchDao.insertAll(matches)
    }
}
