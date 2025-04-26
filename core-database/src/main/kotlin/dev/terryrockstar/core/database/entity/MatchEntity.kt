package dev.terryrockstar.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.core.model.match.MatchDetailData

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val homeTeam: String,
    val awayTeam: String,
    val date: String,
    @ColumnInfo(defaultValue = "'")
    val time: String = "",
    @ColumnInfo(defaultValue = "''")
    val location: String = ""
) {
    fun toCard() = MatchData(
        id = id,
        title = "$homeTeam vs $awayTeam",
        date = date
    )
}

fun List<MatchEntity>.toCard(): List<MatchData> = this.map { match ->
    match.toCard()
}

fun MatchEntity.toDetailUi(): MatchDetailData = MatchDetailData(
    id = id,
    homeTeam = homeTeam,
    awayTeam = awayTeam,
    date = date,
    time = time ?: "",
    location = location ?: ""
)
