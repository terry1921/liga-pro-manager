package dev.terryrockstar.core.data.standing

import dev.terryrockstar.core.database.standings.TeamStandingSource
import dev.terryrockstar.core.model.standings.TeamStanding
import dev.terryrockstar.core.network.AppDispatcher
import dev.terryrockstar.core.network.Dispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

class StandingUseCaseImp @Inject constructor(
    private val localDataSource: TeamStandingSource,
    @Dispatcher(AppDispatcher.IO) private val dispatcher: CoroutineDispatcher
) : StandingUseCase {

    override fun getStandings() = flow {
        val standingList = localDataSource.getStandings()
        // local data source extracts data from database
        if (standingList.isEmpty()) {
            emit(StandingRepositoryState.Empty)
        } else {
            emit(StandingRepositoryState.StandingData(standingList))
        }
    }.flowOn(dispatcher)

    override fun insertStandings(list: List<TeamStanding>) = flow {
        Timber.d("insertStandings")
        localDataSource.insertStandings(list)
        emit(StandingRepositoryState.Empty)
    }.flowOn(dispatcher)
}
