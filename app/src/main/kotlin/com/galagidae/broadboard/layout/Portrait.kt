package com.galagidae.broadboard.layout

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
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
    onNavigate: ((direction: NavigationDirection) -> Unit)? = null
) {
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
        else -> Column {
            PanBoard(
                actionKey = actionKey,
                alternate = alternate,
                autoShift = autoShift,
                boardMode = boardMode,
                inputContext = inputContext,
                currentLocale = currentLocale,
                shiftMode = shiftMode,
                onAlternateKey = onAlternateKey,
                onBackspace = onBackspace,
                onChangeMode = onChangeMode,
                onClickAlternate = onClickAlternate,
                onClickKeyboardPicker = onClickKeyboardPicker,
                onNavigate = onNavigate,
                onInput = onInput,
                onEnter = onEnter
            )
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