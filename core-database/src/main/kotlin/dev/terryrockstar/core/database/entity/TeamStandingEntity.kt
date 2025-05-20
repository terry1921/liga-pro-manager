package dev.terryrockstar.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.terryrockstar.core.model.standings.TeamStanding

@Entity(tableName = "standings")
data class TeamStandingEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val position: Int,
    val played: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val points: Int
) {
    fun toModel() = TeamStanding(
        id,
        position,
        name,
        played,
        wins,
        draws,
        losses,
        goalsFor,
        goalsAgainst,
        goalDifference = goalsFor - goalsAgainst,
        points
    )
}

fun TeamStanding.toEntity(): TeamStandingEntity = TeamStandingEntity(
    id,
    name,
    position,
    played,
    wins,
    draws,
    losses,
    goalsFor,
    goalsAgainst,
    points
)
