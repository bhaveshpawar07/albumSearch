package com.wednesday.template.service.lastFm.Local


import androidx.annotation.Keep

@Keep
data class LocalOpensearchQuery(
    val text: String,
    val role: String,
    val searchTerms: String,
    val startPage: String
)