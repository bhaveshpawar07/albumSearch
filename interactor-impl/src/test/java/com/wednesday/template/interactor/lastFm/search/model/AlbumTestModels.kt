package com.wednesday.template.interactor.lastFm.search.model

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.presentation.lastFm.UIAlbum

val album = Album(
    mbid = "",
    name = "",
    artist = "",
    url = "",
    sImageSize = "",
    sImageText = "",
    mImageSize = "",
    mImageText = "",
    lImageSize = "",
    lImageText = "",
    xlImageSize = "",
    xlImageText = ""
)

val uiAlbum = UIAlbum(
    albumUrl = "test",
    albumCoverXLarge = "xlarge",
    albumCoverLarge = "large",
    albumCoverMedium = "med",
    albumCoverSmall = "small",
    albumArtist = "artist",
    albumName = "name",
    isFav = true,
    albumId = "a"
)
