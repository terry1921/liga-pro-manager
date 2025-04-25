package dev.terryrockstar.ligapromanager.standing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.standings.TeamStandingRepository
import dev.terryrockstar.core.model.standings.TeamStanding
import dev.terryrockstar.ligapromanager.utils.DataMock
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val repository: TeamStandingRepository
) : ViewModel() {

    val standings: StateFlow<List<TeamStanding>> =
        repository.getStandings()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun preloadData() {
        viewModelScope.launch {
            if (standings.value.isEmpty()) {
                // Preload data only if the standings are empty
                repository.insertStandings(DataMock.TEAMS_STANDINGS)
            }
        }
    }
}
