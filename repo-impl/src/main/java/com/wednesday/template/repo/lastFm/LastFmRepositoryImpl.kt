package com.wednesday.template.repo.lastFm

import com.wednesday.template.service.lastFm.LastFmRemoteService
import com.wednesday.template.service.lastFm.Remote.Album

class LastFmRepositoryImpl(private val lastFmRemoteService: LastFmRemoteService) : LastFmRepository {

    override suspend fun searchAlbum(albumName: String): List<Album> {
        return lastFmRemoteService.albumSearch(albumName).results.albummatches.album
    }
}
