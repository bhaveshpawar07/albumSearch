package com.wednesday.template.repo.lastFm

import com.wednesday.template.repo.lastFm.models.albumMappedFromRemote
import com.wednesday.template.repo.lastFm.models.remoteAlbum
import com.wednesday.template.repo.lastFm.models.resultAlbum
import com.wednesday.template.service.lastFm.LastFmRemoteService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalCoroutinesApi::class)
@ExperimentalTime
class LastFmRepositoryImplTest {

   private lateinit var lastFmRemoteService: LastFmRemoteService
   private lateinit var domainAlbumMapper: DomainAlbumMapper
   private lateinit var lastFmRepositoryImpl: LastFmRepositoryImpl

    @Before
    fun setUp() {
       lastFmRemoteService = mock()
       domainAlbumMapper = mock()

       lastFmRepositoryImpl = LastFmRepositoryImpl(lastFmRemoteService,domainAlbumMapper)
    }

    private fun verifyNoMoreInteractions(){
        verifyNoMoreInteractions(
            lastFmRemoteService,
            domainAlbumMapper
        )
    }
   @Test
    fun `Given a search string, When searchAlbum is called, Then list of album is returned`():Unit =
       runTest {
           //Given
           val searchTerm = "Test"
           val resAlbum = resultAlbum
           whenever(lastFmRemoteService.albumSearch(searchTerm))
               .thenReturn(resAlbum)
           whenever(domainAlbumMapper.map(same(resAlbum.results.albummatches.album)))
               .thenReturn(listOf(albumMappedFromRemote))
           //When
           val result = lastFmRepositoryImpl.searchAlbum(searchTerm)
           //Then
           assertEquals(expected = listOf(albumMappedFromRemote), actual = result)
           verify(lastFmRemoteService, times(1)).albumSearch(searchTerm)
           verify(domainAlbumMapper, times(1)).map(same(resAlbum.results.albummatches.album))
           verifyNoMoreInteractions()

       }



}