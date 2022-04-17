package com.example.astrobin.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.astrobin.api.AstroUser
import com.example.astrobin.ui.theme.Yellow

@Composable
fun AstroAvatar(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "",
        modifier = Modifier
            .border(2.dp, Yellow, CircleShape)
            .padding(2.dp)
            .clip(CircleShape)
            .background(Color.Black)
            .size(34.dp)
    )
}

@Composable
fun AstroAvatar(user: AstroUser) {
    AstroAvatar(imageUrl = user.url_avatar)
}

@Preview
@Composable
private fun AstroAvatarPreview() {
    AstroAvatar(
        imageUrl = "https://developer.android.com/codelabs/jetpack-compose-animation/img/ea1442f28b3c3b39.png",
    )
}