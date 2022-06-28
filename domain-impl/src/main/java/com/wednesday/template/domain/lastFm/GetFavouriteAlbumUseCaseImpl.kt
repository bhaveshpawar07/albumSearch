package com.wednesday.template.domain.lastFm

import com.wednesday.template.repo.lastFm.LastFmRepository

class GetFavouriteAlbumUseCaseImpl(private val lastFmRepository: LastFmRepository) : GetFavouriteAlbumUseCase {
    override suspend fun invokeInternal(param: Unit): List<Album> {
        return lastFmRepository.getFavouriteAlbum()
    }
}
