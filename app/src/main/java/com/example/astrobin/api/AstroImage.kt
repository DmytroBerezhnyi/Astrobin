package com.example.astrobin.api

import com.squareup.moshi.Json

data class AstroImage(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "hash") val hash: String?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "user") val user: String, // username

    // dates
    @field:Json(name = "published") val published: String,
    @field:Json(name = "updated") val updated: String,
    @field:Json(name = "uploaded") val uploaded: String,

    // astrometry
    @field:Json(name = "is_solved") val is_solved: Boolean,
    @field:Json(name = "solution_status") val solution_status: String,
    @field:Json(name = "ra") val ra: String?, // float
    @field:Json(name = "dec") val dec: String?, // Float
    @field:Json(name = "pixscale") val pixscale: String?, // Float
    @field:Json(name = "radius") val radius: String?, // float
    @field:Json(name = "orientation") val orientation: String?, // Float
    @field:Json(name = "w") val w: Int,
    @field:Json(name = "h") val h: Int,

    // images
    @field:Json(name = "url_advanced_solution") val url_advanced_solution: String?,
    @field:Json(name = "url_duckduckgo") val url_duckduckgo: String,
    @field:Json(name = "url_duckduckgo_small") val url_duckduckgo_small: String,
    @field:Json(name = "url_gallery") val url_gallery: String,
    @field:Json(name = "url_hd") val url_hd: String,
    @field:Json(name = "url_histogram") val url_histogram: String,
    @field:Json(name = "url_real") val url_real: String,
    @field:Json(name = "url_regular") val url_regular: String,
    @field:Json(name = "url_skyplot") val url_skyplot: String?,
    @field:Json(name = "url_solution") val url_solution: String?,
    @field:Json(name = "url_thumb") val url_thumb: String,

    // statistics
    @field:Json(name = "comments") val comments: Int,
    @field:Json(name = "likes") val likes: Int,
    @field:Json(name = "views") val views: Int,

    // technical card
    @field:Json(name = "imaging_cameras") val imaging_cameras: List<String>,
    @field:Json(name = "imaging_telescopes") val imaging_telescopes: List<String>,
    @field:Json(name = "data_source") val data_source: String,
    @field:Json(name = "locations") val locations: List<String>,
    @field:Json(name = "remote_source") val remote_source: String?,
    @field:Json(name = "subjects") val subjects: List<String>,

    // other
    @field:Json(name = "animated") val animated: Boolean,
    @field:Json(name = "bookmarks") val bookmarks: Int,
    @field:Json(name = "is_final") val is_final: Boolean,
    @field:Json(name = "license") val license: Int,
    @field:Json(name = "license_name") val license_name: String,
    @field:Json(name = "link") val link: String?,
    @field:Json(name = "link_to_fits") val link_to_fits: String?,
    @field:Json(name = "resource_uri") val resource_uri: String,
    @field:Json(name = "revisions") val revisions: List<String>,
) {
    val aspectRatio: Float get() = w.toFloat() / h.toFloat()
}

fun provideMockAstroImage(): AstroImage {
    return AstroImage(
        id = 0,
        hash = null,
        user = "Dmytro",
        title = "Deep Galaxy. Space Nebula. Cosmic Cluster of Stars. Outer Space Background. Stock Photo - Image of fantasy, nasa: 227957984",
        published = "null publ",
        updated = "",
        uploaded = "",
        is_solved = false,
        solution_status = "",
        ra = "",
        dec = "",
        pixscale = "",
        radius = "",
        orientation = "",
        w = 0,
        h = 0,
        url_advanced_solution = "",
        url_duckduckgo = "",
        url_duckduckgo_small = "",
        url_gallery = "",
        url_hd = "",
        url_histogram = "",
        url_real = "",
        url_regular = "https://thumbs.dreamstime.com/b/deep-galaxy-space-nebula-cosmic-cluster-stars-outer-background-some-elements-image-furnished-nasa-227957984.jpg",
        url_skyplot = "",
        url_solution = "",
        url_thumb = "",
        comments = 2,
        likes = 2002,
        views = 234,
        imaging_cameras = listOf(),
        imaging_telescopes = listOf(),
        data_source = "",
        locations = listOf(),
        remote_source = "",
        subjects = listOf(),
        animated = false,
        bookmarks = 3,
        is_final = false,
        license = 404,
        license_name = "",
        link = "",
        link_to_fits = "",
        resource_uri = "",
        revisions = listOf()
    )
}