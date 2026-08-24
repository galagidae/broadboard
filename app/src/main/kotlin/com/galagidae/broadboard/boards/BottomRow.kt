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
import androidx.compose.ui.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*


@Composable
fun BottomRow(
    onSpace: (() -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    onShift: ((longClick: Boolean) -> Unit)? = null,
    shiftMode: ShiftMode,
    boardMode: BoardMode,
    isAlternate: Boolean = false,
    onClickClose: (() -> Unit)? = null,
    onLongClickSpace: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current
    var menuBarOption = LocalMenuBarOption.current

    Row(
        modifier = Modifier
            .height(sizes.bottomRowHeight)
            .fillMaxWidth()
            .background(colors.mainBackground)
            .padding(horizontal = sizes.keySpacing, vertical = sizes.keySpacing),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        when(boardMode) {
            BoardMode.NAVIGATION -> MenuKey(
                onClick = { onLongClickSpace?.invoke() },
                modifier = Modifier.weight(1f)
            )
            else -> ShiftKey(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                boardMode = boardMode,
                shiftMode = shiftMode,
                onClick = {onShift?.invoke(false)},
                onLongClick = {onShift?.invoke(true)},            
            )
        }
        if (!isAlternate) {
            IconKey(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .highlightBorder(highlights, colors.spaceBorder, sizes.keyCorners),
                backgroundOverride = if (highlights) colors.spaceBackground else null,
                onClick = onSpace,
                onLongClick = if (menuBarOption != "bar") onLongClickSpace else null,
                icon = spacebar,
                description = R.string.key_space,
                longDescription = if (menuBarOption != "bar")
                    R.string.key_space_long
                else
                    null
            )
            IconKey(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .highlightBorder(highlights, colors.backspaceBorder, sizes.keyCorners),
                backgroundOverride = if (highlights) colors.backspaceBackground else null,
                onClick = onBackspace,
                icon = backspace,
                description = R.string.key_delete,
                repeating = true
            )
        } else {
            IconKey(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .highlightBorder(highlights, colors.backspaceBorder, sizes.keyCorners),            
                backgroundOverride = if (highlights) colors.backspaceBackground else null,
                onClick = onClickClose,
                icon = close,
                description = R.string.key_back
            )
        }
    }
}