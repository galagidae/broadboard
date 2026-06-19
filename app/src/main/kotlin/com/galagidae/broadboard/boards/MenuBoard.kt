package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*
import com.galagidae.broadboard.boards.icons.*

@Composable
fun MenuBoard(
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickKeyboardPicker: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.appHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        MenuRow() {
            ModeKey(
                modifier = menuKey,
                label = "abc",
                description = R.string.key_alpha,
                onClick = { onChangeMode?.invoke(BoardMode.ALPHANUMERIC) }
            )
            ModeKey(
                modifier = menuKey,
                label = "?!;()",
                description = R.string.key_symbols,
                onClick = { onChangeMode?.invoke(BoardMode.SYMBOLS) }
            )
            ModeKey(
                modifier = menuKey,
                label = "123",
                description = R.string.key_symbols,
                onClick = { onChangeMode?.invoke(BoardMode.NUMERIC) }
            )
        }
        MenuRow() {
            ModeKey(
                modifier = menuKey,
                label = "🙂",
                description = R.string.key_emojis,
                onClick = { onChangeMode?.invoke(BoardMode.EMOJIS) },
            )
            IconKey(
                modifier = menuKey,
                onClick = onClickKeyboardPicker,
                icon = keyboard,
                description = R.string.key_picker
            )
        }
    }
}

private val RowScope.menuKey: Modifier
    get() = Modifier
        .fillMaxHeight()
        .weight(1f)

@Composable
private fun ColumnScope.MenuRow(
    content: @Composable RowScope.() -> Unit
) {
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .weight(1f),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        content()
    }
}