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

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.Dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.enter
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*

@Composable
fun AlternateBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    shiftMode: ShiftMode,
    alternate: Alternate,
    visibleWidth: Dp,
    visibleHeight: Dp,
    modifier: Modifier = Modifier
) {
    val sizes = LocalSizeTheme.current

    if (alternate.rows.size == 0) {
        return
    }

    val widerRow = 
        if (alternate.rows.size == 1 || alternate.rows[0].size >= alternate.rows[1].size) 
            alternate.rows[0]
        else
            alternate.rows[1]

    val rowWidth = (sizes.rowHeight * widerRow.size +
                sizes.keySpacing * (widerRow.size - 1))
                .coerceAtLeast(visibleWidth)

    Column(
        modifier = Modifier.height(sizes.panBoxHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        alternate.rows.forEach { row ->
            Row(
                modifier = modifier
                        .width(rowWidth)
                        .then(
                            if (alternate.rows.size > 1)
                                Modifier.height(sizes.rowHeight)
                            else
                            Modifier.fillMaxHeight()
                    ),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            ) {
                row.forEach { key ->
                    SymbolKey(
                        symbolSet = key,
                        onKey = onKey,
                        shiftMode = if (shiftMode == ShiftMode.NORMAL) shiftMode else ShiftMode.SHIFT,
                        modifier = Modifier.fillMaxHeight().weight(1f)
                    )
                }
            }
        }
    }
}
