package com.galagidae.broadboard

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.IntSize

@Composable
fun PanBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val offset = remember { mutableStateOf(Offset.Zero) }
    var viewportSize by remember { mutableStateOf(IntSize.Zero) }
    var contentSize by remember { mutableStateOf(IntSize.Zero) }

    val scrollState = rememberScrollable2DState { delta ->
        val maxX = (contentSize.width - viewportSize.width).toFloat().coerceAtLeast(0f)
        val maxY = (contentSize.height - viewportSize.height).toFloat().coerceAtLeast(0f)
        val new = offset.value + delta
        offset.value = Offset(
            x = new.x.coerceIn(-maxX, 0f),
            y = new.y.coerceIn(-maxY, 0f),
        )
        delta
    }

    Box(
        modifier = modifier
            .onSizeChanged { viewportSize = it }
            .clipToBounds()
            .scrollable2D(state = scrollState),
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(align = Alignment.TopStart, unbounded = true)
                .onSizeChanged { contentSize = it }
                .graphicsLayer {
                    translationX = offset.value.x
                    translationY = offset.value.y
                },
        ) {
            content()
        }
    }
}