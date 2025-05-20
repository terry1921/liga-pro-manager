package dev.terryrockstar.ligapromanager.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.match.MatchLocalSource
import dev.terryrockstar.core.model.match.MatchData
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class CalendarViewModel
@Inject
constructor(private val repository: MatchLocalSource) :
    ViewModel() {

    private val _matches: MutableStateFlow<List<MatchData>> = MutableStateFlow(emptyList())
    val matches: StateFlow<List<MatchData>> = _matches
        .onStart { getAllMatches() }
        .catch { }
        .stateIn(
            viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun getAllMatches() = viewModelScope.launch {
        repository.getCardMatches()
    }

    fun preload() {
        viewModelScope.launch {
            if (matches.value.isEmpty()) {
                // Preload data only if the matches are empty
                // repository.saveMatches(DataMock.MATCHES)
            }
        }
    }
}
