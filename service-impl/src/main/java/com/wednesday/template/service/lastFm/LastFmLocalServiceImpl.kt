package com.wednesday.template.service.lastFm

import androidx.room.*
import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails
import kotlinx.coroutines.flow.Flow

@Dao
interface LastFmLocalServiceImpl : LastFmLocalService {

    @Delete
    override suspend fun deleteAlbumAsFavourite(album: LocalAlbumDetails)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun setAlbumAsFavourite(album: LocalAlbumDetails)

    @Query("Select * from album_details")
    override suspend fun getFavouriteAlbum(): List<LocalAlbumDetails>

    @Query("Select * from album_details")
    override fun getFavouriteAlbumFlow(): Flow<List<LocalAlbumDetails>>
}