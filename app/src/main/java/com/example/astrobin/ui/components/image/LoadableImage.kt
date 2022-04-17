package com.example.astrobin.ui.components.image

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun LoadableImage(
    painter: ImagePainter,
    placeholder: @Composable () -> Unit,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    Box(modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
            modifier = Modifier.matchParentSize()
        )

        AnimatedVisibility(
            visible = when (painter.state) {
                is ImagePainter.State.Empty, is ImagePainter.State.Success -> false
                is ImagePainter.State.Loading, is ImagePainter.State.Error -> true
            },
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            placeholder()
        }
    }
}