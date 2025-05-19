package dev.terryrockstar.ligapromanager.standing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.data.standing.StandingRepositoryState
import dev.terryrockstar.core.data.standing.StandingUseCase
import dev.terryrockstar.core.model.standings.TeamStanding
import dev.terryrockstar.core.network.AppDispatcher
import dev.terryrockstar.core.network.Dispatcher
import dev.terryrockstar.ligapromanager.utils.DataMock
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val useCase: StandingUseCase,
    @Dispatcher(AppDispatcher.IO) private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _standings: MutableStateFlow<List<TeamStanding>> = MutableStateFlow(emptyList())
    val standings: StateFlow<List<TeamStanding>> = _standings
        .onStart { getAllStandings() }
        .catch { }
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun getAllStandings() = viewModelScope.launch {
        useCase.getStandings()
            .onStart { }
            .catch { }
            .collect { result ->
                when (result) {
                    StandingRepositoryState.Empty -> {}
                    is StandingRepositoryState.StandingData -> {
                        _standings.value = result.standings
                    }
                }
            }
    }

    fun preloadData() = viewModelScope.launch(dispatcher) {
        if (standings.value.isEmpty()) {
            Timber.d("Preloading data")
            useCase.insertStandings(DataMock.TEAMS_STANDINGS)
        }
    }
}
