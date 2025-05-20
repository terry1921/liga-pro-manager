package dev.terryrockstar.core.model.team

data class PlayerData(
    val id: Int,
    val teamId: Int,
    val name: String,
    val number: Int,
    val goals: Int,
    val yellowCards: Int,
    val redCards: Int
)
