package com.example.astrobin.extensions

import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination

fun NavController.navigateTo(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavDestination?.isRouteSelected(route: String): Boolean {
    return this?.hierarchy?.any { it.route == route } == true
}