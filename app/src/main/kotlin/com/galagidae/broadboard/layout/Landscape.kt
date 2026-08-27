package com.galagidae.broadboard.layout

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
    onNavigate: ((direction: NavigationDirection) -> Unit)? = null,
    onInput: ((input: String) -> Unit)? = null,
    onEnter: (() -> Unit)? = null,
    onShift: ((longClick: Boolean) -> Unit)? = null,
) {
    val sizes = LocalSizeTheme.current
    val onOpenMenu: () -> Unit = { onChangeMode?.invoke(BoardMode.MENU) }

    Row(
        modifier = Modifier.height(sizes.panBoxHeight),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        when(boardMode) {
            BoardMode.MENU -> CenterSlot {
                MenuBoard(
                    onChangeMode = onChangeMode,
                    onClickKeyboardPicker = onClickKeyboardPicker
                )
            }
            BoardMode.NUMERIC -> {
                MenuKey(
                    onClick = onOpenMenu,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
                CenterSlot {
                    NumericBoard(
                        onKey = { c -> onInput?.invoke(c.toString()) },
                        onBackspace = onBackspace,
                        onChangeMode = onChangeMode,
                        orientation = orientation
                    )
                }
                SideColumn {
                    BackspaceKey(onBackspace = onBackspace)
                }
            }
            else -> {
                if (alternate == null)
                    SpaceKey(
                        onInput = onInput,
                        onOpenMenu = onOpenMenu
                    )
                else
                    CloseKey(onClickClose = onClickClose)
                CenterSlot {
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
                }
                SideColumn {
                    BackspaceKey(onBackspace = onBackspace)
                    if (boardMode == BoardMode.NAVIGATION)
                        MenuKey(
                            onClick = onOpenMenu,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        )
                    else
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

@Composable
private fun RowScope.CenterSlot(content: @Composable BoxScope.() -> Unit) {
    Box(modifier = Modifier.weight(6f), content = content)
}

@Composable
private fun RowScope.SideColumn(content: @Composable ColumnScope.() -> Unit) {
    val sizes = LocalSizeTheme.current

    Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
        content = content
    )
}

@Composable
private fun RowScope.SpaceKey(
    onInput: ((input: String) -> Unit)?,
    onOpenMenu: () -> Unit
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current
    val menuBarOption = LocalMenuBarOption.current

    IconKey(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .highlightBorder(highlights, colors.spaceBorder, sizes.keyCorners),
        backgroundOverride = if (highlights) colors.spaceBackground else null,
        onClick = { onInput?.invoke(" ") },
        onLongClick = if (menuBarOption != "bar") onOpenMenu else null,
        icon = spacebar,
        description = R.string.key_space
    )
}

@Composable
private fun RowScope.CloseKey(onClickClose: (() -> Unit)?) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current

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

@Composable
private fun ColumnScope.BackspaceKey(onBackspace: (() -> Unit)?) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current

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
}