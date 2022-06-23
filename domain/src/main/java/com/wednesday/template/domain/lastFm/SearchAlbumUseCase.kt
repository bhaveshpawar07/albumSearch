package com.wednesday.template.domain.lastFm

import com.wednesday.template.domain.base.BaseSuspendUseCase

interface SearchAlbumUseCase : BaseSuspendUseCase<String, List<Album>>
