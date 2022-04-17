package com.example.astrobin.ui.components.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.astrobin.api.AstroImage
import com.example.astrobin.api.TopPick
import com.example.astrobin.api.provideMockAstroImage
import com.example.astrobin.api.provideMockTopPick
import com.example.astrobin.ui.theme.AstrobinTheme

@Composable
fun AstroPostItem(astroImage: AstroImage? = null, image: TopPick, nav: NavController) {
    Box(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        AstroImage(
            imageUrl = image.url_regular,
            onClick = { nav.navigate("image/${image.hash}") }
        )
        if (astroImage != null) {
            Text(
                text = astroImage.title.orEmpty(),
                style = MaterialTheme.typography.h1,
                maxLines = 1,
                fontSize = 18.sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )
            SmallUserRow(
                user = astroImage.user,
                likeCount = astroImage.likes,
                views = astroImage.views,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AstroPostItemPreview() {
    AstrobinTheme {
        AstroPostItem(
            astroImage = provideMockAstroImage(),
            image = provideMockTopPick(),
            nav = rememberNavController()
        )
    }
}

@Preview
@Composable
private fun AstroPostItemDarkPreview() {
    AstrobinTheme(darkTheme = true) {
        AstroPostItem(
            astroImage = provideMockAstroImage(),
            image = provideMockTopPick(),
            nav = rememberNavController()
        )
    }
}