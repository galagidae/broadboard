package com.galagidae.broadboard

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

data class ColorTheme(
    val mainBackground: Color = Color.Blue,
    val keyBackground: Color = Color.White,
    val keyBackgroundPressed: Color = Color.Black,
    val keyLabel: Color = Color.Black,
    val keyLabelPressed: Color = Color.White
)

data class SizeTheme(
    val panBoxHeight: Dp = 306.dp,
    val bottomRowHeight: Dp = 100.dp,
    val rowHeight: Dp = 150.dp,
    val keyFontSize: Dp = 48.dp,
    val keyEmojiFontSize: Dp = 36.dp,
    val keyIconSize: Dp = 96.dp,
    val keySpacing: Dp = 6.dp,
    val enterKeyWidth: Dp = 225.dp,
    val modeKeyFontSize: Dp = 24.dp,
    val appHeight: Dp = 406.dp,
    val numericFontSize: Dp = 36.dp,
)

val lightTheme = ColorTheme()

val mediumSize = SizeTheme()

val LocalColorTheme = compositionLocalOf { lightTheme }
val LocalSizeTheme = compositionLocalOf { mediumSize }

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColorTheme provides lightTheme,
        LocalSizeTheme provides mediumSize
    ) {
        content()
    }
}