/*
* BroadBoard – A keyboard for users with low vision
* Copyright (C) 2026  Anthony Benbrook
*   
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*   
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*   
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
    val modeKeyBackground: Color = Color(0xFFBBBBFF),
    val actionBorder: Color = Color(0xFF00FF00),
    val actionBackground: Color = Color(0xFF00FF00),
    val shiftBorder: Color = Color.Yellow,
    val shiftBackground: Color = Color.Yellow,
    val spaceBorder: Color = Color.Blue,
    val spaceBackground: Color = Color.Blue,
    val backspaceBorder: Color = Color(0xFFFF4646),
    val backspaceBackground: Color = Color(0xFFFF4646)
)

val lightTheme = ColorTheme()

val darkTheme = ColorTheme(
    mainBackground = Color.Black,
    keyBackground = Color(0xFF2B2E32),
    keyBackgroundPressed = Color.White,
    keyLabel = Color.White,
    keyLabelPressed = Color.Black,
    modeKeyBackground = Color(0xFF2B2E64),
    actionBorder = Color.Green,
    actionBackground = Color(0xFF2B2E32),
    shiftBorder = Color.Yellow,
    shiftBackground = Color(0xFF2B2E32),
    spaceBorder = Color.Blue,
    spaceBackground = Color(0xFF2B2E32),
    backspaceBorder = Color.Red,
    backspaceBackground = Color(0xFF2B2E32)
)

val extraDarkTheme = ColorTheme(
    mainBackground = Color(0xFF2B2E32),
    keyBackground = Color.Black,
    keyBackgroundPressed = Color(0xFF888888),
    keyLabel = Color.White,
    keyLabelPressed = Color.Black,
    modeKeyBackground = Color(0xFF111111),
    actionBorder = Color.Green,
    actionBackground = Color.Black,
    shiftBorder = Color.Yellow,
    shiftBackground = Color.Black,
    spaceBorder = Color.Blue,
    spaceBackground = Color.Black,
    backspaceBorder = Color.Red,
    backspaceBackground = Color.Black
)

val yellowBlackTheme = ColorTheme(
    mainBackground = Color(0xFF333333),
    keyBackground = Color.Black,
    keyBackgroundPressed = Color.Yellow,
    keyLabel = Color.Yellow,
    keyLabelPressed = Color.Black,
    modeKeyBackground = Color(0xFF151515),
    actionBorder = Color.Green,
    actionBackground = Color(0xFF2B2E32),
    shiftBorder = Color(0xFFFFA500),
    shiftBackground = Color(0xFF2B2E32),
    spaceBorder = Color.Blue,
    spaceBackground = Color(0xFF2B2E32),
    backspaceBorder = Color.Red,
    backspaceBackground = Color(0xFF2B2E32)
)

val blackYellowTheme = ColorTheme(
    mainBackground = Color.Black,
    keyBackground = Color.Yellow,
    keyBackgroundPressed = Color.Black,
    keyLabel = Color.Black,
    keyLabelPressed = Color.Yellow,
    modeKeyBackground = Color(0xFFAAAA00),
    actionBorder = Color.Green,
    actionBackground = Color.Yellow,
    shiftBorder = Color(0xFFFFA500),
    shiftBackground = Color.Yellow,
    spaceBorder = Color.Blue,
    spaceBackground = Color.Yellow,
    backspaceBorder = Color.Red,
    backspaceBackground = Color.Yellow
)

val yellowBlueTheme = ColorTheme(
    mainBackground = Color.Black,
    keyBackground = Color.Blue,
    keyBackgroundPressed = Color.Yellow,
    keyLabel = Color.Yellow,
    keyLabelPressed = Color.Blue,
    modeKeyBackground = Color(0xFF0000aa),
    actionBorder = Color.Green,
    actionBackground = Color.Blue,
    shiftBorder = Color(0xFFFFA500),
    shiftBackground = Color.Blue,
    spaceBorder = Color(0xFF800080),
    spaceBackground = Color.Blue,
    backspaceBorder = Color.Red,
    backspaceBackground = Color.Blue
)

val blueYellowTheme = ColorTheme(
    mainBackground = Color.Black,
    keyBackground = Color.Yellow,
    keyBackgroundPressed = Color.Blue,
    keyLabel = Color.Blue,
    keyLabelPressed = Color.Yellow,
    modeKeyBackground = Color(0xFFAAAA00),
    actionBorder = Color.Green,
    actionBackground = Color.Yellow,
    shiftBorder = Color.Yellow,
    shiftBackground = Color.Yellow,
    spaceBorder = Color(0xFF800080),
    spaceBackground = Color.Yellow,
    backspaceBorder = Color.Red,
    backspaceBackground = Color.Yellow
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

val extraSmallSize = SizeTheme(
    keySize = 54.dp,
    rowCount = 3,
    keyCorners = 2.dp,
    bottomRowHeight = 54.dp,
    keySpacing = 1.dp,
    keyFontSize = 45.sp,
    keyEmojiFontSize = 37.sp,
    keyModeFontSize = 28.sp,
    keyNumericFontSize = 32.sp,
    keyIconSize = 72.dp,
    enterKeyWidth = 84.dp,
    modeBarGap = 2.dp
)

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

val extraLargeSize = SizeTheme(
    keySize = 142.dp,
    keyCorners = 4.dp,
    bottomRowHeight = 112.dp,
    keySpacing = 6.dp,
    keyFontSize = 117.sp,
    keyEmojiFontSize = 99.sp,
    keyModeFontSize = 54.sp,
    keyNumericFontSize = 76.sp,
    keyIconSize = 108.dp,
    enterKeyWidth = 214.dp,
    modeBarGap = 12.dp
)
