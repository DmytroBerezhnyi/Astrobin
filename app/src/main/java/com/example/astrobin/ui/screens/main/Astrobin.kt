package com.example.astrobin.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.LocalImageLoader
import com.example.astrobin.api.AstrobinApi
import com.example.astrobin.di.LocalAstrobinApi
import com.example.astrobin.ui.components.bottom_bar.AstrobinBottomNavigationBar
import com.example.astrobin.ui.components.icon.BackArrow
import com.example.astrobin.ui.components.window.AstroAppWindow
import com.example.astrobin.ui.theme.AstrobinTheme

@Composable
fun Astrobin(api: AstrobinApi, imageLoader: ImageLoader) {
    CompositionLocalProvider(
        LocalAstrobinApi provides api,
        LocalImageLoader provides imageLoader
    ) {
        val navHostController = rememberNavController()
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()

        AstrobinTheme {
            AstroAppWindow(
                modifier = Modifier
                    .fillMaxSize()
                    .navigationBarsPadding(),
                top = {
                    if (navBackStackEntry != null && navHostController.previousBackStackEntry != null) {
                        BackArrow(navHostController)
                    }
                },
                bottom = { AstrobinBottomNavigationBar() }
            ) {
                AstroNavHost(navController = navHostController, paddingValues = it)
            }
        }
    }
}