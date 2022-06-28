package com.wednesday.template.service.lastFm.Local


import androidx.annotation.Keep
import kotlinx.serialization.SerialName

@Keep
data class LocalImage(
    @SerialName("#text")
    val text: String,
    val size: String
)