package com.example.astrobin.di

import androidx.compose.runtime.staticCompositionLocalOf
import com.example.astrobin.api.AstrobinApi

val LocalAstrobinApi = staticCompositionLocalOf<AstrobinApi> {
    error("No Astrobin API was provided, but it should have been")
}