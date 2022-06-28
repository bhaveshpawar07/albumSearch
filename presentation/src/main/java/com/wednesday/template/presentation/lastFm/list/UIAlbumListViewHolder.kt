package com.wednesday.template.presentation.lastFm.list

import android.util.Log
import androidx.core.content.ContextCompat
import com.wednesday.template.presentation.R
import com.wednesday.template.presentation.base.intent.Intent
import com.wednesday.template.presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.template.presentation.lastFm.LastFmSearchScreenIntent
import com.wednesday.template.presentation.lastFm.UIAlbum
import com.wednesday.template.resources.databinding.CityItemListBinding
import kotlinx.coroutines.channels.Channel

class UIAlbumListViewHolder(private val binding: CityItemListBinding) : BaseViewHolder<UIAlbum>(binding) {

    override fun onSetupIntents(intentChannel: Channel<Intent>) = with(binding){
        imageViewFavourite.setOnClickListener{
            val value = LastFmSearchScreenIntent.ToggleFav(item)
            intentChannel.trySend(value)
        }
    }

    override fun onBindInternal() = binding.run {
//        cityTextViewListItem.text = item
        compareAndSet({ albumName }) {
            cityTextViewListItem.text = it
        }
        compareAndSet({ albumArtist }) {
            latitudeTextViewListItem.text = it
        }
        compareAndSet({isFav}){
            val drawable = ContextCompat.getDrawable(
                root.context,
                if(it) R.drawable.ic_favorite else R.drawable.ic_favorite_border
            )
            imageViewFavourite.setImageDrawable(drawable)
        }
    }
}
