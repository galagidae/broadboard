package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import com.galagidae.broadboard.*

@Composable
fun CharacterKey (
    onKey: (Char) -> Unit,    
    shiftMode: ShiftMode,
    modifier: Modifier = Modifier,
    character: Character
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val currentChar = if (
        shiftMode == ShiftMode.SHIFT ||
        (shiftMode == ShiftMode.LOCK && character.lockable)
    ) character.secondary else character.primary

    BaseKey (
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f),
        onClick = {
            onKey(currentChar)
        }
    ) {
        Text(
            text = currentChar.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = dpToSp(sizes.keyFontSize)
        )
    }
}

/**
  * Converts dp to sp for fontSize
  * Normally you would never do this as it overrides a user's accessibility preferences
  * But this is an accessibility keyboard that will have size options that scale
  * key font size much more than the system would on its own.
**/
@Composable
private fun dpToSp(dp: Dp): TextUnit {
    val density = LocalDensity.current
    return with(density) {
        (dp.toPx() / fontScale).sp
    }
}
