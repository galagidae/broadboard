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

@Composable
fun LandscapeLayout(
    actionKey: State<ActionKey>,
    alternate: Alternate? = null,
    autoShift: Boolean,
    boardMode: BoardMode,
    inputContext: State<InputContext>,
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
            else -> IconKey(
                modifier = Modifier.fillMaxHeight(),
                onClick = { onInput?.invoke(" ") },
                onLongClick = if (menuBarOption != "bar")
                    { { onChangeMode?.invoke(BoardMode.MENU) } }
                else 
                    null,
                icon = spacebar,
                description = R.string.key_space
            )
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
        Column(verticalArrangement = Arrangement.spacedBy(sizes.keySpacing)) {
            when(boardMode) {
                BoardMode.MENU -> null
                else -> {
                    IconKey(
                        onClick = onBackspace,
                        icon = backspace,
                        description = R.string.key_delete,
                        repeating = true,
                        modifier = Modifier.fillMaxHeight().weight(1f)
                    )
                    if (boardMode != BoardMode.NUMERIC) {
                        ShiftKey(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
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