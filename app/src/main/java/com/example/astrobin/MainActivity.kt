package com.example.astrobin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import coil.ImageLoader
import com.example.astrobin.api.AstrobinApi
import com.example.astrobin.extensions.makeTransparentStatusBar
import com.example.astrobin.ui.screens.main.Astrobin
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var api: AstrobinApi

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        window.makeTransparentStatusBar()
        super.onCreate(savedInstanceState)
        setContent {
            Astrobin(api, imageLoader)
        }
    }
}