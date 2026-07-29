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

package com.galagidae.broadboard.layout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.*
import com.galagidae.broadboard.utils.*

@Composable
fun Shell(
    onInput: (String) -> Unit,
    onBackspace: () -> Unit,
    onEnter: () -> Unit,
    autoShift: State<Boolean>,
    inputContext: State<InputContext>,
    onClickKeyboardPicker: (() -> Unit)? = null,
    actionKey: State<ActionKey>,
    modifier: Modifier = Modifier,
    currentLocale: State<String>
) {
    var shiftMode by remember { mutableStateOf<ShiftMode>(ShiftMode.NORMAL) }
    var alternate by remember { mutableStateOf<Alternate?>(null) }
    val configuration = LocalConfiguration.current    
    var boardMode by remember(inputContext.value) {
        when(inputContext.value) {
            InputContext.NUMERIC -> mutableStateOf(BoardMode.NUMERIC)
            else -> mutableStateOf(BoardMode.ALPHANUMERIC)
        }
    }    

    var orientation: Orientation = when(configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> Orientation.LANDSCAPE
        else -> Orientation.PORTRAIT
    }

    LaunchedEffect(currentLocale.value) {
        boardMode = BoardMode.ALPHANUMERIC
    }

    fun onInputInner(t: String): Unit {
        if (shiftMode == ShiftMode.SHIFT && boardMode == BoardMode.ALPHANUMERIC) {
            shiftMode = ShiftMode.NORMAL
        }
        onInput(t)
    }

    fun onChangeMode(mode: BoardMode) {
        boardMode = mode
        shiftMode = ShiftMode.NORMAL
    }

    fun onClickAlternate(alt: Alternate) {
        alternate = alt
    }

    fun closeAlternate() {
        boardMode = BoardMode.ALPHANUMERIC  
        alternate = null
    }

    fun onShift(longClicklc: Boolean) {
        when (shiftMode) {
            ShiftMode.NORMAL -> shiftMode = if (longClicklc) ShiftMode.LOCK 
                                            else ShiftMode.SHIFT
            ShiftMode.SHIFT -> shiftMode = if (longClicklc) ShiftMode.LOCK 
                                            else ShiftMode.NORMAL
            ShiftMode.LOCK -> shiftMode = ShiftMode.NORMAL
        }
    }

    fun onAlternateKey(c: Char) {
        onInputInner(c.toString())
        closeAlternate()
    }

    AccessibilityAnnouncement(
        messageRes = when(boardMode) {
            BoardMode.SYMBOLS -> R.string.mode_change_symbols
            BoardMode.EMOJIS -> R.string.mode_change_emojis
            BoardMode.NUMERIC -> R.string.mode_change_numeric
            BoardMode.MENU -> R.string.mode_change_menu
            else -> R.string.mode_change_alphanumeric
        },
        key = boardMode
    )
    AccessibilityAnnouncement(
        messageRes = when(shiftMode) {
            ShiftMode.SHIFT -> R.string.shift_change_on
            ShiftMode.LOCK -> R.string.shift_change_caps
            else -> R.string.shift_change_off
        },
        key = shiftMode
    )


    CompositionLocalProvider(
        LocalDensity provides Density(LocalDensity.current.density, fontScale = 1f)
    ) {
        when(orientation) {
            Orientation.LANDSCAPE -> LandscapeLayout(
                actionKey = actionKey,
                alternate = alternate,
                autoShift = autoShift.value,
                boardMode = boardMode,
                inputContext = inputContext,
                currentLocale = currentLocale,
                orientation = orientation,
                shiftMode = shiftMode,
                onAlternateKey = ::onAlternateKey,
                onBackspace = onBackspace,
                onChangeMode = ::onChangeMode,
                onClickClose = ::closeAlternate,
                onClickAlternate = ::onClickAlternate,
                onClickKeyboardPicker = onClickKeyboardPicker,
                onEnter = onEnter,
                onInput = ::onInputInner,
                onShift = ::onShift,
            )
            else -> PortraitLayout(
                actionKey = actionKey,
                alternate = alternate,
                autoShift = autoShift.value,
                boardMode = boardMode,
                inputContext = inputContext,
                currentLocale = currentLocale,
                orientation = orientation,
                shiftMode = shiftMode,
                onAlternateKey = ::onAlternateKey,
                onBackspace = onBackspace,
                onChangeMode = ::onChangeMode,
                onClickClose = ::closeAlternate,
                onClickAlternate = ::onClickAlternate,
                onClickKeyboardPicker = onClickKeyboardPicker,
                onEnter = onEnter,
                onInput = ::onInputInner,
                onShift = ::onShift,
            )
        }
    }
}