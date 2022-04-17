package com.example.astrobin.ui.screens.top

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.astrobin.api.AstroImage
import com.example.astrobin.api.TopPickPagingSource
import com.example.astrobin.di.LocalAstrobinApi
import com.example.astrobin.ui.components.image.AstroPostItem
import com.example.astrobin.ui.components.loading.LoadingIndicator
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun MainScreen(padding: PaddingValues, nav: NavController) {
    val api = LocalAstrobinApi.current
    val pager = remember { Pager(PagingConfig(pageSize = 20)) { TopPickPagingSource(api) } }
    val topPicks = pager.flow.collectAsLazyPagingItems()
    val loadState = topPicks.loadState
    LazyColumn(Modifier.fillMaxSize(), contentPadding = padding) {
        item { Spacer(Modifier.statusBarsPadding()) }
        item {
            Text(
                text = "Top Picks",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
            )
        }
        items(topPicks) {

            val astroImage = produceState<AstroImage?>(null) {
                value = api.image(it!!.hash)
            }.value

            AstroPostItem(
                astroImage = astroImage,
                image = it!!,
                nav = nav
            )
            Spacer(Modifier.height(8.dp))
        }
        when {
            loadState.refresh is LoadState.Loading -> {
                item { LoadingIndicator(Modifier.fillParentMaxSize()) }
            }
            loadState.append is LoadState.Loading -> {
                item { LoadingIndicator(Modifier.fillMaxWidth()) }
            }
            loadState.refresh is LoadState.Error -> {
                val e = loadState.refresh as LoadState.Error
                item {
                    // TODO: retry?
                    Text(
                        text = e.error.localizedMessage!!,
                        modifier = Modifier.fillParentMaxSize(),
                    )
                }
            }
            loadState.append is LoadState.Error -> {
                val e = loadState.append as LoadState.Error
                item {
                    // TODO: retry?
                    Text(e.error.localizedMessage!!)
                }
            }
        }
    }
}