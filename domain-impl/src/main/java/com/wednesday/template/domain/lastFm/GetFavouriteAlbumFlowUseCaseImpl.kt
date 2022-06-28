package com.wednesday.template.domain.lastFm

import com.wednesday.template.repo.lastFm.LastFmRepository
import kotlinx.coroutines.flow.Flow

class GetFavouriteAlbumFlowUseCaseImpl(private val lastFmRepository: LastFmRepository) : GetFavouriteAlbumFlowUseCase {
    override fun invokeInternal(param: Unit): Flow<List<Album>> {
        return lastFmRepository.getFavouriteAlbumFlow()
    }
}