package com.example.astrobin.ui.components.image

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.astrobin.api.AstroImage
import com.example.astrobin.api.provideMockAstroImage

@Composable
fun UserImageRow(image: AstroImage, nav: NavController) {
    AstroImageWithContent(modifier = Modifier.padding(horizontal = 16.dp),
        imageUrl = image.url_regular,
        onClick = {
            if (image.hash != null) {
                nav.navigate("image/${image.hash}")
            }
        }) {
        Text(
            text = image.title.orEmpty(),
            style = MaterialTheme.typography.h1,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun UserImageRowPreview() {
    val navController = rememberNavController()
    UserImageRow(image = provideMockAstroImage(), nav = navController)
}