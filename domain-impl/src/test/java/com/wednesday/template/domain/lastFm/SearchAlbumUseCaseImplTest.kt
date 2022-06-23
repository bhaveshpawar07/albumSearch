package com.wednesday.template.domain.lastFm

import com.wednesday.template.domain.base.Result
import com.wednesday.template.domain.lastFm.models.album
import com.wednesday.template.repo.lastFm.LastFmRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class SearchAlbumUseCaseImplTest {
    private lateinit var lastFmRepository: LastFmRepository
    private lateinit var searchAlbumUseCaseImpl: SearchAlbumUseCaseImpl

    @Before
    fun setup(){
        lastFmRepository = mock()
        searchAlbumUseCaseImpl = SearchAlbumUseCaseImpl(lastFmRepository)
    }

    @Test
    fun `Given an album name , When invoke is called , Then success is returned` () : Unit =
        runTest {
            //Given
            val searchString = "Test"
            val albumList = listOf(album)
            whenever(lastFmRepository.searchAlbum(searchString))
                .thenReturn(albumList)
            //When

            val result = searchAlbumUseCaseImpl(searchString)

            //Then
            assertTrue(result is Result.Success)
            verify(lastFmRepository, times(1)).searchAlbum(same(searchString))
            verifyNoMoreInteractions(lastFmRepository)
        }

}