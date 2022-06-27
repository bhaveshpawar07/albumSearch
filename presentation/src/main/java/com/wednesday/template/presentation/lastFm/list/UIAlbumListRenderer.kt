package com.wednesday.template.presentation.lastFm.list

import android.view.ViewGroup
import com.wednesday.template.presentation.base.list.renderer.ListItemRenderer
import com.wednesday.template.presentation.base.list.viewholder.BaseViewHolder
import com.wednesday.template.presentation.lastFm.UIAlbum
import com.wednesday.template.resources.databinding.CityItemListBinding

class UIAlbumListRenderer: ListItemRenderer<UIAlbum>(){
    override fun getViewHolder(viewGroup: ViewGroup): BaseViewHolder<UIAlbum> {
        return UIAlbumListViewHolder(
            binding = viewGroup bind CityItemListBinding::inflate
        )
    }

}