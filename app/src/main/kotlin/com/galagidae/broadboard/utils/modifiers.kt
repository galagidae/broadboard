package com.galagidae.broadboard.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

fun Modifier.bodyKey(): Modifier = this
    .fillMaxHeight()
    .aspectRatio(1f)

fun Modifier.highlightBorder(
    highlights: Boolean,
    color: Color,
    cornerSize: Dp,
): Modifier = this.then(
    if (highlights)
        Modifier.border(9.dp, color, shape = RoundedCornerShape(cornerSize))
    else
        Modifier
)