package com.example.astrobin.api

import com.squareup.moshi.Json

data class TopPick(
    @field:Json(name = "date") val date: String,
    @field:Json(name = "image") val image: String,
    @field:Json(name = "resource_uri") val resource_uri: String
) {
    val hash: String get() = image.substringAfterLast('/')
    val url_regular: String get() = imageUrl(hash, "regular")
    val url_thumb: String get() = imageUrl(hash, "thumb")
    val url_real: String get() = imageUrl(hash, "real")
    val url_gallery: String get() = imageUrl(hash, "gallery")
    val url_hd: String get() = imageUrl(hash, "hd")

    private fun imageUrl(hash: String, type: String): String {
        return "https://www.astrobin.com/$hash/0/rawthumb/$type/"
    }
}

fun provideMockTopPick(): TopPick {
    return TopPick(
        date = "",
        image = "",
        resource_uri = ""
    )
}