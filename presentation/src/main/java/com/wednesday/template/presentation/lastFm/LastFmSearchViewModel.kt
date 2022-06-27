package com.wednesday.template.presentation.lastFm

import androidx.lifecycle.viewModelScope
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.navigation.search.SearchNavigator
import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIText
import com.wednesday.template.presentation.base.UIToolbar
import com.wednesday.template.presentation.base.intent.IntentHandler
import com.wednesday.template.presentation.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LastFmSearchViewModel(
    private val searchAlbumInteractor: SearchAlbumInteractor
) : BaseViewModel<LastFmSearchScreen, LastFmSearchScreenState, SearchNavigator>(), IntentHandler<LastFmSearchScreenIntent> {

    private val searchAlbumResponseMutableStateFlow: MutableStateFlow<String> = MutableStateFlow("")
    override fun getDefaultScreenState(): LastFmSearchScreenState {
        return LastFmSearchScreenState(
            toolbar = UIToolbar(
                title = UIText { block("Album Search") },
                hasBackButton = true,
                menuIcon = null
            ),
            showLoading = false,
            searchList = UIList()
        )
    }

    override fun onCreate(fromRecreate: Boolean) {
        searchAlbumInteractor.searchResultsFlow
            .onEach {
                setState {
                    copy(showLoading = false, searchList = it)
                }
//                when(it){
//                    is UIResult.Success ->{
//                        Log.e("TAG", "onCreate: "+it.data)
//                        setState {
//                            copy(showLoading = false, searchList = it.data)
//                        }
//                    }
//                    is UIResult.Error ->{
//                        Log.e("TAG", "onCreate: "+it.exception)
//                        setState {
//                            copy(showLoading = false)
//                        }
//                        setEffect(
//                            ShowSnackbarEffect(
//                                message = UIText{
//                                    block(R.string.something_went_wrong)
//                                }
//                            )
//                        )
//                    }
//                    else -> {
//                        Log.e("TAG", "onCreate: "+"Something is wrong")
//                    }
//                }
            }
            .launchIn(viewModelScope)

        searchAlbumResponseMutableStateFlow
            .debounce(500)
            .map { it.trim() }
            .onEach {
                if (it.isBlank()) {
                    setState { copy(searchList = UIList()) }
                    return@onEach
                }

                setState {
                    copy(showLoading = true)
                }
                searchAlbumInteractor.search(it)
            }
            .launchIn(viewModelScope)
    }

    override fun onIntent(intent: LastFmSearchScreenIntent) {
        when (intent) {
            is LastFmSearchScreenIntent.SearchAlbums -> {
                viewModelScope.launch {
//                    searchAlbumInteractor.search(intent.album)
                    searchAlbumResponseMutableStateFlow.value = intent.album
                }
            }
            LastFmSearchScreenIntent.Back -> navigator.back()
        }
    }
}
