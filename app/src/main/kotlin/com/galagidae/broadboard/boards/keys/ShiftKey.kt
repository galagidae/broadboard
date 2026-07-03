package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Text
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.*

@Composable
fun ShiftKey(
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    boardMode: BoardMode,
    shiftMode: ShiftMode,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val description = when(boardMode) {
        BoardMode.SYMBOLS ->  
            if(shiftMode == ShiftMode.NORMAL) 
                R.string.key_symbols_more 
            else 
                R.string.key_symbols_shift
        BoardMode.EMOJIS ->  
            if(shiftMode == ShiftMode.NORMAL) 
                R.string.key_emojis_sad 
            else 
                R.string.key_emojis_happy                
        else ->
            R.string.key_shift
    }

    BaseKey(
        modifier = modifier,
        onClick = onClick,
        onLongClick = {
            when(boardMode){
                BoardMode.ALPHANUMERIC -> onLongClick?.invoke()
                else -> onClick?.invoke()
            }
        },
        description = description
    ) {
        when(boardMode) {
            BoardMode.SYMBOLS -> Text(
                text = when(shiftMode) {
                    ShiftMode.NORMAL -> "¡¿;\\"
                    else -> "!?:/"
                },
                color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
                fontSize = sizes.keyModeFontSize
            )
            BoardMode.EMOJIS -> Text(
                text = when(shiftMode) {
                    ShiftMode.NORMAL -> "🙁"
                    else -> "🙂"
                },
                color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
                fontSize = sizes.keyModeFontSize
            )
            else -> Icon(
                modifier = Modifier
                    .size(sizes.keyIconSize),
                imageVector = when(shiftMode) {
                    ShiftMode.NORMAL -> shift_off
                    ShiftMode.SHIFT -> shift_on
                    ShiftMode.LOCK -> shift_lock                
                },
                tint = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
                contentDescription = "Shift",
            )
        }
    }
}

