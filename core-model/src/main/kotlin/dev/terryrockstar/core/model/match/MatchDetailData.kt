package dev.terryrockstar.core.model.match

data class MatchDetailData(
    val id: Int,
    val homeTeam: String,
    val awayTeam: String,
    val date: String,
    val time: String,
    val location: String
)
