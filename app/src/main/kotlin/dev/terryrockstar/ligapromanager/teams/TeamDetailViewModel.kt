package dev.terryrockstar.ligapromanager.teams

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.team.TeamRepository
import dev.terryrockstar.core.model.team.TeamDetailData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@HiltViewModel
class TeamDetailViewModel
@Inject
constructor(private val repository: TeamRepository) :
    ViewModel() {
    fun getTeamDetail(teamId: Int): Flow<TeamDetailData?> = repository.getTeamDetail(teamId)
}
