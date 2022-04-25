package com.example.astrobin.ui.screens.main

import androidx.navigation.*

interface Args
class EmptyArgs : Args

sealed class Routes<Args>(val route: String) {
    open fun getRouteValue(args: Args): String = route

    open val arguments: List<NamedNavArgument> = emptyList()
    open val deepLinks: List<NavDeepLink> = emptyList()

    object Top : Routes<EmptyArgs>(route = "top")
    object Search : Routes<EmptyArgs>(route = "search")
    object Profile : Routes<EmptyArgs>(route = "profile")

    object AstroPost : Routes<AstroPost.Params>(route = "image/{hash}") {

        override fun getRouteValue(args: Params) = "image/${args.hash}"

        override val arguments: List<NamedNavArgument> = listOf(stringArgument("hash"))

        @JvmInline
        value class Params(val hash: String) : Args
    }
}

fun stringArgument(name: String): NamedNavArgument {
    return navArgument(name) {
        type = NavType.StringType
    }
}

fun intArgument(name: String): NamedNavArgument {
    return navArgument(name) {
        type = NavType.IntType
    }
}

fun NavBackStackEntry?.getString(key: String): String {
    return this?.arguments?.getString(key).orEmpty()
}