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