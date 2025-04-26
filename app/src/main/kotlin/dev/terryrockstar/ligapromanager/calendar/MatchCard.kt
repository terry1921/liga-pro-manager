package dev.terryrockstar.ligapromanager.calendar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.ligapromanager.ui.theme.LigaProTheme
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens

@Composable
fun MatchCard(match: MatchData, onClick: () -> Unit) {
    Surface(
        modifier =
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.size3)),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp,
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(Dimens.size4)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = match.title,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    tint = Color.White,
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = "Ver detalle"
                )
            }
            Spacer(modifier = Modifier.height(Dimens.size1))
            Text(
                text = match.date,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.inverseOnSurface
            )
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {
    LigaProTheme {
        MatchCard(
            match =
            MatchData(
                id = 1,
                title = "Loros FC vs Tigres",
                date = "Dom 20 Abr"
            ),
            onClick = {}
        )
    }
}
