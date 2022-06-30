package com.wednesday.template.interactor.lastFm.search.model

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.presentation.lastFm.UIAlbum

val album = Album(
    mbid = "1",
    name = "test",
    artist = "testA",
    url = "test",
    sImageSize = "s",
    sImageText = "st",
    mImageSize = "m",
    mImageText = "mt",
    lImageSize = "l",
    lImageText = "lt",
    xlImageSize = "x",
    xlImageText = "xt"
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
