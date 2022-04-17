package com.example.astrobin.ui.screens.main

import androidx.lifecycle.ViewModel
import com.example.astrobin.api.AstrobinApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AstroPostsViewModel @Inject constructor(val api: AstrobinApi) : ViewModel() {
}