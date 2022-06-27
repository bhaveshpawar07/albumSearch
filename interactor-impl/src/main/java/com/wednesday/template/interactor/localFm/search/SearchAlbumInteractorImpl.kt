package com.wednesday.template.interactor.localFm.search

import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.domain.lastFm.SearchAlbumUseCase
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.presentation.base.UIList
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class SearchAlbumInteractorImpl(
    private val searchAlbumUseCase: SearchAlbumUseCase,
    private val coroutineContextController: CoroutineContextController,
    private val uiAlbumMapperImpl: UIAlbumMapperImpl
) : SearchAlbumInteractor {

    private val searchResultChannel = Channel<List<Album>> { }

    override val searchResultsFlow: Flow<UIList> = searchResultChannel
        .consumeAsFlow()
        .map {
            UIList(uiAlbumMapperImpl.map(it))
        }
        .flowOn(coroutineContextController.dispatcherDefault)
//        .catch { e ->
//            emit(UIResult.Error(e as Exception ))
//        }

    override suspend fun search(searchTerm: String): Unit = coroutineContextController.switchToDefault {
        val list = when (val albumResult = searchAlbumUseCase(searchTerm)) {
            is Result.Error -> {
                listOf()
            }
            is Result.Success -> {
                albumResult.data
            }
        }

        searchResultChannel.send(list)
    }
}
