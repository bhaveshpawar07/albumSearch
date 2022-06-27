package com.wednesday.template.interactor.lastFm.search

import app.cash.turbine.test
import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.SearchAlbumUseCase
import com.wednesday.template.interactor.base.CoroutineContextController
import com.wednesday.template.interactor.base.InteractorTest
import com.wednesday.template.interactor.lastFm.search.model.album
import com.wednesday.template.interactor.localFm.search.SearchAlbumInteractorImpl
import com.wednesday.template.interactor.localFm.search.UIAlbumMapperImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.same
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class SearchAlbumInteractorImplTest : InteractorTest() {
    private lateinit var searchAlbumUseCase: SearchAlbumUseCase
    private lateinit var coroutineContextController: CoroutineContextController
    private lateinit var interactor: SearchAlbumInteractorImpl
    private lateinit var uiAlbumMapperImpl: UIAlbumMapperImpl

    @Before
    fun setUp() {
        searchAlbumUseCase = mock()
        coroutineContextController = coroutineDispatcherRule.coroutineContextController
        uiAlbumMapperImpl = mock()
    }

    private fun verifyNoMoreInteractions() {
        verifyNoMoreInteractions(
            searchAlbumUseCase
        )
    }

    private fun createInteractor() {
        interactor = SearchAlbumInteractorImpl(searchAlbumUseCase, coroutineContextController, uiAlbumMapperImpl)
    }

    @Test
    fun `Given no error occurs, When search called, Then it returns flow list of albums`(): Unit =
        runTest {
            // Given
            val searchTerm = "Test"
            val albumList = listOf(album)
            whenever(searchAlbumUseCase(searchTerm)).thenReturn(Result.Success(albumList))

            launchInTestScope {
                createInteractor()
                // when
                interactor.searchResultsFlow.test {
                    interactor.search(searchTerm)

                    val result = awaitItem()

                    // Then
//                    assertEquals(actual = result, expected = albumList)
                    verify(searchAlbumUseCase, times(1)).invoke(same(searchTerm))
                    verifyNoMoreInteractions()
                    cancelAndIgnoreRemainingEvents()
                }
            }
        }
}
