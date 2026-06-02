package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

@Composable
fun CharacterKey (
    onKey: (Char) -> Unit,    
    modifier: Modifier = Modifier,
    character: Character
) {
    val sizes = LocalSizeTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsStateMin()
    val vibrate = rememberHapticFeedback()    

    Button (
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f),
        shape = RoundedCornerShape(3.dp),
        colors = getKeyColors(isPressed),
        interactionSource = interactionSource,
        onClick = {
            onKey(character.primary)
            vibrate()
        }
    ) {
        Text(
            text = character.primary.toString(),
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
