package com.galagidae.broadboard

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*


@Composable
fun Shell(
    modifier: Modifier = Modifier,
) {
    val sizes = LocalSizeTheme.current

    AppTheme() {
        Column() {
            PanBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(sizes.panBoxHeight)
            ) {
                placeholderKeyboard()
            }
            BottomRow()
        }
    }
}