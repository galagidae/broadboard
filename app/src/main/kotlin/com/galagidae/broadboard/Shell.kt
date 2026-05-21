package com.galagidae.broadboard

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*


@Composable
fun Shell(
    modifier: Modifier = Modifier,
) {
    PanBox(
    modifier = Modifier
        .fillMaxWidth()
        .height(350.dp)
    ) {
        placeholderKeyboard()
    }
}