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

package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*

@Composable
fun NumericBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    orientation: Orientation,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current

    val rows = when(orientation) {
            Orientation.LANDSCAPE -> numericLayout_land
            else -> numericLayout
    }

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.appHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        rows.forEach { row ->
            NumberRow(row, onKey)
        }

        if (orientation == Orientation.PORTRAIT) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
            ) {
                MenuKey(
                    onClick = { onChangeMode?.invoke(BoardMode.MENU) },
                    modifier = Modifier.weight(1f)
                )
                NumberKey(
                    number = '0',
                    onClick = onKey,
                    modifier = Modifier.weight(1f)
                )
                IconKey(
                    onClick = onBackspace,
                    icon = backspace,
                    description = R.string.key_delete,
                    repeating = true,
                    backgroundOverride = if (highlights) colors.backspaceBackground else null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .highlightBorder(highlights, colors.backspaceBorder, sizes.keyCorners)
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.NumberRow(
    numbers: List<Char>,
    onKey: ((Char) -> Unit)? = null
) {
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        numbers.forEach { n ->
            NumberKey(
                number = n, 
                onClick = onKey,
                modifier = Modifier.weight(1f)
            )
        }                
    }
}

@Composable
private fun NumberKey(
    number: Char, 
    onClick: ((char: Char) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    BaseKey(
        description = number,
        onClick = { onClick?.invoke(number) },
        modifier = modifier.fillMaxHeight()
    ) {
        Text(
            text = number.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = sizes.keyNumericFontSize
        )
    }
}

private val numericLayout = listOf(
    listOf('1', '2', '3'),
    listOf('4', '5', '6'),
    listOf('7', '8', '9'),
)

private val numericLayout_land = listOf(
    listOf('1', '2', '3', '4', '5'),
    listOf('6', '7', '8', '9', '0')
)
