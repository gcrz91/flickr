package com.example.cvs.data.remote.service

import com.example.cvs.data.remote.dto.FlickrResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {

    @GET("services/feeds/photos_public.gne")
    suspend fun getFlickrResponse(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallBack: Int = 1,
        @Query("tags") tags: String
    ): Response<FlickrResponse>
}