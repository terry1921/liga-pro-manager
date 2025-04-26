package dev.terryrockstar.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.terryrockstar.core.model.team.TeamData

@Entity(tableName = "teams")
data class TeamEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String) {
    fun toCard() = TeamData(id, name)
}

fun TeamData.toEntity(): TeamEntity = TeamEntity(id, name)

fun List<TeamEntity>.toCard(): List<TeamData> = this.map { team ->
    team.toCard()
}
