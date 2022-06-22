package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album

interface LastFmRepository {
    suspend fun searchAlbum(albumName: String): List<Album>
}
