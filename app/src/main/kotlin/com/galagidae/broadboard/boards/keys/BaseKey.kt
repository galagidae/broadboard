/*
* BroadBoard – A keyboard for users with low vision
* Copyright (C) 2026  Anthony Benbrook
*   
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*   
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*   
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
    @StringRes longDescription: Int? = null,
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
        longDescription = longDescription,
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
    @StringRes longDescription: Int? = null,
    repeating: Boolean = false,
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier,
    content: @Composable BaseKeyScope.() -> Unit
) {
    BaseKey(
        onClick = onClick,
        onLongClick = onLongClick,
        description = description.toString(),
        longDescription = longDescription,
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
    @StringRes longDescription: Int? = null,
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

    val longDesc = if (longDescription != null && onLongClick != null) 
        stringResource(longDescription)
    else
        null
    
    Box (
        modifier = modifier
            .clearAndSetSemantics {
                contentDescription = description
                if (longDesc != null) {
                    onLongClick(label = longDesc) { onLongClick?.invoke(); true }
                }
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
