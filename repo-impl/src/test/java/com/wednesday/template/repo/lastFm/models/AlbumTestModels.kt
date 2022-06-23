package com.wednesday.template.repo.lastFm.models

import com.wednesday.template.domain.lastFm.Album

val albumMappedFromRemote = Album(
    mbid = remoteAlbum.mbid,
    name = remoteAlbum.name,
    artist = remoteAlbum.artist,
    url = remoteAlbum.url,
    sImageSize = remoteAlbum.image[0].size,
    sImageText = remoteAlbum.image[0].text,
    mImageSize = remoteAlbum.image[1].size,
    mImageText = remoteAlbum.image[1].text,
    lImageSize = remoteAlbum.image[2].size,
    lImageText = remoteAlbum.image[2].text,
    xlImageSize = remoteAlbum.image[3].size,
    xlImageText = remoteAlbum.image[3].text
)
