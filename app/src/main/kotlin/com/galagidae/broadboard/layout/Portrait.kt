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
import com.galagidae.broadboard.boards.*

@Composable
fun PortraitLayout(
    actionKey: State<ActionKey>,
    alternate: Alternate? = null,
    autoShift: Boolean,
    boardMode: BoardMode,
    inputContext: State<InputContext>,
    orientation: Orientation,
    shiftMode: ShiftMode,
    currentLocale: State<String>,
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
        else -> Column() {
            key(boardMode, alternate) {
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
                            currentLocale = currentLocale,
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
            BottomRow(
                onSpace = { onInput?.invoke(" ") },
                onBackspace = onBackspace,
                onShift = onShift,
                shiftMode = if (autoShift && shiftMode != ShiftMode.LOCK) ShiftMode.SHIFT else shiftMode,
                boardMode = boardMode,
                isAlternate = boardMode == BoardMode.ALPHANUMERIC && alternate != null,
                onClickClose = onClickClose,
                onLongClickSpace = { onChangeMode?.invoke(BoardMode.MENU) }
            )
        }
    }
}