package com.wednesday.template.service.lastFm.Local

import androidx.annotation.Keep

@Keep
data class LocalAlbum(
    val artist: String,
    val image: List<LocalImage>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)
