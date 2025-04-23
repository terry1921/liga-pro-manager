package dev.terryrockstar.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.terryrockstar.core.model.match.MatchUi

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val homeTeam: String,
    val awayTeam: String,
    val date: String // o usa `LocalDate` si manejas conversión
) {
    fun toUi() = MatchUi(
        title = "$homeTeam vs $awayTeam",
        date = date
    )
}

fun <E> List<E>.toUI(): List<MatchUi> {
    return this.map { match ->
        when (match) {
            is MatchEntity -> match.toUi()
            else -> throw IllegalArgumentException("Tipo no soportado")
        }
    }
}
