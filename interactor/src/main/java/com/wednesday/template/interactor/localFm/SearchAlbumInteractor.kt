package com.wednesday.template.interactor.localFm

import com.wednesday.template.domain.lastFm.Album
import kotlinx.coroutines.flow.Flow

interface SearchAlbumInteractor {
    val searchResultsFlow: Flow<List<Album>>
    suspend fun search(searchTerm: String)
}
