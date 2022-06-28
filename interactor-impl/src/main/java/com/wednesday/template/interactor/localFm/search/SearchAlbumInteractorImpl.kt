package com.wednesday.template.interactor.localFm.search

import android.util.Log
import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.domain.lastFm.GetFavouriteAlbumFlowUseCase
import com.wednesday.template.domain.lastFm.SearchAlbumUseCase
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIResult
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class SearchAlbumInteractorImpl(
    private val searchAlbumUseCase: SearchAlbumUseCase,
    private val coroutineContextController: CoroutineContextController,
    private val uiAlbumSearchMapper: UIAlbumSearchMapper,
    favouriteAlbumFlowUseCase: GetFavouriteAlbumFlowUseCase
) : SearchAlbumInteractor {

    private val searchResultChannel = Channel<List<Album>> { }

//    override val searchResultsFlow: Flow<UIList> = searchResultChannel
//        .consumeAsFlow()
//        .map {
//            UIList(uiAlbumMapper.map(it,false))
//        }
//        .flowOn(coroutineContextController.dispatcherDefault)
//        .catch { e ->
//            emit(UIResult.Error(e as Exception ))
//        }

    override val searchResultsFlow: Flow<UIResult<UIList>> = favouriteAlbumFlowUseCase(Unit)
        .combine(searchResultChannel.receiveAsFlow()){ favouriteAlbum,searchResult ->
            when {
                searchResult.isEmpty() -> {
                    UIResult.Success(
                        UIList()
                    )
                }
                favouriteAlbum is Result.Success ->{
                    UIResult.Success(
                        uiAlbumSearchMapper.map(favouriteAlbum.data,searchResult)
                    )
                }
                favouriteAlbum is Result.Error ->{
                    UIResult.Error(favouriteAlbum.exception)
                }
                else -> {
                    UIResult.Error(error("Something went wrong"))
                }
            }
        }
        .flowOn(coroutineContextController.dispatcherDefault)


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
