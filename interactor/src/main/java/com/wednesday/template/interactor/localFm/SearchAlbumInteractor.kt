package com.wednesday.template.interactor.localFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIResult
import kotlinx.coroutines.flow.Flow

interface SearchAlbumInteractor {
    val searchResultsFlow: Flow<UIList>
    suspend fun search(searchTerm: String)
}
