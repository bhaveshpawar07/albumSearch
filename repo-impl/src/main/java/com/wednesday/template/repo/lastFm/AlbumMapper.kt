package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.repo.util.Mapper
import com.wednesday.template.service.lastFm.Remote.RemoteAlbum

interface AlbumMapper : Mapper<RemoteAlbum, Album>

class AlbumMapperImpl : AlbumMapper {

    override fun map(from: RemoteAlbum): Album {
        return Album(
            mbid = from.mbid,
            artist = from.artist,
            name = from.name,
            sImageSize = from.image[0].size,
            sImageText = from.image[0].text,
            mImageSize = from.image[1].size,
            mImageText = from.image[1].text,
            lImageSize = from.image[2].size,
            lImageText = from.image[2].text,
            xlImageSize = from.image[3].size,
            xlImageText = from.image[3].text,
            url = from.url
        )
    }
}
