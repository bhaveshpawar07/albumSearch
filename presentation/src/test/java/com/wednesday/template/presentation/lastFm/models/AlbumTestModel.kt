package com.wednesday.template.presentation.lastFm.models

import com.wednesday.template.presentation.lastFm.UIAlbum

val album = UIAlbum(
    albumUrl = "test",
    albumCoverXLarge = "xlarge",
    albumCoverLarge = "large",
    albumCoverMedium = "med",
    albumCoverSmall = "small",
    albumArtist = "artist",
    albumName = "name",
    isFav = false,
    albumId = "a"
)

val favAlbum = UIAlbum(
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
