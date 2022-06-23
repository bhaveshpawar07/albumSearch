package com.wednesday.template.repo.lastFm

import com.wednesday.template.repo.lastFm.models.albumMappedFromRemote
import com.wednesday.template.repo.lastFm.models.remoteAlbum
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class DomainAlbumMapperImplTest {

    private lateinit var domainAlbumMapperImpl : DomainAlbumMapperImpl

    @Before
    fun setup(){
        domainAlbumMapperImpl = DomainAlbumMapperImpl()
    }


    @Test
    fun `Given a list of remoteAlbum , When map is being called , Then correct album list should be returned`() : Unit =
        runTest {
            //Given
            val remoteAlbums = listOf(remoteAlbum)
            whenever(domainAlbumMapperImpl.map(remoteAlbums))
                .thenReturn(listOf(albumMappedFromRemote))
            //When

            val result = domainAlbumMapperImpl.map(remoteAlbums)
            //Then

            assertEquals(expected = listOf(albumMappedFromRemote), actual = result)

        }

}