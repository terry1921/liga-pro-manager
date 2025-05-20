package dev.terryrockstar.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.terryrockstar.core.model.team.PlayerData

@Entity(tableName = "players")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var teamId: Int,
    val name: String,
    val number: Int,
    val goals: Int,
    val yellowCards: Int,
    val redCards: Int
) {
    fun toCard() = PlayerData(
        id,
        teamId,
        name,
        number,
        goals,
        yellowCards,
        redCards
    )
}

fun List<PlayerEntity>.toListCards(): List<PlayerData> = this.map { it.toCard() }

fun PlayerData.toEntity(): PlayerEntity = PlayerEntity(
    id = id,
    teamId = teamId,
    name = name,
    number = number,
    goals = goals,
    yellowCards = yellowCards,
    redCards = redCards
)
