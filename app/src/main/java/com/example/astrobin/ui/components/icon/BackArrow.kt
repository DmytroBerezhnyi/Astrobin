package com.example.astrobin.ui.components.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BackArrow(nav: NavHostController) {
    IconButton(
        modifier = Modifier
            .statusBarsPadding()
            .padding(8.dp),
        onClick = { nav.popBackStack() }
    ) {
        Icon(
            Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Preview
@Composable
private fun PreviewBackArrow() {
    val navHostController = rememberNavController()
    Box(modifier = Modifier.background(Color.Black)) {
        BackArrow(nav = navHostController)
    }
}