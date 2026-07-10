package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*


@Composable
fun BottomRow(
    onSpace: (() -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    onShift: ((longClick: Boolean) -> Unit)? = null,
    shiftMode: ShiftMode,
    boardMode: BoardMode,
    isAlternate: Boolean = false,
    onClickClose: (() -> Unit)? = null,
    onLongClickSpace: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val highlights = LocalHighlights.current
    var menuBarOption = LocalMenuBarOption.current

    Row(
        modifier = Modifier
            .height(sizes.bottomRowHeight)
            .fillMaxWidth()
            .background(colors.mainBackground)
            .padding(horizontal = sizes.keySpacing, vertical = sizes.keySpacing),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        ShiftKey(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            boardMode = boardMode,
            shiftMode = shiftMode,
            onClick = {onShift?.invoke(false)},
            onLongClick = {onShift?.invoke(true)},            
        )
        if (!isAlternate) {
            IconKey(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .highlightBorder(highlights, colors.spaceBorder, sizes.keyCorners),
                backgroundOverride = if (highlights) colors.spaceBackground else null,
                onClick = onSpace,
                onLongClick = if (menuBarOption != "bar") onLongClickSpace else null,
                icon = spacebar,
                description = R.string.key_space
            )
            IconKey(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .highlightBorder(highlights, colors.backspaceBorder, sizes.keyCorners),
                backgroundOverride = if (highlights) colors.backspaceBackground else null,
                onClick = onBackspace,
                icon = backspace,
                description = R.string.key_delete,
                repeating = true
            )
        } else {
            IconKey(
                modifier = Modifier
                    .weight(2f)
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