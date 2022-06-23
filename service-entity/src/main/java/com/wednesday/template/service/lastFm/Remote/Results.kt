package com.wednesday.template.service.lastFm.Remote

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Results(
    @SerialName("albummatches")
    val albummatches: Albummatches,
    @SerialName("@attr")
    val attr: Attr,
    @SerialName("opensearch:itemsPerPage")
    val opensearchItemsPerPage: String,
    @SerialName("opensearch:Query")
    val opensearchQuery: OpensearchQuery,
    @SerialName("opensearch:startIndex")
    val opensearchStartIndex: String,
    @SerialName("opensearch:totalResults")
    val opensearchTotalResults: String
)
