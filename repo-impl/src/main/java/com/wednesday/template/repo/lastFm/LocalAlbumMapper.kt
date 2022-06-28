package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.repo.util.Mapper
import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails

interface LocalAlbumMapper : Mapper<Album, LocalAlbumDetails>

class LocalAlbumMapperImpl : LocalAlbumMapper {

    override fun map(from: Album): LocalAlbumDetails {
        return LocalAlbumDetails(
            id = from.mbid,
            artist = from.artist,
            name = from.name,
            sImageUrl = from.sImageText,
            mImageUrl = from.mImageText,
            lImageUrl = from.lImageText,
            xlImageUrl = from.xlImageText,
            albumUrl = from.url
        )
    }
}
