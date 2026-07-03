package com.galagidae.broadboard.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalDensity
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
    onClickKeyboardPicker: (() -> Unit)? = null,
    actionKey: State<ActionKey>,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    var shiftMode by remember { mutableStateOf<ShiftMode>(ShiftMode.NORMAL) }
    var boardMode by remember { mutableStateOf<BoardMode>(BoardMode.ALPHANUMERIC) }
    var alternate by remember { mutableStateOf<Alternate?>(null) }

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

    fun onClickAlternate(alt: Alternate) {
        alternate = alt
    }

    fun closeAlternate() {
        boardMode = BoardMode.ALPHANUMERIC  
        alternate = null
    }

    CompositionLocalProvider(
        LocalDensity provides Density(LocalDensity.current.density, fontScale = 1f)
    ) {
        AppTheme() {
            when(boardMode) {
                BoardMode.NUMERIC -> NumericBoard(
                    onKey = { c -> onInputInner(c.toString()) },
                    onBackspace = onBackspace,
                    onChangeMode = ::onChangeMode
                )
                BoardMode.MENU -> MenuBoard(
                    onChangeMode = ::onChangeMode,
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
                                    val alt = alternate
                                    
                                    if (alt != null)
                                        AlternateBoard(
                                            onKey = { c -> 
                                                onInputInner(c.toString())
                                                closeAlternate()
                                            },
                                            shiftMode = if (autoShift.value) ShiftMode.LOCK else shiftMode,
                                            alternate = alt,
                                            visibleWidth = visibleWidth,
                                            visibleHeight = visibleHeight
                                        )
                                    else StandardBoard(
                                        onKey = { c -> onInputInner(c.toString()) },
                                        onEnter = onEnter,
                                        shiftMode = if (autoShift.value) ShiftMode.LOCK else shiftMode,
                                        inputContext = inputContext.value,
                                        onChangeMode = ::onChangeMode,
                                        onClickAlternate = ::onClickAlternate,
                                        actionKey = actionKey
                                    )
                                }
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
                                else -> {}
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
                        boardMode = boardMode,
                        isAlternate = boardMode == BoardMode.ALPHANUMERIC && alternate != null,
                        onClickClose = ::closeAlternate
                    )
                }
            }
        }
    }
}