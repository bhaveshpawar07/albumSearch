package com.wednesday.template.interactor.localFm

import com.wednesday.template.presentation.base.UIResult
import com.wednesday.template.presentation.lastFm.UIAlbum
import kotlinx.coroutines.flow.Flow

interface FavouriteAlbumInteractor {
    suspend fun setFavouriteAlbum(album: UIAlbum): UIResult<Unit>

    suspend fun removeFavouriteAlbum(album: UIAlbum): UIResult<Unit>

    suspend fun getFavouriteAlbums(): UIResult<List<UIAlbum>>

    fun getFavouriteAlbumsFlow(): Flow<UIResult<List<UIAlbum>>>
}
