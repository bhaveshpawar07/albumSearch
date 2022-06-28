package com.wednesday.template.service.lastFm

import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails
import kotlinx.coroutines.flow.Flow

interface LastFmLocalService {

    suspend fun setAlbumAsFavourite(album: LocalAlbumDetails)

    suspend fun deleteAlbumAsFavourite(album: LocalAlbumDetails)

    suspend fun getFavouriteAlbum():List<LocalAlbumDetails>

    fun getFavouriteAlbumFlow():Flow<List<LocalAlbumDetails>>
}