package com.example.astrobin.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.astrobin.components.AstrobinBottomNavigationBar
import com.example.astrobin.ui.theme.DarkBlue

@Composable
     fun Astrobin() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
        ) {
            AstrobinBottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }