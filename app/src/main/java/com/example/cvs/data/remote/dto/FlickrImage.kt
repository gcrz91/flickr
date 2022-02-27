package com.example.cvs.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.jsoup.Jsoup

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
) {
    fun getDescription(): Description {
        val html = description
        val document = Jsoup.parse(html)
        val elements = document.select("body *")
        for (element in elements) {
            if ("img" == element.tagName()) {
                return Description(
                    element.attr("alt"),
                    element.attr("height"),
                    element.attr("width")
                )
            }
        }
        return Description()
    }
}
