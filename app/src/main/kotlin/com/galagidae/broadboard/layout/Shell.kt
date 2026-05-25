package com.galagidae.broadboard.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.*

@Composable
fun Shell(
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    AppTheme() {
        Column() {
            PanBox(
            modifier = Modifier
                .fillMaxWidth()
                .background(colors.mainBackground)
                .height(sizes.panBoxHeight)
            ) {
                StandardBoard()
            }
            BottomRow()
        }
    }
}