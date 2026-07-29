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

package com.galagidae.broadboard.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.utils.*

@Composable
fun LandscapeLayout(
    actionKey: State<ActionKey>,
    alternate: Alternate? = null,
    autoShift: Boolean,
    boardMode: BoardMode,
    inputContext: State<InputContext>,
    currentLocale: State<String>,
    orientation: Orientation,
    shiftMode: ShiftMode,
    onAlternateKey: ((c: Char) -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickAlternate: ((Alternate) -> Unit)? = null,
    onClickClose: (() -> Unit)? = null,
    onClickKeyboardPicker: (() -> Unit)? = null,
    onInput: ((input: String) -> Unit)? = null,
    onEnter: (() -> Unit)? = null,
    onShift: ((longClick: Boolean) -> Unit)? = null,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current
    var menuBarOption = LocalMenuBarOption.current

    Row(
        modifier = Modifier.height(sizes.panBoxHeight),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        when(boardMode) {
            BoardMode.NUMERIC -> MenuKey(
                onClick = { onChangeMode?.invoke(BoardMode.MENU) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            BoardMode.MENU -> null
            else -> {
                if (alternate == null) {
                    IconKey(
                        modifier = Modifier
                            .fillMaxHeight()
                            .highlightBorder(highlights, colors.spaceBorder, sizes.keyCorners),
                        backgroundOverride = if (highlights) colors.spaceBackground else null,
                        onClick = { onInput?.invoke(" ") },
                        onLongClick = if (menuBarOption != "bar")
                            { { onChangeMode?.invoke(BoardMode.MENU) } }
                        else 
                            null,
                        icon = spacebar,
                        description = R.string.key_space
                    )
                } else {
                    IconKey(
                        modifier = Modifier
                            .weight(1f)
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
        Box(modifier = Modifier.weight(6f)) {
            when(boardMode) {
                BoardMode.NUMERIC -> NumericBoard(
                    onKey = { c -> onInput?.invoke(c.toString()) },
                    onBackspace = onBackspace,
                    onChangeMode = onChangeMode,
                    orientation = orientation
                )
                BoardMode.MENU -> MenuBoard(
                    onChangeMode = onChangeMode,
                    onClickKeyboardPicker = onClickKeyboardPicker
                )
                else -> key(boardMode, alternate) {
                        PanBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(colors.mainBackground)
                                .height(sizes.panBoxHeight)
                        ) {
                            when (boardMode) {
                                BoardMode.ALPHANUMERIC -> {
                                    if (alternate != null)
                                        AlternateBoard(
                                            onKey = onAlternateKey,
                                            shiftMode = if (autoShift) ShiftMode.LOCK else shiftMode,
                                            alternate = alternate,
                                            visibleWidth = visibleWidth,
                                            visibleHeight = visibleHeight
                                        )
                                    else StandardBoard(
                                        onKey = { c -> onInput?.invoke(c.toString()) },
                                        onEnter = onEnter,
                                        shiftMode = if (autoShift) ShiftMode.LOCK else shiftMode,
                                        inputContext = inputContext,
                                        currentLocale = currentLocale,
                                        onChangeMode = onChangeMode,
                                        onClickAlternate = onClickAlternate,
                                        actionKey = actionKey
                                    )
                                }
                                BoardMode.SYMBOLS -> SymbolsBoard(
                                    onKey = { c -> onInput?.invoke(c.toString()) },
                                    shiftMode = shiftMode,
                                    onChangeMode = onChangeMode
                                )
                                BoardMode.EMOJIS -> EmojisBoard(
                                    onKey = onInput,
                                    shiftMode = shiftMode,
                                    onChangeMode = onChangeMode
                                )
                            }
                        }
                    }
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(sizes.keySpacing)
        ) {
            when(boardMode) {
                BoardMode.MENU -> null
                else -> {
                    IconKey(
                        onClick = onBackspace,
                        icon = backspace,
                        description = R.string.key_delete,
                        repeating = true,
                        backgroundOverride = if (highlights) colors.backspaceBackground else null,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .highlightBorder(highlights, colors.backspaceBorder, sizes.keyCorners)
                    )
                    if (boardMode != BoardMode.NUMERIC) {
                        ShiftKey(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            boardMode = boardMode,
                            shiftMode = shiftMode,
                            onClick = {onShift?.invoke(false)},
                            onLongClick = {onShift?.invoke(true)},            
                        )
                    }
                }
            }
        }
    }
}