package dev.terryrockstar.core.model.standings

import com.google.errorprone.annotations.Keep

@Keep
data class TeamStanding(
    val id: Int = 0,
    val position: Int = 0,
    val name: String = "",
    val played: Int = 0,
    val wins: Int = 0,
    val draws: Int = 0,
    val losses: Int = 0,
    val goalsFor: Int = 0,
    val goalsAgainst: Int = 0,
    val points: Int = 0
) {
    fun getGoalDifference(): Int = goalsFor - goalsAgainst
}
