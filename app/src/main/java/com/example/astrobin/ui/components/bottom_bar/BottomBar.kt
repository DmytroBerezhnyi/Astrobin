package com.example.astrobin.ui.components.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.astrobin.ui.theme.DarkBlue
import com.example.astrobin.ui.theme.Yellow

@Composable
fun AstrobinBottomNavigationBar(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        BottomNavigation(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .align(Alignment.BottomCenter), backgroundColor = Color.Black
        ) {
            AstrobinBottomNavigationItem2("TOP", Icons.Filled.Star)
            AstrobinBottomNavigationItem2("PROFILE", Icons.Filled.Person)
        }

        CenterNavItem()
    }
}

@Composable
fun RowScope.AstrobinBottomNavigationItem2(
    name: String,
    icon: ImageVector,
) {
    BottomNavigationItem(
        icon = { Icon(icon, contentDescription = null) },
        label = { Text(name) },
        selected = true == true,
        onClick = {},
        selectedContentColor = Yellow,
        unselectedContentColor = Color.White,
    )
}

@Composable
private fun BoxScope.CenterNavItem() {
    Surface(
        modifier = Modifier.align(Alignment.BottomCenter),
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
        )
    }
}

@Preview
@Composable
fun BottomBarPrev() {
    Box {
        AstrobinBottomNavigationBar(modifier = Modifier)
    }
}