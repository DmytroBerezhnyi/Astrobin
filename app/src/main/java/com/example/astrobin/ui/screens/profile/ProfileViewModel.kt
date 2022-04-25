package com.example.astrobin.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.astrobin.api.AstrobinApi
import com.example.astrobin.api.TopPickPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(val api: AstrobinApi) : ViewModel() {

    val pager = Pager(PagingConfig(pageSize = 20)) { TopPickPagingSource(api) }
}