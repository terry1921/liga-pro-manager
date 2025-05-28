package dev.terryrockstar.core.data.standing

import androidx.annotation.WorkerThread
import dev.terryrockstar.core.database.standings.TeamStandingSource
import dev.terryrockstar.core.network.AppDispatcher
import dev.terryrockstar.core.network.Dispatcher
import dev.terryrockstar.core.network.firestore.TeamStandingRemoteSource
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class StandingUseCaseImpl @Inject constructor(
    private val localSource: TeamStandingSource,
    private val remoteSource: TeamStandingRemoteSource,
    @Dispatcher(AppDispatcher.IO) private val dispatcher: CoroutineDispatcher
) : StandingUseCase {

    @WorkerThread
    override fun getStandings(): Flow<StandingRepositoryState> = flow {
        val remoteStandings = remoteSource.getStandings()
        if (remoteStandings.isNotEmpty()) {
            localSource.saveStandings(remoteStandings)
            emit(StandingRepositoryState.StandingData(remoteStandings))
            return@flow
        }

        val localStandings = localSource.getStandings()
        if (localStandings.isNotEmpty()) {
            emit(StandingRepositoryState.StandingData(localStandings))
        } else {
            emit(StandingRepositoryState.Empty)
        }
    }.flowOn(dispatcher)
}
