package com.wednesday.template.presentation.lastFm

import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.navigation.search.SearchNavigator
import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIText
import com.wednesday.template.presentation.base.UIToolbar
import com.wednesday.template.presentation.base.intent.IntentHandler
import com.wednesday.template.presentation.base.viewmodel.BaseViewModel
import com.wednesday.template.presentation.weather.search.SearchScreen

class LastFmSearchViewModel(
    private val searchAlbumInteractor: SearchAlbumInteractor
) : BaseViewModel<SearchScreen, AlbumSearchScreenState, SearchNavigator>(), IntentHandler<LastFmSearchScreenIntent> {

    override fun getDefaultScreenState(): AlbumSearchScreenState {
        return AlbumSearchScreenState(
            toolbar = UIToolbar(
                title = UIText { block("Search") },
                hasBackButton = true,
                menuIcon = null
            ),
            showLoading = false,
            searchList = UIList()
        )
    }

    override fun onCreate(fromRecreate: Boolean) {

//        viewModelScope.launch {
//            searchAlbumInteractor.search("Albumname")
//        }
//
//        searchAlbumInteractor.searchResultsFlow
//            .onEach {
//                it.forEach {
//                    Log.e("LastFmSearchViewModel", "onCreate: "+it )
//                }
//
//            }
    }

    override fun onIntent(intent: LastFmSearchScreenIntent) {
        when (intent) {
            is LastFmSearchScreenIntent.SearchAlbums -> {
//                searchAlbumInteractor.search("a")
            }
        }
    }
}
