package com.wednesday.template.interactor.localFm.favourite

import android.util.Log
import com.wednesday.template.domain.lastFm.GetFavouriteAlbumFlowUseCase
import com.wednesday.template.domain.lastFm.GetFavouriteAlbumUseCase
import com.wednesday.template.domain.lastFm.RemoveAlbumFavouriteUseCase
import com.wednesday.template.domain.lastFm.SetAlbumFavouriteUseCase
import com.wednesday.template.interactor.base.BaseInteractor
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.base.mapToUIResult
import com.wednesday.template.interactor.localFm.FavouriteAlbumInteractor
import com.wednesday.template.interactor.localFm.search.UIAlbumMapper
import com.wednesday.template.presentation.base.UIResult
import com.wednesday.template.presentation.lastFm.UIAlbum
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class FavouriteAlbumInteractorImpl(
    private val setAlbumFavouriteUseCase: SetAlbumFavouriteUseCase,
    private val removeAlbumFavouriteUseCase: RemoveAlbumFavouriteUseCase,
    private val getFavouriteAlbumUseCase: GetFavouriteAlbumUseCase,
    private val getFavouriteAlbumFlowUseCase: GetFavouriteAlbumFlowUseCase,
    private val controller: CoroutineContextController,
    private val albumMapper: UIAlbumMapper) : BaseInteractor(),FavouriteAlbumInteractor {

    override suspend fun setFavouriteAlbum(uiAlbum: UIAlbum): UIResult<Unit> =
        controller.switchToDefault {
            val album = albumMapper.mapToAlbum(uiAlbum)
            setAlbumFavouriteUseCase(album).let(::mapResult)
        }


    override suspend fun removeFavouriteAlbum(uiAlbum: UIAlbum): UIResult<Unit> =
        controller.switchToDefault {
            val album = albumMapper.mapToAlbum(uiAlbum)
            removeAlbumFavouriteUseCase(album).let(::mapResult)
        }

    override suspend fun getFavouriteAlbums(): UIResult<List<UIAlbum>> {
        TODO("Not yet implemented")
    }

    override fun getFavouriteAlbumsFlow(): Flow<UIResult<List<UIAlbum>>> {
        return getFavouriteAlbumFlowUseCase(Unit)
            .mapToUIResult(success = {
                this.data.map {
                    albumMapper.mapFavAlbum(it)
                }
            })
            .flowOn(controller.dispatcherDefault)

    }
}