package com.wednesday.template.interactor.localFm

interface SearchAlbumInteractor {
    suspend fun search(searchTerm: String)
}
