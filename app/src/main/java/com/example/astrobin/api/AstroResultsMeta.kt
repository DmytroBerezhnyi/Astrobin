package com.example.astrobin.api

import com.squareup.moshi.Json

data class AstroResultsMeta(
  @field:Json(name="limit") val limit: Int,
  @field:Json(name="next") val next: String?,
  @field:Json(name="offset") val offset: Int,
  @field:Json(name="previous") val previous: String?,
  @field:Json(name="total_count") val total_count: Int,
)