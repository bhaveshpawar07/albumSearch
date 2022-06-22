package com.wednesday.template.service.lastFm.Remote

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class RemoteAlbum(
    @SerialName("artist")
    val artist: String,
    @SerialName("image")
    val image: List<Image>,
    @SerialName("mbid")
    val mbid: String,
    @SerialName("name")
    val name: String,
    @SerialName("streamable")
    val streamable: String,
    @SerialName("url")
    val url: String
)
