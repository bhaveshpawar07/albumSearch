package com.wednesday.template.presentation.lastFm

import com.wednesday.template.presentation.base.UIListItemBase
import kotlinx.parcelize.Parcelize

@Parcelize
data class UIAlbum(
    val albumId: String,
    val albumName: String,
    val albumArtist: String,
    val albumCoverSmall: String,
    val albumCoverMedium: String,
    val albumCoverLarge: String,
    val albumCoverXLarge: String,
    val albumUrl: String,
    val isFav: Boolean

) : UIListItemBase(id = "UIAlbum $albumId")
