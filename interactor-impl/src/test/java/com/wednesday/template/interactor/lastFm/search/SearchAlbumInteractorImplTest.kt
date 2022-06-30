package com.wednesday.template.interactor.lastFm.search

import app.cash.turbine.test
import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.GetFavouriteAlbumFlowUseCase
import com.wednesday.template.domain.lastFm.SearchAlbumUseCase
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.base.InteractorTest
import com.wednesday.template.interactor.lastFm.search.model.album
import com.wednesday.template.interactor.lastFm.search.model.uiAlbum
import com.wednesday.template.interactor.localFm.search.SearchAlbumInteractorImpl
import com.wednesday.template.interactor.localFm.search.UIAlbumMapper
import com.wednesday.template.interactor.localFm.search.UIAlbumSearchMapper
import com.wednesday.template.presentation.base.UIList
import com.wednesday.template.presentation.base.UIResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.same
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class SearchAlbumInteractorImplTest : InteractorTest() {
    private lateinit var searchAlbumUseCase: SearchAlbumUseCase
    private lateinit var coroutineContextController: CoroutineContextController
    private lateinit var interactor: SearchAlbumInteractorImpl
    private lateinit var uiAlbumMapperImpl: UIAlbumMapper
    private lateinit var uiAlbumSearchMapper: UIAlbumSearchMapper
    private lateinit var favouriteAlbumFlowUseCase: GetFavouriteAlbumFlowUseCase

    @Before
    fun setUp() {
        searchAlbumUseCase = mock()
        coroutineContextController = coroutineDispatcherRule.coroutineContextController
        uiAlbumMapperImpl = mock()
        uiAlbumSearchMapper = mock()
        favouriteAlbumFlowUseCase = mock()
    }

    private fun verifyNoMoreInteractions() {
        verifyNoMoreInteractions(
            searchAlbumUseCase
        )
    }

    private fun createInteractor() {
        interactor = SearchAlbumInteractorImpl(searchAlbumUseCase, coroutineContextController, uiAlbumSearchMapper, favouriteAlbumFlowUseCase)
    }

    @Test
    fun `Given no error occurs, When search called, Then it returns flow list of albums`(): Unit =
        runTest {
            // Given
            val searchTerm = "Test"
            val albumList = listOf(album)
            val uiList = UIList(uiAlbum)
            whenever(searchAlbumUseCase(searchTerm)).thenReturn(Result.Success(albumList))
            whenever(favouriteAlbumFlowUseCase(Unit)).thenReturn(flowOf(Result.Success(albumList)))
            whenever(uiAlbumSearchMapper.map(any(), any())).thenReturn(uiList)

            launchInTestScope {
                createInteractor()
                // when
                interactor.searchResultsFlow.test {
                    interactor.search(searchTerm)

                    val result = awaitItem()

                    // Then
                    assertTrue(result is UIResult.Success)
                    assertEquals(actual = result.data, expected = uiList)
                    verify(searchAlbumUseCase, times(1)).invoke(same(searchTerm))
                    verifyNoMoreInteractions()
                    cancelAndIgnoreRemainingEvents()
                }
            }
        }
}
