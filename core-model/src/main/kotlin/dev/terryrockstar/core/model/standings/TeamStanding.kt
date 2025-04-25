package dev.terryrockstar.core.model.standings

data class TeamStanding(
    val position: Int,
    val name: String,
    val played: Int,
    val wins: Int,
    val draws: Int,
    val losses: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int = goalsFor - goalsAgainst,
    val points: Int
)

