package dev.terryrockstar.ligapromanager.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.match.MatchLocalSource
import dev.terryrockstar.core.model.match.MatchData
import dev.terryrockstar.ligapromanager.utils.DataMock
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class CalendarViewModel
@Inject
constructor(private val repository: MatchLocalSource) :
    ViewModel() {
    val matches: StateFlow<List<MatchData>> =
        repository
            .getMatches()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun preload() {
        viewModelScope.launch {
            if (matches.value.isEmpty()) {
                // Preload data only if the matches are empty
                repository.preload(DataMock.MATCHES)
            }
        }
    }
}
