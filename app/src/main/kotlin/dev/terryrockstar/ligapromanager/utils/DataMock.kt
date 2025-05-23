package dev.terryrockstar.ligapromanager.utils

import dev.terryrockstar.core.database.entity.MatchEntity
import dev.terryrockstar.core.database.entity.TeamEntity
import dev.terryrockstar.core.model.standings.TeamStanding

data object DataMock {
    val TEAMS_STANDINGS =
        listOf(
            TeamStanding(1, "La bomba", 15, 11, 1, 3, 60, 23, points = 33),
            TeamStanding(2, "Makina", 15, 11, 1, 3, 46, 24, points = 32),
            TeamStanding(3, "Reimon", 15, 10, 1, 4, 44, 21, points = 31),
            TeamStanding(4, "Chape", 15, 9, 3, 3, 54, 24, points = 30),
            TeamStanding(5, "Cardenas", 15, 9, 2, 4, 49, 35, points = 29),
            TeamStanding(6, "Carrillo", 15, 8, 2, 5, 31, 17, points = 26),
            TeamStanding(7, "RC", 15, 7, 3, 5, 41, 44, points = 24),
            TeamStanding(8, "Juventus", 15, 7, 2, 6, 35, 39, points = 23),
            TeamStanding(9, "Loros F.C.", 15, 7, 1, 7, 22, 24, points = 22),
            TeamStanding(10, "Divenca", 15, 6, 1, 8, 39, 35, points = 19),
            TeamStanding(11, "Borusia", 15, 4, 4, 7, 32, 36, points = 16),
            TeamStanding(12, "Lotto", 15, 5, 1, 9, 33, 40, points = 16),
            TeamStanding(13, "Fox", 15, 4, 4, 7, 33, 40, points = 16),
            TeamStanding(14, "Villas", 15, 4, 4, 7, 30, 41, points = 16),
            TeamStanding(15, "San roque", 15, 2, 4, 9, 24, 37, points = 10),
            TeamStanding(16, "Tigres", 15, 2, 0, 13, 24, 62, points = 6)
        )
    val MATCHES =
        listOf(
            MatchEntity(
                homeTeam = "Loros FC",
                awayTeam = "Tigres",
                date = "Dom 20 Abr",
                time = "12:00",
                location = "Campo 4, Don Manuel"
            ),
            MatchEntity(
                homeTeam = "Galacticos",
                awayTeam = "Jaguares",
                date = "Dom 27 Abr",
                time = "12:00",
                location = "Campo 1, Don Manuel"
            )
        )

    val TEAMS =
        listOf(
            TeamEntity(id = 1, name = "La bomba"),
            TeamEntity(id = 2, name = "Makina"),
            TeamEntity(id = 3, name = "Reimon"),
            TeamEntity(id = 4, name = "Chape"),
            TeamEntity(id = 5, name = "Cardenas"),
            TeamEntity(id = 6, name = "Carrillo"),
            TeamEntity(id = 7, name = "RC"),
            TeamEntity(id = 8, name = "Juventus"),
            TeamEntity(id = 9, name = "Loros F.C."),
            TeamEntity(id = 10, name = "Divenca"),
            TeamEntity(id = 11, name = "Borusia"),
            TeamEntity(id = 12, name = "Lotto"),
            TeamEntity(id = 13, name = "Fox"),
            TeamEntity(id = 14, name = "Villas"),
            TeamEntity(id = 15, name = "San roque"),
            TeamEntity(id = 16, name = "Tigres")
        )
}
