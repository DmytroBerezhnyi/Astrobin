package com.example.astrobin.ui.components.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.astrobin.api.avatarUrl
import com.example.astrobin.ui.components.icon.IconCount
import com.example.astrobin.ui.theme.AstrobinTheme

@Composable
fun SmallUserRow(
    user: String,
    likeCount: Int,
    views: Int,
    modifier: Modifier = Modifier,
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        AstroAvatar(avatarUrl(user))
        Column(Modifier.padding(start = 10.dp)) {
            Text(
                text = "@$user",
                style = MaterialTheme.typography.subtitle1
            )
            Row {
                IconCount(
                    count = views,
                    icon = Icons.Outlined.Visibility,
                )
                IconCount(
                    count = likeCount,
                    icon = Icons.Filled.ThumbUp,
                )
            }
        }
    }
}

@Preview
@Composable
private fun SmallUserRowPreview() {
    AstrobinTheme(darkTheme = false) {
        SmallUserRow(
            user = "Dmytro",
            likeCount = 234,
            views = 1534
        )
    }
}

@Preview
@Composable
private fun SmallUserRowDarkPreview() {
    AstrobinTheme(darkTheme = true) {
        SmallUserRow(
            user = "Dmytro",
            likeCount = 234,
            views = 1534
        )
    }
}