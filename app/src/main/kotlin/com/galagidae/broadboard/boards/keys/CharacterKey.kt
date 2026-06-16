package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

@Composable
fun CharacterKey (
    onKey: ((Char) -> Unit)? = null,
    shiftMode: ShiftMode = ShiftMode.NORMAL,
    character: Character,
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
        onClick = {
            onKey?.invoke(currentChar)
        }
    ) {
        Text(
            text = currentChar.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = dpToSp(sizes.keyFontSize)
        )
    }
}
