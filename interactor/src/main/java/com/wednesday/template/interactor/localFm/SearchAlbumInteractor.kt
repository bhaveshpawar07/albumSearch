package com.wednesday.template.interactor.localFm

import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIResult
import kotlinx.coroutines.flow.Flow

interface SearchAlbumInteractor {
    val searchResultsFlow: Flow<UIResult<UIList>>
    suspend fun search(searchTerm: String)
}
