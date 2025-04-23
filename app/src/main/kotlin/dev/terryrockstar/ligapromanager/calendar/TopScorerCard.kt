package dev.terryrockstar.ligapromanager.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.terryrockstar.ligapromanager.ui.theme.LigaProTheme
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens

@Composable
fun TopScorerCard(name: String, team: String, goals: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.size3)),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp,
        onClick = { /* Detalle del jugador */ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.size4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "($team)",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.inverseOnSurface
                )
            }

            Text(
                text = goals.toString(),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )

            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = "Ver jugador",
                tint = Color.White,
                modifier = Modifier.padding(start = Dimens.size2)
            )
        }
    }
}

@Preview
@Composable
fun TopScorerCardPreview() {
    LigaProTheme {
        TopScorerCard(
            name = "Juan Pérez",
            team = "Loros FC",
            goals = 12
        )
    }
}