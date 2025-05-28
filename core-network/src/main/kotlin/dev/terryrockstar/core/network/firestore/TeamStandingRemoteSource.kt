package dev.terryrockstar.core.network.firestore

import com.google.firebase.firestore.FirebaseFirestore
import dev.terryrockstar.core.model.standings.TeamStanding
import javax.inject.Inject
import kotlinx.coroutines.tasks.await
import timber.log.Timber

private const val TAG = "FirestoreRequest"

class TeamStandingRemoteSource @Inject constructor(private val firestore: FirebaseFirestore) :
    TeamStandingSource {

    override suspend fun getStandings(): List<TeamStanding> = try {
        Timber.tag(TAG).d("Fetching /standings ordered by position from Firestore.")
        val snapshot = firestore.collection("standings")
            .orderBy("position")
            .get()
            .await()

        Timber.tag(TAG).d("Standings: ${snapshot.documents}")
        val standings = snapshot.documents.mapNotNull { it.toObject(TeamStanding::class.java) }
        Timber.tag(TAG).d("Fetched ${standings.size} standings from Firestore.")
        standings
    } catch (e: Exception) {
        Timber.tag(TAG).e(e, "Error fetching standings from Firestore.")
        emptyList()
    }
}
