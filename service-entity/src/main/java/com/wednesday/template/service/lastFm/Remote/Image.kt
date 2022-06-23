package com.wednesday.template.service.lastFm.Remote

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Image(
    @SerialName("size")
    val size: String,
    @SerialName("#text")
    val text: String
)
