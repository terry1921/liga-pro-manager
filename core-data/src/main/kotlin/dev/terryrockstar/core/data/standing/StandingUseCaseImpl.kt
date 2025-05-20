package dev.terryrockstar.core.data.standing

import androidx.annotation.WorkerThread
import dev.terryrockstar.core.data.utils.DataMock
import dev.terryrockstar.core.database.standings.TeamStandingSource
import dev.terryrockstar.core.network.AppDispatcher
import dev.terryrockstar.core.network.Dispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class StandingUseCaseImpl @Inject constructor(
    private val localDataSource: TeamStandingSource,
    @Dispatcher(AppDispatcher.IO) private val dispatcher: CoroutineDispatcher
) : StandingUseCase {

    @WorkerThread
    override fun getStandings() = flow {
        // get from remote data source if error check local source
        val standingList = localDataSource.getStandings()
        // local data source extracts data from database
        if (standingList.isEmpty()) {
            // get from network
            Timber.d("getStandings: list is empty")
            localDataSource.saveStandings(DataMock.TEAMS_STANDINGS)
            emit(StandingRepositoryState.StandingData(DataMock.TEAMS_STANDINGS))
        } else {
            Timber.d("getStandings: list is not empty")
            emit(StandingRepositoryState.StandingData(standingList))
        }
    }.flowOn(dispatcher)
}
