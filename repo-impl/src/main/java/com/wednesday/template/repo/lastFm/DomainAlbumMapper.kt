package com.wednesday.template.repo.lastFm

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.repo.util.Mapper
import com.wednesday.template.service.lastFm.Local.LocalAlbumDetails
import com.wednesday.template.service.lastFm.Remote.RemoteAlbum

interface DomainAlbumMapper : Mapper<RemoteAlbum, Album>{
   fun mapLocalAlbum(from: LocalAlbumDetails):Album
   fun mapLocalAlbum(from: List<LocalAlbumDetails>):List<Album>  = from.map(::mapLocalAlbum)
}
class DomainAlbumMapperImpl : DomainAlbumMapper {

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

    override fun mapLocalAlbum(from: LocalAlbumDetails): Album {
        return Album(
            mbid = from.id,
            artist = from.artist,
            name = from.name,
            sImageSize = "small",
            sImageText = from.sImageUrl,
            mImageSize = "medium",
            mImageText = from.mImageUrl,
            lImageSize = "large",
            lImageText = from.lImageUrl,
            xlImageSize = "extralarge",
            xlImageText = from.xlImageUrl,
            url = from.albumUrl
        )
    }
}
