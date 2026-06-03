package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.*
import com.galagidae.broadboard.boards.keys.IconKey


@Composable
fun BottomRow(
    onSpace: () -> Unit,
    onBackspace: () -> Unit,
    onShift: (longClick: Boolean) -> Unit,
    shiftMode: ShiftMode,
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
        IconKey(
            onClick = {onShift(false)},
            onLongClick = {onShift(true)},
            modifier = Modifier.weight(1f),
            icon = when(shiftMode) {
                ShiftMode.NORMAL -> shift_off
                ShiftMode.SHIFT -> shift_on
                ShiftMode.LOCK -> shift_lock
            },
            description = stringResource(R.string.key_shift)
        )        
        IconKey(
            onClick = onSpace,
            modifier = Modifier.weight(2f),
            icon = spacebar,
            description = stringResource(R.string.key_space)
        )
        IconKey(
            onClick = onBackspace,
            modifier = Modifier.weight(1f),
            icon = backspace,
            description = stringResource(R.string.key_delete)
        )              
    }
}