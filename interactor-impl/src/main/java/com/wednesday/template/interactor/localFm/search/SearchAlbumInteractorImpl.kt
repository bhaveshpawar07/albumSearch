package com.wednesday.template.interactor.localFm.search

import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.domain.lastFm.SearchAlbumUseCase
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class SearchAlbumInteractorImpl(
    private val searchAlbumUseCase: SearchAlbumUseCase,
    private val coroutineContextController: CoroutineContextController
) : SearchAlbumInteractor {

    private val searchResultChannel  = Channel<List<Album>> {  }

    override val searchResultsFlow: Flow<List<Album>> = searchResultChannel.receiveAsFlow()

    override suspend fun search(searchTerm: String): Unit = coroutineContextController.switchToDefault {
        val list = when (val albumResult = searchAlbumUseCase(searchTerm)) {
            is Result.Success -> albumResult.data
            is Result.Error -> {
                listOf()
            }
        }

        searchResultChannel.send(list)
    }
}
