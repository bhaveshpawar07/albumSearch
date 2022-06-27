package com.wednesday.template.presentation.lastFm

import com.wednesday.template.presentation.base.UIListItemBase
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIAlbum (
    val albumId: String
        ):UIListItemBase(id = "UIAlbum")