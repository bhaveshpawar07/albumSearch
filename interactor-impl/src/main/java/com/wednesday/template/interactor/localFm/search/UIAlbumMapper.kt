package com.wednesday.template.interactor.localFm.search

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.interactor.base.Mapper
import com.wednesday.template.presentation.lastFm.UIAlbum

interface UIAlbumMapper : Mapper<Album, UIAlbum>

class UIAlbumMapperImpl : UIAlbumMapper {
    override fun map(from: Album): UIAlbum {
        return UIAlbum(
            albumId = from.mbid,
            albumName = from.name,
            albumArtist = from.artist,
            albumCoverSmall = from.sImageText,
            albumCoverMedium = from.mImageText,
            albumCoverLarge = from.lImageText,
            albumCoverXLarge = from.xlImageText
        )
    }
}
