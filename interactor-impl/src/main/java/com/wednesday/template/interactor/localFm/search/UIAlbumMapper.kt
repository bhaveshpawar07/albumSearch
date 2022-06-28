package com.wednesday.template.interactor.localFm.search

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.interactor.base.Mapper
import com.wednesday.template.interactor.base.Mapper2
import com.wednesday.template.presentation.lastFm.UIAlbum

interface UIAlbumMapper : Mapper2<Album,Boolean, UIAlbum>{
    fun mapToAlbum(from: UIAlbum):Album
    fun mapFavAlbum(from: Album):UIAlbum
}

class UIAlbumMapperImpl : UIAlbumMapper {

    override fun mapToAlbum(from: UIAlbum): Album {
        return Album(
            mbid = from.albumId,
            name = from.albumName,
            artist = from.albumArtist,
            url = from.albumUrl,
            sImageSize = "small",
            sImageText = from.albumCoverSmall,
            mImageSize = "medium",
            mImageText = from.albumCoverMedium,
            lImageSize = "large",
            lImageText = from.albumCoverLarge,
            xlImageSize = "extralarge",
            xlImageText = from.albumCoverXLarge
        )
    }

    override fun map(from1: Album, from2:Boolean): UIAlbum {
        return UIAlbum(
            albumId = from1.mbid,
            albumName = from1.name,
            albumArtist = from1.artist,
            albumCoverSmall = from1.sImageText,
            albumCoverMedium = from1.mImageText,
            albumCoverLarge = from1.lImageText,
            albumCoverXLarge = from1.xlImageText,
            albumUrl = from1.url,
            isFav = from2
        )
    }

    override fun mapFavAlbum(from: Album): UIAlbum {
        return UIAlbum(
            albumId = from.mbid,
            albumName = from.name,
            albumArtist = from.artist,
            albumCoverSmall = from.sImageText,
            albumCoverMedium = from.mImageText,
            albumCoverLarge = from.lImageText,
            albumCoverXLarge = from.xlImageText,
            albumUrl = from.url,
            isFav = true
        )
    }

}
