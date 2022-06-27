package com.wednesday.template.presentation.lastFm.list

import com.wednesday.template.presentation.base.intent.Intent
import com.wednesday.template.presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.template.presentation.lastFm.UIAlbum
import com.wednesday.template.resources.databinding.CityItemListBinding
import kotlinx.coroutines.channels.Channel

class UIAlbumListViewHolder(private val binding : CityItemListBinding):BaseViewHolder<UIAlbum>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) {

    }

    override fun onBindInternal() = binding.run {
//        cityTextViewListItem.text = item
        compareAndSet({albumName}){
            cityTextViewListItem.text = it
        }
        compareAndSet({albumArtist}){
            latitudeTextViewListItem.text = it
        }
    }
}