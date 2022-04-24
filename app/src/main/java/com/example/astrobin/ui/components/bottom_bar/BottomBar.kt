package com.example.astrobin.ui.components.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.astrobin.ui.screens.main.Routes
import com.example.astrobin.ui.theme.DarkBlue
import com.example.astrobin.ui.theme.Yellow

@Composable
fun AstrobinBottomNavigationBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    var selectedRoute by remember { mutableStateOf(Routes.Top) }

    Box(modifier = modifier) {
        BottomNavigation(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .align(Alignment.BottomCenter), backgroundColor = Color.Black
        ) {
            AstrobinBottomNavigationItem2(
                name = "TOP",
                icon = Icons.Filled.Star,
                isSelected = selectedRoute == Routes.Top
            ) {
                navHostController.navigate(Routes.Top)
                selectedRoute = Routes.Top
            }
            AstrobinBottomNavigationItem2(
                name = "PROFILE",
                icon = Icons.Filled.Person,
                isSelected = selectedRoute == Routes.Profile
            ) {
                navHostController.navigate(Routes.Profile)
                selectedRoute = Routes.Profile
            }
        }

        CenterNavItem {
            navHostController.navigate(Routes.Search)
        }
    }
}

@Composable
fun RowScope.AstrobinBottomNavigationItem2(
    name: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    BottomNavigationItem(
        icon = { Icon(icon, contentDescription = null) },
        label = { Text(name) },
        selected = isSelected,
        onClick = onClick,
        selectedContentColor = Yellow,
        unselectedContentColor = Color.White,
    )
}

@Composable
private fun BoxScope.CenterNavItem(onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .align(Alignment.BottomCenter),
        shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
        color = DarkBlue,
        elevation = 40.dp
    ) {
        Icon(
            Icons.Filled.Search,
            contentDescription = "",
            tint = DarkBlue,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 20.dp
                )
                .background(Yellow, CircleShape)
                .padding(8.dp)
                .size(30.dp)
                .clickable {
                    onClick.invoke()
                }
        )
    }
}

@Preview
@Composable
fun BottomBarPrev() {
    AstrobinBottomNavigationBar(
        modifier = Modifier,
        navHostController = rememberNavController()
    )
}