package com.example.astrobin.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface AstrobinApi {
    @GET("userprofile/{id}/")
    suspend fun user(@Path("id") id: Int): AstroUser

    @GET("userprofile/")
    suspend fun user(@Query("username") username: String): ListResponse<AstroUser>

    @GET("image/{hash}/")
    suspend fun image(@Path("hash") hash: String): AstroImage

    @GET("image/")
    suspend fun imageSearch(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @QueryMap params: Map<String, String>
    ): ListResponse<AstroImage>

    @GET("toppick/")
    suspend fun topPicks(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ListResponse<TopPick>

    @GET("toppicknominations/")
    suspend fun topPickNominations(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ListResponse<TopPick>

    @GET("imageoftheday/")
    suspend fun imageOfTheDay(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ListResponse<TopPick>
}