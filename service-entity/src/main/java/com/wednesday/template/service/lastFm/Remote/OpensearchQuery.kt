package com.wednesday.template.service.lastFm.Remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class OpensearchQuery(
    @SerialName("role")
    val role: String,
    @SerialName("searchTerms")
    val searchTerms: String,
    @SerialName("startPage")
    val startPage: String,
    @SerialName("#text")
    val text: String
)