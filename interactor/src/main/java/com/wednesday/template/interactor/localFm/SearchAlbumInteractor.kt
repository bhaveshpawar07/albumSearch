package com.wednesday.template.interactor.localFm

import com.wednesday.template.presentation.base.UIList
import kotlinx.coroutines.flow.Flow

interface SearchAlbumInteractor {
    val searchResultsFlow: Flow<UIList>
    suspend fun search(searchTerm: String)
}
