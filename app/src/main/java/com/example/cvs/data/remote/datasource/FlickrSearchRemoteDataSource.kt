package com.example.cvs.data.remote.datasource

import com.example.cvs.data.remote.dto.FlickrResponse
import com.example.cvs.data.remote.service.FlickrService
import retrofit2.Response
import javax.inject.Inject

class FlickrSearchRemoteDataSource @Inject constructor(
    private val flickrService: FlickrService
) {

    suspend fun getFlickrResponse(tags: String): Response<FlickrResponse> {
        return flickrService.getFlickrResponse(tags = tags)
    }
}