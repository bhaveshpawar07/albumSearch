package com.wednesday.template.service.lastFm.Local

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "album_details")
data class LocalAlbumDetails(
    @PrimaryKey
    val id: String,
    val name: String,
    val artist: String,
    val albumUrl: String,
    val sImageUrl: String,
    val mImageUrl: String,
    val lImageUrl: String,
    val xlImageUrl: String,
)