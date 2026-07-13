package com.galagidae.broadboard.layout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.*

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