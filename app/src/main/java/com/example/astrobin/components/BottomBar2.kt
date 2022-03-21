package com.example.astrobin.components

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
fun RowScope.AstrobinBottomNavigationItem(
   // route: String,
    name: String,
    icon: ImageVector,
) {
    BottomNavigationItem(
        icon = { Icon(icon, contentDescription = null) },
        label = { Text(name) },
        selected = true == true,
        onClick = {
        },
        selectedContentColor = Yellow,
        unselectedContentColor = Color.White,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun AstrobinBottomNav() {
    Box {
        BottomNavigation(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                .align(Alignment.BottomCenter),
            backgroundColor = Color.Black,
        ) {
            AstrobinBottomNavigationItem(
                //route = Routes.Top,
                name = "TOP",
                icon = Icons.Filled.Star
            )

            Spacer(Modifier.width(48.dp))

            AstrobinBottomNavigationItem(
                //route = Routes.Profile,
                name = "PROFILE",
                icon = Icons.Filled.Person
            )
        }
        Surface(
            modifier = Modifier.align(Alignment.BottomCenter),
            elevation = 40.dp,
            shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
            color = DarkBlue,
            contentColor = Color.White,
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Search,
                contentDescription = null,
                tint = DarkBlue,
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 16.dp,
                        bottom = 20.dp
                    )
                    .background(Yellow, CircleShape)
                    .padding(8.dp)
                    .size(30.dp)
            )
        }
    }
}