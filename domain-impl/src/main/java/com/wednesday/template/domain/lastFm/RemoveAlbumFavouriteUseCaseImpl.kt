package com.wednesday.template.domain.lastFm

import com.wednesday.template.repo.lastFm.LastFmRepository

class RemoveAlbumFavouriteUseCaseImpl(private val lastFmRepository: LastFmRepository) : RemoveAlbumFavouriteUseCase {
    override suspend fun invokeInternal(param: Album) {
        return lastFmRepository.deleteAlbumAsFavourite(param)
    }
}
