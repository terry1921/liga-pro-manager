package dev.terryrockstar.ligapromanager.teams

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.team.TeamLocalSource
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel
@Inject
constructor(private val repository: TeamLocalSource) :
    ViewModel() {
    // fun getTeamDetail(teamId: Int): Flow<TeamDetailData?> = repository.getTeamDetail(teamId)
}
