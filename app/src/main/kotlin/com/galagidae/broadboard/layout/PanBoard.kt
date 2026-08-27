package com.galagidae.broadboard.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.*

@Composable
fun PanBoard(
    actionKey: State<ActionKey>,
    alternate: Alternate? = null,
    autoShift: Boolean,
    boardMode: BoardMode,
    inputContext: State<InputContext>,
    currentLocale: State<String>,
    shiftMode: ShiftMode,
    onAlternateKey: ((c: Char) -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickAlternate: ((Alternate) -> Unit)? = null,
    onClickKeyboardPicker: (() -> Unit)? = null,
    onNavigate: ((direction: NavigationDirection) -> Unit)? = null,
    onInput: ((input: String) -> Unit)? = null,
    onEnter: (() -> Unit)? = null,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

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
                BoardMode.NAVIGATION -> NavigationBoard(
                    visibleWidth = visibleWidth,
                    onChangeMode = onChangeMode,
                    onClickKeyboardPicker = onClickKeyboardPicker,
                    onBackspace = onBackspace,
                    onNavigate = onNavigate
                )
                else -> null
            }
        }
    }
}