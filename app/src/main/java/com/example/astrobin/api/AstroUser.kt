package com.example.astrobin.api

import com.squareup.moshi.Json

data class AstroUser(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "username") val username: String,
    @field:Json(name = "real_name") val real_name: String?,

    // stats
    @field:Json(name = "followers_count") val followers_count: Int,
    @field:Json(name = "following_count") val following_count: Int,
    @field:Json(name = "post_count") val post_count: Int,
    @field:Json(name = "received_likes_count") val received_likes_count: Int,
    @field:Json(name = "image_count") val image_count: Int,

    // bio
    @field:Json(name = "about") val about: String?,
    @field:Json(name = "hobbies") val hobbies: String?,
    @field:Json(name = "website") val website: String?,
    @field:Json(name = "job") val job: String?,

    @field:Json(name = "date_joined") val date_joined: String,
    @field:Json(name = "language") val language: String,
    @field:Json(name = "avatar") val avatar: String?,
    @field:Json(name = "resource_uri") val resource_uri: String,
) {
    val display_name: String get() = real_name ?: "@$username"
    val url_avatar: String
        get() {
            // since we are faking some avatar data temporarily, i am special casing my avatar for demo purposes
            if (id == 93620) return "https://cdn.astrobin.com/images/avatars/2/7/93669/resized/194/65616d9d63bbe81142157196d34396f4.png"
            return avatar ?: avatarUrl(username)
        }
}

fun avatarUrl(username: String): String {
    return "https://i.pravatar.cc/300?u=$username"
}