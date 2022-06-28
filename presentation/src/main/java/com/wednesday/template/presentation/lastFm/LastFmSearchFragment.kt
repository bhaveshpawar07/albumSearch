package com.wednesday.template.presentation.lastFm

import androidx.core.widget.addTextChangedListener
import com.wednesday.template.navigation.search.SearchNavigator
import com.wednesday.template.presentation.R
import com.wednesday.template.presentation.base.effect.Effect
import com.wednesday.template.presentation.base.fragment.BindingProvider
import com.wednesday.template.presentation.base.fragment.MainFragment
import com.wednesday.template.presentation.base.list.ListComponent
import com.wednesday.template.presentation.base.snackbar.SnackbarComponent
import com.wednesday.template.presentation.base.toolbar.ToolbarComponent
import com.wednesday.template.presentation.lastFm.list.UIAlbumListRenderer
import com.wednesday.template.resources.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LastFmSearchFragment : MainFragment<FragmentSearchBinding,
    LastFmSearchScreen,
    LastFmSearchScreenState,
    SearchNavigator,
    LastFmSearchViewModel>() {

    override val toolbarComponent: ToolbarComponent = ToolbarComponent(this, onBackClicked = {
        viewModel.onIntent(LastFmSearchScreenIntent.Back)
    })

    override val viewModel: LastFmSearchViewModel by viewModel()

    override val navigator: SearchNavigator by navigator()

    override val bindingProvider: BindingProvider<FragmentSearchBinding> =
        FragmentSearchBinding::inflate

    private val listComponent by component {
        ListComponent(listViewModel = viewModel, recyclerViewId = R.id.searchRecyclerView) {
            addRenderer(UIAlbumListRenderer())
        }
    }

    override fun onState(screenState: LastFmSearchScreenState) {
        super.onState(screenState)
        listComponent.setData(screenState.searchList)
    }

    override fun onEffect(effect: Effect) {
       unhandledEffect(effect)
    }

    override fun onViewCreated(binding: FragmentSearchBinding) {
        super.onViewCreated(binding)

        addTextListener(binding)
    }

    private fun addTextListener(binding: FragmentSearchBinding) = with(binding) {

        searchEditText.addTextChangedListener {
            it?.let { viewModel.onIntent(LastFmSearchScreenIntent.SearchAlbums(it.toString())) }
        }
    }
}
