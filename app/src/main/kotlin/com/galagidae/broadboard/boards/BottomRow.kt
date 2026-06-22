package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.*
import com.galagidae.broadboard.boards.keys.*


@Composable
fun BottomRow(
    onSpace: () -> Unit,
    onBackspace: () -> Unit,
    onShift: (longClick: Boolean) -> Unit,
    shiftMode: ShiftMode,
    boardMode: BoardMode,
    isAlternate: Boolean = false,
    onClickClose: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .height(sizes.bottomRowHeight)
            .fillMaxWidth()
            .background(colors.mainBackground)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ShiftKey(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            boardMode = boardMode,
            shiftMode = shiftMode,
            onClick = {onShift(false)},
            onLongClick = {onShift(true)},            
        )
        if (!isAlternate) {
            IconKey(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),            
                onClick = onSpace,
                icon = spacebar,
                description = R.string.key_space
            )
            IconKey(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                onClick = onBackspace,
                icon = backspace,
                description = R.string.key_delete,
                repeating = true
            )
        } else {
            IconKey(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),            
                onClick = onClickClose,
                icon = close,
                description = R.string.key_back
            )
        }
    }
}