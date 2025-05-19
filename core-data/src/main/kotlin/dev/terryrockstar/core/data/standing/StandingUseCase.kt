package dev.terryrockstar.core.data.standing

import androidx.annotation.WorkerThread
import dev.terryrockstar.core.model.standings.TeamStanding
import kotlinx.coroutines.flow.Flow

interface StandingUseCase {

    @WorkerThread
    fun getStandings(): Flow<StandingRepositoryState>

    @WorkerThread
    fun insertStandings(list: List<TeamStanding>): Flow<StandingRepositoryState>
}

sealed class StandingRepositoryState {
    data class StandingData(val standings: List<TeamStanding>) : StandingRepositoryState()
    data object Empty : StandingRepositoryState()
}
