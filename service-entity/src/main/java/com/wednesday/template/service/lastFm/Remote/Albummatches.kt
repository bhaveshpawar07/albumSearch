package com.wednesday.template.service.lastFm.Remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Albummatches(
    @SerialName("album")
    val album: List<Album>
)