package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.interaction.*
import androidx.compose.runtime.*
import kotlinx.coroutines.*

/**
  * Keeps the pressed state `true` for at least [minDuration] milliseconds after the 
  * last press ends.
  *
  * This ensures pressed state color overrides are applied when hosted inside PanBox on quick taps. 
  * Otherwise the system default colors are applied. Longer presses don't appear to be affected
 **/
 @Composable
fun MutableInteractionSource.collectIsPressedAsStateMin(
    minDuration: Long = 120L
): State<Boolean> {
    val pressed = remember { mutableStateOf(false) }
    LaunchedEffect(this) {
        var activeCount = 0
        interactions.collect { i ->
            when (i) {
                is PressInteraction.Press -> {
                    activeCount++
                    pressed.value = true
                }
                is PressInteraction.Release -> {
                    activeCount = (activeCount - 1).coerceAtLeast(0)
                    launch {
                        delay(minDuration)
                        if (activeCount == 0) pressed.value = false
                    }
                }
                is PressInteraction.Cancel -> {
                    activeCount = (activeCount - 1).coerceAtLeast(0)
                    launch {
                        delay(minDuration)
                        if (activeCount == 0) pressed.value = false
                    }
                }
            }
        }
    }
    return pressed
}