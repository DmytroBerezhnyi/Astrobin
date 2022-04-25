package com.example.astrobin.ui.screens.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.astrobin.ui.screens.SearchAstroPostScreen
import com.example.astrobin.ui.screens.post_detail.PostDetailScreen
import com.example.astrobin.ui.screens.profile.ProfileScreen

@Composable
fun AstroNavHost(
    navController: NavHostController,
    startDestination: Routes<*> = Routes.Top,
    paddingValues: PaddingValues
) = NavHost(
    navController = navController,
    startDestination = startDestination.route
) {
    composable(Routes.Top) {
        MainScreen(padding = paddingValues, nav = navController)
    }
    composable(Routes.Search) {
        SearchAstroPostScreen(paddingValues = paddingValues, navController = navController)
    }
    composable(Routes.Profile) {
        ProfileScreen(paddingValues = paddingValues, navController = navController)
    }
    composable(Routes.AstroPost) { entry ->
        PostDetailScreen(
            hash = entry.getString("hash"),
            padding = paddingValues,
            nav = navController
        )
    }
}

private fun NavGraphBuilder.composable(
    route: Routes<*>,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = route.route,
        arguments = route.arguments,
        deepLinks = emptyList(),
        content = content
    )
}