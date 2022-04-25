package com.example.astrobin.ui.components.image

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.astrobin.extensions.foreground
import com.example.astrobin.ui.components.loading.LoadingIndicator
import com.example.astrobin.ui.theme.AstrobinTheme

private val imageForegroundGradient = Brush.linearGradient(
    0.5f to Color.Transparent,
    1.0f to Color.Black,
    start = Offset.Zero,
    end = Offset(0f, Float.POSITIVE_INFINITY)
)

@Composable
fun AstroImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    onClick: () -> Unit = {},
    placeholder: @Composable () -> Unit = { DefaultPlaceholder() },
) {
    LoadableImage(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "",
        contentScale = ContentScale.FillWidth, // Bug here if I don't specify a size, I want fillWidth(). :(
        placeholder = placeholder,
        modifier = modifier
            .then(
                Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colors.primaryVariant)
                    .foreground(imageForegroundGradient)
            )
            .clickable(onClick = onClick)
    )
}

@Composable
private fun DefaultPlaceholder() {
    Box(modifier = Modifier.fillMaxSize()) {
        LoadingIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
private fun ImagePrevPreview() {
    AstrobinTheme {
        AstroImage(
            imageUrl = "https://www.astrobin.com/nlw5b0/0/rawthumb/real/",
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun ImagePrevDarkPreview() {
    AstrobinTheme(darkTheme = true) {
        AstroImage(
            imageUrl = "https://www.astrobin.com/nlw5b0/0/rawthumb/real/",
            onClick = {},
        )
    }
}