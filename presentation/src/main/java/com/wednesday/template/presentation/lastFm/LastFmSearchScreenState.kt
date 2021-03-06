package com.wednesday.template.presentation.lastFm

import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIToolbar
import com.wednesday.template.presentation.screen.MainScreenState
import kotlinx.parcelize.Parcelize

@Parcelize
data class LastFmSearchScreenState(
    override val toolbar: UIToolbar,
    override val showLoading: Boolean,
    var searchList: UIList
) : MainScreenState
