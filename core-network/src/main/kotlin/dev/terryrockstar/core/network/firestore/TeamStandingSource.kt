package dev.terryrockstar.core.network.firestore

import androidx.annotation.WorkerThread
import dev.terryrockstar.core.model.standings.TeamStanding

interface TeamStandingSource {

    @WorkerThread
    suspend fun getStandings(): List<TeamStanding>
}
