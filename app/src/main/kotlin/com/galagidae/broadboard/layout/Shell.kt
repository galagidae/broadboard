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
    onKey: (Char) -> Unit,
    onBackspace: () -> Unit,
    onEnter: () -> Unit,
    autoShift: State<Boolean>,
    inputContext: State<InputContext>,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    var shiftMode by remember { mutableStateOf<ShiftMode>(ShiftMode.NORMAL) }
    var boardMode by remember { mutableStateOf<BoardMode>(BoardMode.ALPHANUMERIC) }

    fun onKeyInner(c: Char): Unit {
        if (shiftMode == ShiftMode.SHIFT && boardMode != BoardMode.SYMBOLS) {
            shiftMode = ShiftMode.NORMAL
        }
        onKey(c)
    }

    fun onChangeMode(mode: BoardMode) {
        boardMode = mode
        shiftMode = ShiftMode.NORMAL
    }

    AppTheme() {
        Column() {
            key(boardMode) {
                PanBox(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colors.mainBackground)
                        .height(sizes.panBoxHeight)
                ) {
                    when (boardMode) {
                        BoardMode.ALPHANUMERIC -> StandardBoard(
                            onKey = ::onKeyInner,
                            onEnter = onEnter,
                            shiftMode = if (autoShift.value) ShiftMode.LOCK else shiftMode,
                            inputContext = inputContext.value,
                            onChangeMode = ::onChangeMode
                        )
                        BoardMode.SYMBOLS -> SymbolsBoard(
                            onKey = ::onKeyInner,
                            shiftMode = shiftMode,
                            onChangeMode = ::onChangeMode
                        )
                    }
                }
            }
            BottomRow(
                onSpace = { onKey(' ') },
                onBackspace = onBackspace,
                onShift = {lc -> 
                    when (shiftMode) {
                        ShiftMode.NORMAL -> shiftMode = if (lc) ShiftMode.LOCK 
                                                        else ShiftMode.SHIFT
                        ShiftMode.SHIFT -> shiftMode = if (lc) ShiftMode.LOCK 
                                                        else ShiftMode.NORMAL
                        ShiftMode.LOCK -> shiftMode = ShiftMode.NORMAL
                    }
                },
                shiftMode = if (autoShift.value && shiftMode != ShiftMode.LOCK) ShiftMode.SHIFT else shiftMode,
                boardMode = boardMode
            )
        }
    }
}