package com.example.astrobin.ui.components.image

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.astrobin.api.AstroImage

@Composable
fun ImageRow(image: AstroImage, nav: NavController) {
    AstroImageWithContent(
        modifier = Modifier.padding(horizontal = 16.dp),
        imageUrl = image.url_regular,
        onClick = {
            if (image.hash != null) {
                nav.navigate("image/${image.hash}")
            }
        }
    ) {
        Text(
            text = image.title ?: "",
            style = MaterialTheme.typography.h1,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp)
        )
        SmallUserRow(
            user = image.user,
            likeCount = image.likes,
            views = image.views,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}