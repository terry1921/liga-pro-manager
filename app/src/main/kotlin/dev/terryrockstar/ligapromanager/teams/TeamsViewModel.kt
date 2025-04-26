package dev.terryrockstar.ligapromanager.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.team.TeamRepository
import dev.terryrockstar.core.model.team.TeamData
import dev.terryrockstar.ligapromanager.utils.DataMock
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class TeamsViewModel
@Inject
constructor(private val repository: TeamRepository) : ViewModel() {
    val teams: StateFlow<List<TeamData>> =
        repository
            .getTeams()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun preloadData() {
        viewModelScope.launch {
            if (teams.value.isEmpty()) {
                // Preload data only if the teams are empty
                repository.insertTeams(DataMock.TEAMS)
            }
        }
    }
}
