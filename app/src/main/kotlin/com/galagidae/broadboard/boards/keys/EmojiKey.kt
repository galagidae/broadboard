package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

@Composable
fun EmojiKey (
    onKey: ((String) -> Unit)? = null,
    shiftMode: ShiftMode = ShiftMode.NORMAL,
    emoji: Emoji,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val currentEmoji = if (shiftMode == ShiftMode.SHIFT) 
        emoji.secondary
    else 
        emoji.primary

    BaseKey (
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f),
        description = currentEmoji,
        onClick = {
            onKey?.invoke(currentEmoji)
        }
    ) {
        Text(
            text = currentEmoji,
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = dpToSp(sizes.keyEmojiFontSize)
        )
    }
}
