package com.example.astrobin.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
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

private val imageForegroundGradient = Brush.linearGradient(
    0.5f to Color.Transparent,
    1.0f to Color.Black,
    start = Offset.Zero,
    end = Offset(0f, Float.POSITIVE_INFINITY)
)

private val imageRoundedCornerShape = RoundedCornerShape(8.dp)

private val imageModifier = Modifier
    .fillMaxWidth()
    .aspectRatio(16f / 9f)
    .clip(imageRoundedCornerShape)
    .background(Color.Black)
    .foreground(imageForegroundGradient)

@Composable
fun AstroImage(
    imageUrl: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "",
        contentScale = ContentScale.FillWidth,
        // Bug here if I don't specify a size, I want fillWidth(). :(
        modifier = modifier
            .then(imageModifier)
            .clickable(onClick = onClick)
    )
}

@Preview
@Composable
fun ImagePreview() {
    AstroImage(
        imageUrl = "https://www.astrobin.com/nlw5b0/0/rawthumb/real/",
        onClick = {},
    )
}