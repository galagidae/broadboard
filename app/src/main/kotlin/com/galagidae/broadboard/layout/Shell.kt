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
    onInput: (String) -> Unit,
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

    fun onInputInner(t: String): Unit {
        if (shiftMode == ShiftMode.SHIFT && boardMode == BoardMode.ALPHANUMERIC) {
            shiftMode = ShiftMode.NORMAL
        }
        onInput(t)
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
                            onKey = { c -> onInputInner(c.toString()) },
                            onEnter = onEnter,
                            shiftMode = if (autoShift.value) ShiftMode.LOCK else shiftMode,
                            inputContext = inputContext.value,
                            onChangeMode = ::onChangeMode
                        )
                        BoardMode.SYMBOLS -> SymbolsBoard(
                            onKey = { c -> onInputInner(c.toString()) },
                            shiftMode = shiftMode,
                            onChangeMode = ::onChangeMode
                        )
                        BoardMode.EMOJIS -> EmojisBoard(
                            onKey = ::onInputInner,
                            shiftMode = shiftMode,
                            onChangeMode = ::onChangeMode
                        )
                    }
                }
            }
            BottomRow(
                onSpace = { onInputInner(" ") },
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