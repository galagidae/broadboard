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
    val keySize: Dp,
    val bottomRowHeight: Dp,
    val keySpacing: Dp,
    val keyFontSize: TextUnit,
    val keyEmojiFontSize: TextUnit,
    val keyModeFontSize: TextUnit,
    val keyNumericFontSize: TextUnit,
    val keyIconSize: Dp,
    val enterKeyWidth: Dp,
) {
    val rowHeight: Dp = keySize
    val panBoxHeight: Dp = keySize * 2 + keySpacing
    val appHeight: Dp = bottomRowHeight + panBoxHeight
}

val lightTheme = ColorTheme()

val mediumSize = SizeTheme(
    keySize = 110.dp,
    bottomRowHeight = 75.dp,
    keySpacing = 6.dp,
    keyFontSize = 91.sp,
    keyEmojiFontSize = 64.sp,
    keyModeFontSize = 48.sp,
    keyNumericFontSize = 59.sp,
    keyIconSize = 96.dp,
    enterKeyWidth = 166.dp,
)

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