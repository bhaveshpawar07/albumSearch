package com.wednesday.template.service.lastFm.Remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Image(
    @SerialName("size")
    val size: String,
    @SerialName("#text")
    val text: String
)