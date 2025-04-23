package dev.terryrockstar.ligapromanager.standing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dev.terryrockstar.core.model.standings.TeamStanding
import dev.terryrockstar.ligapromanager.ui.theme.LigaProTheme
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens
import dev.terryrockstar.ligapromanager.utils.DataMock
import timber.log.Timber

@Composable
fun StandingsScreen(
    paddingValues: PaddingValues,
    viewModel: StandingsViewModel = hiltViewModel()
) {
    Timber.tag("StandingsScreen").d("padding values -> $paddingValues")
    val teams by viewModel.standings.collectAsState()
    LaunchedEffect(Unit) { viewModel.preloadData() }
    StandingsContent(teams)
}

@Composable
fun StandingsContent(
    teams: List<TeamStanding>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(Dimens.size4)
            .fillMaxSize()
    ) {
        SearchTeamBox()
        Spacer(modifier = Modifier.height(Dimens.size4))
        StandingsTable(teams)
    }
}

@Composable
private fun SearchTeamBox() {
    var searchQuery by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
        },
        placeholder = { Text("Buscar equipo") },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.size3)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = colorScheme.secondary,
            unfocusedContainerColor = colorScheme.secondary,
            unfocusedPlaceholderColor = Color.White,
            focusedPlaceholderColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = Color.White
        )
    )
}

@Composable
fun StandingsTable(teams: List<TeamStanding>) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(Dimens.size4))
            .background(colorScheme.tertiaryContainer)
            .padding(vertical = Dimens.size2)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Tabla de Posiciones",
            style = MaterialTheme.typography.titleLarge,
            color = colorScheme.scrim,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(Dimens.size2))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.tertiary)
        ) {
            TableCell("#", weight = 2f, isHeader = true)
            TableCell("Equipo", weight = 7f, isHeader = true, isName = true)
            TableCell("PJ", weight = 3f, isHeader = true)
            TableCell("G", weight = 2f, isHeader = true)
            TableCell("E", weight = 2f, isHeader = true)
            TableCell("P", weight = 2f, isHeader = true)
            TableCell("Ga", weight = 3f, isHeader = true)
            TableCell("Gd", weight = 3f, isHeader = true)
            TableCell("Dif", weight = 3f, isHeader = true)
            TableCell("Pts", weight = 3f, isHeader = true)
        }
        teams.forEach {
            Row(modifier = Modifier.fillMaxWidth()) {
                TableCell(it.position.toString(), weight = 2f)
                TableCell(it.name, weight = 7f, isName = true)
                TableCell(it.played.toString(), weight = 3f)
                TableCell(it.wins.toString(), weight = 2f)
                TableCell(it.draws.toString(), weight = 2f)
                TableCell(it.losses.toString(), weight = 2f)
                TableCell(it.goalsAgainst.toString(), weight = 3f)
                TableCell(it.goalsFor.toString(), weight = 3f)
                TableCell(it.goalDifference.toString(), weight = 3f)
                TableCell(it.points.toString(), weight = 3f)
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    isName: Boolean = false,
    isHeader: Boolean = false
) {
    Text(
        modifier = Modifier
            .weight(weight)
            .padding(Dimens.size1),
        text = text,
        color = colorScheme.scrim,
        textAlign = if (isName) TextAlign.Start else TextAlign.Center,
        style = if (isHeader) MaterialTheme.typography.titleSmall else MaterialTheme.typography.bodySmall,
    )
}

@Preview(name = "Standings Table - Dark Mode")
@Composable
fun PreviewStandingsScreen() {
    LigaProTheme() {
        StandingsTable(DataMock.TEAMS_STANDINGS)
    }
}

@Preview(name = "Standings Table")
@Composable
fun PreviewSearchTeamBox() {
    LigaProTheme() {
        SearchTeamBox()
    }
}