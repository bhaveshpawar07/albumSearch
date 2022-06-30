package com.wednesday.template.service.lastFm.Local

import androidx.annotation.Keep
import kotlinx.serialization.SerialName

@Keep
data class LocalResults(
    @SerialName("@attr")
    val attr: LocalAttr,
    val albummatches: LocalAlbummatches,
    @SerialName("opensearch:Query")
    val opensearchQuery: LocalOpensearchQuery,
    @SerialName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String,
    @SerialName("opensearch:startIndex")
    val opensearchStartIndex: String,
    @SerialName("opensearch:totalResults")
    val opensearchTotalResults: String
)
