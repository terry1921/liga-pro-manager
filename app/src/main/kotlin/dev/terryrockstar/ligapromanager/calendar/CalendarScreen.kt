package dev.terryrockstar.ligapromanager.calendar

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
import androidx.hilt.navigation.compose.hiltViewModel
import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens
import timber.log.Timber

@Composable
fun CalendarScreen(
    paddingValues: PaddingValues,
    navigateToMatchDetail: (Int) -> Unit,
    viewModel: CalendarViewModel = hiltViewModel()
) {
    Timber.tag("PaddingValues").d("padding values -> $paddingValues")

    val matches by viewModel.matches.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.preload()
    }

    CalendarContent(matches, navigateToMatchDetail)
}

@Composable
fun CalendarContent(matches: List<MatchData>, navigateToMatchDetail: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.size4, vertical = Dimens.size5)
    ) {
        Text(
            text = "Calendario de Partidos",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(Dimens.size3))

        matches.forEach { match ->
            MatchCard(match = match) {
                navigateToMatchDetail.invoke(match.id)
            }
            Spacer(modifier = Modifier.height(Dimens.size2))
        }

        Spacer(modifier = Modifier.height(Dimens.size2))

        TopScorerCard(
            name = "Juan Pérez",
            team = "Loros",
            goals = 12
        )
    }
}

