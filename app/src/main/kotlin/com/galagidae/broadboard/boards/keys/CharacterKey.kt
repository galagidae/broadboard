package com.galagidae.broadboard.boards.keys

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*

@Composable
fun CharacterKey (
    onKey: ((Char) -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    shiftMode: ShiftMode = ShiftMode.NORMAL,
    character: Character,
    @StringRes longDescription: Int? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val currentChar = if (shiftMode == ShiftMode.NORMAL) 
        character.primary
    else 
        character.secondary

    BaseKey (
        modifier = modifier,
        description = currentChar,
        longDescription = longDescription,
        onClick = {
            onKey?.invoke(currentChar)
        },
        onLongClick = onLongClick
    ) {
        Text(
            text = currentChar.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = sizes.keyFontSize
        )
    }
}
