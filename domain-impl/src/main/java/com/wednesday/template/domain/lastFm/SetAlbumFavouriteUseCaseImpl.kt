package com.wednesday.template.domain.lastFm

import com.wednesday.template.repo.lastFm.LastFmRepository

class SetAlbumFavouriteUseCaseImpl(private val lastFmRepository: LastFmRepository) : SetAlbumFavouriteUseCase {
    override suspend fun invokeInternal(param: Album) {
        return lastFmRepository.setAlbumAsFavourite(param)
    }
}
