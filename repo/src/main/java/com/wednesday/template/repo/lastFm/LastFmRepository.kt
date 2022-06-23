package com.wednesday.template.repo.lastFm

import com.wednesday.template.service.lastFm.Remote.Album

interface LastFmRepository {
    suspend fun searchAlbum(albumName: String): List<Album>
}
