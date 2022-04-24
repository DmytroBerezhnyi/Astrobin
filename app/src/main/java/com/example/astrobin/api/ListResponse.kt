package com.example.astrobin.api

import com.squareup.moshi.Json

data class ListResponse<T>(
  @field:Json(name="meta") val meta: AstroResultsMeta,
  @field:Json(name="objects") val objects: List<T>,
)