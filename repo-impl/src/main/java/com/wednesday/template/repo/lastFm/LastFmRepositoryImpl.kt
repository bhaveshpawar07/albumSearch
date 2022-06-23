package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.service.lastFm.LastFmRemoteService

class LastFmRepositoryImpl(private val lastFmRemoteService: LastFmRemoteService, private val albumMapper: AlbumMapper) : LastFmRepository {

    override suspend fun searchAlbum(albumName: String): List<Album> = albumMapper.map(lastFmRemoteService.albumSearch(albumName).results.albummatches.album)
}
