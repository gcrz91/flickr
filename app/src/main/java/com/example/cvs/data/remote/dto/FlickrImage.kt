package com.example.cvs.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrImage(
    val title: String,
    val link: String,
    val media: Media,
    @get:Json(name = "date_taken")
    val dateTaken: String,
    val description: String,
    val published: String,
    val author: String,
    @get:Json(name = "author_id")
    val authorId: String,
    val tags: String
)
