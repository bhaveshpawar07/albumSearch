package com.wednesday.template.repo.lastFm.models

import com.wednesday.template.service.lastFm.Remote.AlbumRes
import com.wednesday.template.service.lastFm.Remote.Albummatches
import com.wednesday.template.service.lastFm.Remote.Attr
import com.wednesday.template.service.lastFm.Remote.Image
import com.wednesday.template.service.lastFm.Remote.OpensearchQuery
import com.wednesday.template.service.lastFm.Remote.RemoteAlbum
import com.wednesday.template.service.lastFm.Remote.Results
val imgSmall = Image(
    size = "sSize",
    text = "sText"
)
val imgMed = Image(
    size = "mSize",
    text = "mText"
)
val imgLarge = Image(
    size = "lSize",
    text = "lText"
)
val imgXlarge = Image(
    size = "xSize",
    text = "xText"
)

val imageList = mutableListOf<Image>(imgSmall, imgMed, imgLarge, imgXlarge)
val remoteAlbum = RemoteAlbum(
    mbid = "a",
    name = "test",
    artist = "testA",
    url = "testurl",
    image = imageList,
    streamable = "test"
)

val result = Results(
    albummatches = Albummatches(album = listOf(remoteAlbum)),
    attr = Attr(forX = ""),
    opensearchItemsPerPage = "",
    opensearchQuery = OpensearchQuery(role = "", searchTerms = "", startPage = "", text = ""),
    opensearchStartIndex = "",
    opensearchTotalResults = ""
)

val resultAlbum = AlbumRes(
    results = result
)
