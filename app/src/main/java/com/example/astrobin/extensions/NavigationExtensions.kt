package com.example.astrobin.extensions

import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.astrobin.ui.screens.main.Routes

fun NavController.navigateTo(route: Routes<*>) {
    navigate(route.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavDestination?.isRouteSelected(route: Routes<*>): Boolean {
    return this?.hierarchy?.any { it.route == route.route } == true
}