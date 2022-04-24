package com.example.astrobin.ui.components.icon

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.astrobin.ui.theme.AstrobinTheme

@Composable
fun IconCount(
    count: Int,
    icon: ImageVector,
    contentDescription: String? = null,
) {
    Row(modifier = Modifier.padding(end = 12.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(top = 0.dp, end = 4.dp)
                .size(14.dp)
        )
        Text(
            text = "$count",
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
private fun PrevIconCount() {
    AstrobinTheme {
        IconCount(count = 23, icon = Icons.Filled.Backpack)
    }
}

@Preview
@Composable
private fun PrevIconCountNight() {
    AstrobinTheme(darkTheme = true) {
        IconCount(count = 23, icon = Icons.Filled.Backpack)
    }
}