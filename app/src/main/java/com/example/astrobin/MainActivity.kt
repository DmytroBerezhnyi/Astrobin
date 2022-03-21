package com.example.astrobin

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.astrobin.screens.Astrobin
import com.example.astrobin.ui.theme.AstrobinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.makeTransparentStatusBar()
        super.onCreate(savedInstanceState)
        setContent {
            AstrobinTheme {
                Astrobin()
            }
        }
    }
}

fun Window.makeTransparentStatusBar() {
    WindowCompat.setDecorFitsSystemWindows(this, false)
    statusBarColor = android.graphics.Color.TRANSPARENT
    navigationBarColor = android.graphics.Color.BLACK
}