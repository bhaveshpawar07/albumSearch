package com.wednesday.template.interactor.localFm.search

import com.wednesday.template.domain.lastFm.Album
import com.wednesday.template.interactor.base.Mapper2
import com.wednesday.template.presentation.base.UIList

interface UIAlbumSearchMapper : Mapper2<List<Album>, List<Album>, UIList>

class UIAlbumSearchMapperImpl(private val uiAlbumMapper: UIAlbumMapper) : UIAlbumSearchMapper {
    override fun map(from1: List<Album>, from2: List<Album>): UIList {
        val uiAlbumList = from2.map {
            val isFav = from1.contains(it)
            uiAlbumMapper.map(it, isFav)
        }
        return UIList(uiAlbumList)
    }
}
