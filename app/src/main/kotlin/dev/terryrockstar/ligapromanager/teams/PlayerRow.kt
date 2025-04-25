package dev.terryrockstar.ligapromanager.teams

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import dev.terryrockstar.core.model.team.PlayerData
import dev.terryrockstar.ligapromanager.ui.tokens.Dimens

@Composable
fun PlayerRow(player: PlayerData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.size2))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(Dimens.size3),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = player.name,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = player.number.toString(),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
