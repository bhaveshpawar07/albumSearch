package com.wednesday.template.domain.lastFm

data class Album(
    val mbid: String,
    val name: String,
    val artist: String,
    val url: String,
    val sImageSize: String,
    val sImageText: String,
    val mImageSize: String,
    val mImageText: String,
    val lImageSize: String,
    val lImageText: String,
    val xlImageSize: String,
    val xlImageText: String
)
