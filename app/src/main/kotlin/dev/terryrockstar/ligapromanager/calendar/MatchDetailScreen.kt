package dev.terryrockstar.ligapromanager.calendar

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens

@Composable
fun MatchDetailScreen(
    matchId: Int,
    modifier: Modifier = Modifier,
    viewModel: MatchDetailViewModel = hiltViewModel()
) {
    val match by viewModel.getMatchDetail(matchId).collectAsState(initial = null)

    match?.let {
        Column(
            modifier =
            modifier
                .fillMaxSize()
                .padding(Dimens.size4)
        ) {
            Text(
                text = "${it.homeTeam} vs ${it.awayTeam}",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(Dimens.size2))
            Text("Fecha: ${it.date}")
            Text("Hora: ${it.time}")
            Text("Lugar: ${it.location}")
            Spacer(modifier = Modifier.height(Dimens.size4))

            // Aquí podrías agregar más detalles del partido
        }
    } ?: run {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
