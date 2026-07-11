package com.galagidae.broadboard.boards.keys

import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

interface BaseKeyScope {
    val isPressed: Boolean
}

@Composable
fun BaseKey (
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    @StringRes description: Int,
    repeating: Boolean = false,
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier,
    content: @Composable BaseKeyScope.() -> Unit
) {
    val description = stringResource(description)

    BaseKey(
        onClick = onClick,
        onLongClick = onLongClick,
        description = description,
        repeating = repeating,
        backgroundOverride = backgroundOverride,
        modifier = modifier,
        content = content
    )
}

@Composable
fun BaseKey (
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    description: Char,
    repeating: Boolean = false,
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier,
    content: @Composable BaseKeyScope.() -> Unit
) {
    BaseKey(
        onClick = onClick,
        onLongClick = onLongClick,
        description = description.toString(),
        repeating = repeating,
        backgroundOverride = backgroundOverride,
        modifier = modifier,
        content = content
    )    
}

@Composable
fun BaseKey (
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    description: String,
    repeating: Boolean = false,
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier,
    content: @Composable BaseKeyScope.() -> Unit,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val vibratePref = LocalVibrate.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsStateMin()
    val vib = rememberHapticFeedback()    
    val vibrate = { if (vibratePref) vib() else {} }

    val scope = object : BaseKeyScope {
        override val isPressed = isPressed
    }

    val clickable = if (repeating) {
        Modifier.repeatClick(
            interactionSource = interactionSource,
            onClick = { onClick?.invoke() },
            onRelease = vibrate
        )
    } else {
        Modifier.combinedClickable(
            interactionSource = interactionSource,
            onClick = {
                onClick?.invoke()
                vibrate()
            },
            onLongClick = {
                onLongClick?.invoke() ?: onClick?.invoke()
                vibrate()
            }
        )
    }
    
    Box (
        modifier = modifier
            .clearAndSetSemantics {
                contentDescription = description
            }
            .clip(RoundedCornerShape(sizes.keyCorners))
            .background(
                if (isPressed) 
                    colors.keyBackgroundPressed 
                else 
                    backgroundOverride ?: colors.keyBackground)
            .then(clickable),
        contentAlignment = Alignment.Center,
    ) {
        scope.content()
    }
}
