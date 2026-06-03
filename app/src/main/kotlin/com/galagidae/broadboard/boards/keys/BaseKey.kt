package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

interface BaseKeyScope {
    val isPressed: Boolean
}

@Composable
fun BaseKey (
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    content: @Composable BaseKeyScope.() -> Unit
) {
    val colors = LocalColorTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsStateMin()
    val vibrate = rememberHapticFeedback()    

    val scope = object : BaseKeyScope {
        override val isPressed = isPressed
    }    
    
    Box (
        modifier = modifier
            .background(if (isPressed) colors.keyBackgroundPressed else colors.keyBackground)
            .clip(RoundedCornerShape(3.dp))
            .combinedClickable(
                interactionSource = interactionSource,
                onClick = {
                    onClick?.invoke()
                    vibrate()
                },
                onLongClick = {
                    onLongClick?.invoke() ?: onClick?.invoke()
                    vibrate()
                }
            ),
        contentAlignment = Alignment.Center,
    ) {
        scope.content()
    }
}
