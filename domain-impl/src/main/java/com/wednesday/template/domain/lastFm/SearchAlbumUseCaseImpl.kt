package com.wednesday.template.domain.lastFm

import com.wednesday.template.repo.lastFm.LastFmRepository

class SearchAlbumUseCaseImpl(private val lastFmRepository: LastFmRepository) : SearchAlbumUseCase {
    override suspend fun invokeInternal(param: String): List<Album> {
        return lastFmRepository.searchAlbum(param)
    }
}
