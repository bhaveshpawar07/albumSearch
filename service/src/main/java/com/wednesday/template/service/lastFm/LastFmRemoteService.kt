package com.wednesday.template.service.lastFm

import com.wednesday.template.service.lastFm.Remote.AlbumRes
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmRemoteService {

    @GET("2.0/?method=album.search")
    suspend fun albumSearch(
        @Query("album") albumName : String,
        @Query("format") format : String = "json",
        @Query("limit") limit : String = "3"
    ):AlbumRes

}