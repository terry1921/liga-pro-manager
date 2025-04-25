package dev.terryrockstar.ligapromanager.calendar

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.terryrockstar.core.database.dao.MatchDao
import dev.terryrockstar.core.database.entity.toDetailUi
import dev.terryrockstar.core.model.match.MatchDetailData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val matchDao: MatchDao
) : ViewModel() {

    fun getMatchDetail(id: Int): Flow<MatchDetailData?> = matchDao
        .getMatchById(id)
        .map { it?.toDetailUi() }
}
