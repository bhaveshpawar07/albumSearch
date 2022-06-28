package com.wednesday.template.repo.lastFm

import android.util.Log
import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.service.lastFm.LastFmLocalService
import com.wednesday.template.service.lastFm.LastFmRemoteService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LastFmRepositoryImpl(
    private val lastFmRemoteService: LastFmRemoteService,
    private val domainAlbumMapper: DomainAlbumMapper ,
    private val lastFmLocalService: LastFmLocalService,
    private val localAlbumMapper: LocalAlbumMapper
    ) : LastFmRepository {

    override suspend fun searchAlbum(albumName: String): List<Album> = domainAlbumMapper.map(lastFmRemoteService.albumSearch(albumName).results.albummatches.album)

    override suspend fun setAlbumAsFavourite(album: Album) {
        lastFmLocalService.setAlbumAsFavourite(localAlbumMapper.map(album))
    }

    override suspend fun deleteAlbumAsFavourite(album: Album) {
        lastFmLocalService.deleteAlbumAsFavourite(localAlbumMapper.map(album))
    }

    override suspend fun getFavouriteAlbum(): List<Album> {
        return lastFmLocalService.getFavouriteAlbum().let { domainAlbumMapper.mapLocalAlbum(it) }
    }

    override fun getFavouriteAlbumFlow(): Flow<List<Album>> {
        return lastFmLocalService.getFavouriteAlbumFlow().map {
            domainAlbumMapper.mapLocalAlbum(it)
        }
    }
}
