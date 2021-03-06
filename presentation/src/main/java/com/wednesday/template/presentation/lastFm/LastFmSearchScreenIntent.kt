package com.wednesday.template.presentation.lastFm

import com.wednesday.template.presentation.base.intent.Intent

sealed interface LastFmSearchScreenIntent : Intent {
    data class SearchAlbums(
        val album: String
    ) : LastFmSearchScreenIntent

    data class ToggleFav(
        val album: UIAlbum
    ) : LastFmSearchScreenIntent
    object Back : LastFmSearchScreenIntent
}
