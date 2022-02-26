package com.example.cvs.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrResponse(
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generation: String,
    val items: List<FlickrImage>
)