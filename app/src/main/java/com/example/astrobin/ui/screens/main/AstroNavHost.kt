package com.example.astrobin.ui.screens.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.astrobin.ui.screens.top.TopScreen

@Composable
fun AstroNavHost(
    navController: NavHostController,
    startDestination: String = "top",
    paddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Routes.Top) {
            TopScreen(paddingValues, navController)
        }
        /*composable("home") {
//            UserScreen(93620, padding, nav)
            ImageScreen("v7v9fq", padding, nav)
//            TopScreen(padding = padding, nav = nav)
//            SearchScreen(nav = nav, entry = it, padding = padding)
        }
        composable("profile") {
            // NOTE: hardcoded to leland's user id for demo purposes
            UserScreen(93620, padding, nav)
        }
        composable(
            "user/{id}",
            listOf(navArgument("id") { type = NavType.IntType })
        ) {
            UserScreen(it.arguments?.getInt("id")!!, padding, nav)
        }
        composable(
            "image/{hash}",
            listOf(navArgument("hash") { type = NavType.StringType })
        ) {
            ImageScreen(it.arguments!!.getString("hash")!!, padding, nav)
        }
        composable(
            "search?q={q}",
            listOf(navArgument("q") { type = NavType.StringType })
        ) {
            SearchScreen(nav = nav, entry = it, padding)
        }
        composable(
            "fullscreen?hd={hd}&solution={solution}&w={w}&h={h}",
            listOf(
                navArgument("hd") { type = NavType.StringType },
                navArgument("solution") { type = NavType.StringType; nullable = true },
                navArgument("w") { type = NavType.IntType },
                navArgument("h") { type = NavType.IntType },
            )
        ) {
            FullScreen(
                it.arguments!!.getString("hd")!!,
                it.arguments?.getString("solution"),
                it.arguments!!.getInt("w"),
                it.arguments!!.getInt("h"),
                padding,
                nav
            )
        }
        composable(Routes.Search) {
            SearchScreen(nav, entry = it, padding)
        }*/
    }
}

object Routes {
    val Top = "top"
    val Latest = "latest"
    val Search = "search"
    val Profile = "profile"
    fun User(id: Int) = "user/$id"
    fun Image(hash: String) = "image/$hash"
}