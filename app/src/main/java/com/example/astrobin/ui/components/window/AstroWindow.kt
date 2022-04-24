package com.example.astrobin.ui.components.window

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import com.example.astrobin.ui.theme.mainWindowGradient
import com.google.accompanist.insets.ProvideWindowInsets

private enum class AstroScaffoldLayoutContent { TopBar, MainContent, BottomBar }

@Composable
fun AstroAppWindow(
    modifier: Modifier = Modifier,
    top: @Composable () -> Unit,
    bottom: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    ProvideWindowInsets {
        CompositionLocalProvider(
            LocalContentColor provides Color.White
        ) {
            SubcomposeLayout(modifier = modifier.background(mainWindowGradient)) { constraints ->
                val layoutWidth = constraints.maxWidth
                val layoutHeight = constraints.maxHeight

                val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

                layout(layoutWidth, layoutHeight) {
                    val topBarPlaceables = subcompose(AstroScaffoldLayoutContent.TopBar, top)
                        .map { it.measure(looseConstraints) }

                    // hard code to 0 as we want the top bar to "float" on top of things
                    val topBarHeight = 0

                    val bottomBarPlaceables =
                        subcompose(AstroScaffoldLayoutContent.BottomBar, bottom)
                            .map { it.measure(looseConstraints) }

                    val bottomBarHeight = bottomBarPlaceables.maxByOrNull { it.height }?.height ?: 0

                    val bodyContentHeight = layoutHeight - topBarHeight

                    val bodyContentPlaceables = subcompose(AstroScaffoldLayoutContent.MainContent) {
                        val innerPadding = PaddingValues(bottom = bottomBarHeight.toDp())
                        content(innerPadding)
                    }.map { it.measure(looseConstraints.copy(maxHeight = bodyContentHeight)) }

                    // Placing to control drawing order to match default elevation of each placeable
                    bodyContentPlaceables.forEach {
                        it.place(0, topBarHeight)
                    }
                    topBarPlaceables.forEach {
                        it.place(0, 0)
                    }

                    // The bottom bar is always at the bottom of the layout
                    bottomBarPlaceables.forEach {
                        it.place(0, layoutHeight - bottomBarHeight)
                    }
                }
            }
        }
    }
}