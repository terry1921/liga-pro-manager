package dev.terryrockstar.ligapromanager.teams

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.terryrockstar.core.data.utils.DataMock
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens

@Composable
fun TeamDetailScreen(
    teamId: Int,
    modifier: Modifier = Modifier,
    viewModel: TeamDetailViewModel = hiltViewModel()
) {
    // val team by viewModel.getTeamDetail(teamId).collectAsState(initial = null)
    val team = DataMock.TEAM_DETAIL

    team?.let {
        Column(
            modifier =
            modifier
                .fillMaxSize()
                .padding(Dimens.size4)
        ) {
            Text(
                text = it.name,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = Dimens.size3)
            )

            Text("Jugadores", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(Dimens.size2))

            /*it.players.forEach { player ->
                PlayerRow(player)
                Spacer(modifier = Modifier.height(Dimens.size1))
            }*/
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
