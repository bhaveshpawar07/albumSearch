package com.wednesday.template.domain.lastFm

import com.wednesday.template.domain.base.BaseSuspendUseCase

interface GetFavouriteAlbumUseCase  : BaseSuspendUseCase<Unit,List<Album>>{
}