package com.example.astrobin.extensions

import android.view.Window
import androidx.core.view.WindowCompat

fun Window.makeTransparentStatusBar() {
    WindowCompat.setDecorFitsSystemWindows(this, false)
    statusBarColor = android.graphics.Color.TRANSPARENT
    navigationBarColor = android.graphics.Color.BLACK
}