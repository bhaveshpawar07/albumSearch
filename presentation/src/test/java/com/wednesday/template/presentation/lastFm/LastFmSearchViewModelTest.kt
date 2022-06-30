package com.wednesday.template.presentation.lastFm

import com.wednesday.template.interactor.localFm.FavouriteAlbumInteractor
import com.wednesday.template.interactor.localFm.SearchAlbumInteractor
import com.wednesday.template.navigation.search.SearchNavigator
import com.wednesday.template.presentation.base.BaseViewModelTest
import com.wednesday.template.presentation.base.UIResult
import com.wednesday.template.presentation.lastFm.models.album
import com.wednesday.template.presentation.lastFm.models.favAlbum
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LastFmSearchViewModelTest : BaseViewModelTest() {

    private lateinit var interactor: FavouriteAlbumInteractor
    private lateinit var searchInteractor: SearchAlbumInteractor
    private lateinit var navigator: SearchNavigator
    private lateinit var viewModel: LastFmSearchViewModel
    private lateinit var searchIntent: LastFmSearchScreenIntent
    override fun before() {
        interactor = mock()
        searchInteractor = mock()
        navigator = mock()
        viewModel = LastFmSearchViewModel(searchInteractor, interactor)
    }

    override fun after() = Unit

    @Test
    fun `Given _, When onCreate , Then searchResultsFlow was called`(): Unit =
        runTest {
            // Given
            val fromRecreate = false
            whenever(searchInteractor.searchResultsFlow)
                .thenReturn(flowOf())

            // When
            viewModel.onCreate(fromRecreate)

            // Then
            advanceUntilIdle()
            verify(searchInteractor, times(1)).searchResultsFlow
        }

    @Test
    fun `Given _, When searchAlbum intent , Then searchAlbumResponseMutableStateFlow gets a value and  searchResultsFlow is called`(): Unit =
        runTest {
            // Given
            val searchTerm = "test"
            whenever(searchInteractor.search(searchTerm))
                .thenReturn(Unit)

            // When
            viewModel.onCreate(false)
            viewModel.onIntent(LastFmSearchScreenIntent.SearchAlbums(searchTerm))

            // Then
            advanceUntilIdle()
            verify(searchInteractor, times(1)).search(searchTerm)
        }

    @Test
    fun `Given _, When searchAlbum intent with mulitple inputs , Then searchAlbumResponseMutableStateFlow gets a value and  searchResultsFlow is called for the last input received`(): Unit =
        runTest {
            // Given
            val searchTerm = "test"
            val searchTerm1 = "test1"
            val searchTerm2 = "test2"
            whenever(searchInteractor.search(searchTerm))
                .thenReturn(Unit)

            // When
            viewModel.onCreate(false)
            viewModel.onIntent(LastFmSearchScreenIntent.SearchAlbums(searchTerm))
            viewModel.onIntent(LastFmSearchScreenIntent.SearchAlbums(searchTerm1))
            viewModel.onIntent(LastFmSearchScreenIntent.SearchAlbums(searchTerm2))

            // Then
            advanceUntilIdle()
            verify(searchInteractor, times(1)).search(searchTerm2)
        }

    @Test
    fun `Given _, When toggleFav intent with new album , Then album is added to favourite`(): Unit =
        runTest {
            // Given
            whenever(interactor.setFavouriteAlbum(album))
                .thenReturn(UIResult.Success(Unit))

            // When
            viewModel.onIntent(LastFmSearchScreenIntent.ToggleFav(album))

            // Then
            advanceUntilIdle()
            verify(interactor, times(1)).setFavouriteAlbum(album)
        }

    @Test
    fun `Given _, When toggleFav intent with fav album , Then album is removed from favourite`(): Unit =
        runTest {
            // Given
            whenever(interactor.removeFavouriteAlbum(favAlbum))
                .thenReturn(UIResult.Success(Unit))

            // When
            viewModel.onIntent(LastFmSearchScreenIntent.ToggleFav(favAlbum))

            // Then
            advanceUntilIdle()
            verify(interactor, times(1)).removeFavouriteAlbum(favAlbum)
        }
}
