package dev.terryrockstar.ligapromanager.teams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dev.terryrockstar.core.model.team.TeamData
import dev.terryrockstar.ligapromanager.ui.theme.LigaProTheme
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens
import timber.log.Timber

@Composable
fun TeamsScreen(
    paddingValues: PaddingValues,
    navigateToTeamDetail: (Int) -> Unit,
    viewModel: TeamsViewModel = hiltViewModel()
) {
    Timber.tag("PaddingValues").d("padding values -> $paddingValues")
    val teams by viewModel.teams.collectAsState()
    LaunchedEffect(Unit) { viewModel.preloadData() }
    TeamsContent(teams, navigateToTeamDetail)
}

@Composable
fun TeamsContent(teams: List<TeamData>, navigateToTeamDetail: (Int) -> Unit) {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.size4, vertical = Dimens.size5)
    ) {
        Text(
            text = "Listado de Equipos",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(Dimens.size3))

        teams.forEach { team ->
            TeamCard(team = team) {
                navigateToTeamDetail.invoke(team.id)
            }
            Spacer(modifier = Modifier.height(Dimens.size2))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTeamsScreen() {
    val fakeTeams =
        listOf(
            TeamData(1, "Loros F.C."),
            TeamData(2, "Galácticos"),
            TeamData(3, "Juventus")
        )
    LigaProTheme {
        Column {
            fakeTeams.forEach {
                TeamCard(it) {}
                Spacer(modifier = Modifier.height(Dimens.size2))
            }
        }
    }
}
