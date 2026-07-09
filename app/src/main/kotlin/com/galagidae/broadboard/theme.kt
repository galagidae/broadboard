package com.galagidae.broadboard

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

data class ColorTheme(
    val mainBackground: Color = Color(0xFF888888),
    val keyBackground: Color = Color.White,
    val keyBackgroundPressed: Color = Color.Black,
    val keyLabel: Color = Color.Black,
    val keyLabelPressed: Color = Color.White,
    val modeKeyBackground: Color = Color(0xFFBBBBFF)
)

val lightTheme = ColorTheme()

val darkTheme = ColorTheme(
    mainBackground = Color.Black,
    keyBackground = Color(0xFF2B2E32),
    keyBackgroundPressed = Color.White,
    keyLabel = Color.White,
    keyLabelPressed = Color.Black,
    modeKeyBackground = Color(0xFF2B2E64)
)

data class SizeTheme(
    val keySize: Dp,
    val rowCount: Int = 2,
    val keyCorners: Dp,
    val bottomRowHeight: Dp,
    val keySpacing: Dp,
    val keyFontSize: TextUnit,
    val keyEmojiFontSize: TextUnit,
    val keyModeFontSize: TextUnit,
    val keyNumericFontSize: TextUnit,
    val keyIconSize: Dp,
    val enterKeyWidth: Dp,
    val modeBarGap: Dp,
) {
    val rowHeight: Dp = keySize
    val panBoxHeight: Dp = keySize * rowCount + keySpacing
    val appHeight: Dp = bottomRowHeight + panBoxHeight
    val appHeightLand: Dp = panBoxHeight
}

val smallSize = SizeTheme(
    keySize = 72.dp,
    rowCount = 3,
    keyCorners = 2.dp,
    bottomRowHeight = 65.dp,
    keySpacing = 2.dp,
    keyFontSize = 60.sp,
    keyEmojiFontSize = 37.sp,
    keyModeFontSize = 37.sp,
    keyNumericFontSize = 42.sp,
    keyIconSize = 96.dp,
    enterKeyWidth = 112.dp,
    modeBarGap = 3.dp
)

val mediumSize = SizeTheme(
    keySize = 110.dp,
    keyCorners = 3.dp,
    bottomRowHeight = 75.dp,
    keySpacing = 3.dp,
    keyFontSize = 91.sp,
    keyEmojiFontSize = 64.sp,
    keyModeFontSize = 48.sp,
    keyNumericFontSize = 59.sp,
    keyIconSize = 96.dp,
    enterKeyWidth = 166.dp,
    modeBarGap = 9.dp
)

val largeSize = SizeTheme(
    keySize = 126.dp,
    keyCorners = 4.dp,
    bottomRowHeight = 100.dp,
    keySpacing = 6.dp,
    keyFontSize = 104.sp,
    keyEmojiFontSize = 88.sp,
    keyModeFontSize = 48.sp,
    keyNumericFontSize = 67.sp,
    keyIconSize = 96.dp,
    enterKeyWidth = 190.dp,
    modeBarGap = 12.dp
)
