package com.example.astrobin.ui.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Group
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.astrobin.api.AstroImage
import com.example.astrobin.ui.components.icon.IconCount
import com.example.astrobin.ui.components.image.AstroAvatar
import com.example.astrobin.ui.components.image.AstroPostItem
import com.example.astrobin.ui.theme.AstrobinTheme

@Composable
fun ProfileScreen(navController: NavController, paddingValues: PaddingValues) {
    val vm: ProfileViewModel = hiltViewModel()
    val topPicks = vm.pager.flow.collectAsLazyPagingItems()
    val loadState = topPicks.loadState

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = paddingValues
    ) {
        item {
            ProfileTop(
                photoUrl = "",
                name = "Dmytro Berezhnyi",
                hashtag = "@DmytroBerezhnyi",
                likes = 123,
                views = 345
            )
            Spacer(Modifier.height(16.dp))
        }
        items(topPicks) { astroPost ->

            val astroImage = produceState<AstroImage?>(null) {
                value = vm.api.image(astroPost!!.hash)
            }.value

            AstroPostItem(
                astroImage = astroImage,
                image = astroPost!!,
                nav = navController
            )

            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun ProfileTop(
    photoUrl: String,
    name: String,
    hashtag: String,
    likes: Int,
    views: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 16.dp)
        )
        AstroAvatar(
            modifier = Modifier.size(120.dp),
            imageUrl = photoUrl
        )
        Text(
            text = name,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = hashtag,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Row {
            IconCount(
                count = views,
                icon = Icons.Outlined.Group,
            )
            IconCount(
                count = likes,
                icon = Icons.Filled.ThumbUp,
            )
        }
    }
}

@Preview
@Composable
private fun ProfileTopPreview() {
    AstrobinTheme(darkTheme = true) {
        ProfileTop(
            photoUrl = "",
            name = "Dmytro Berezhnyi",
            hashtag = "@DmytroBerezhnyi",
            likes = 123,
            views = 345
        )
    }
}