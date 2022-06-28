package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails
import kotlinx.coroutines.flow.Flow

interface LastFmRepository {
    suspend fun searchAlbum(albumName: String): List<Album>

    suspend fun setAlbumAsFavourite(album: Album)

    suspend fun deleteAlbumAsFavourite(album: Album)

    suspend fun getFavouriteAlbum():List<Album>

    fun getFavouriteAlbumFlow(): Flow<List<Album>>
}
