package dev.terryrockstar.ligapromanager.teams

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.team.TeamLocalSource
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel
@Inject
constructor(private val repository: TeamLocalSource) : ViewModel() {
    /*val teams: StateFlow<List<TeamData>> =
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
    }*/
}
