package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

fun Modifier.repeatClick(
    interactionSource: MutableInteractionSource,
    enabled: Boolean = true,
    initialDelayMillis: Long = 500L,
    repeatIntervalMillis: Long = 100L,
    onClick: (() -> Unit)? = null,
    onRelease: () -> Unit = {},
): Modifier = composed {
    val currentOnClick by rememberUpdatedState(onClick)
    val currentOnRelease by rememberUpdatedState(onRelease)
    val currentEnabled by rememberUpdatedState(enabled)
    pointerInput(interactionSource) {
        coroutineScope {
            awaitEachGesture {
                val down = awaitFirstDown(requireUnconsumed = false)

                if (!currentEnabled) {
                    waitForUpOrCancellation()
                    return@awaitEachGesture
                }

                // pressed visual state
                val press = PressInteraction.Press(down.position)
                launch { interactionSource.emit(press) }

                var repeated = false
                val repeatJob = launch {
                    delay(initialDelayMillis)
                    repeated = true
                    while (isActive) {
                        currentOnClick?.invoke()
                        delay(repeatIntervalMillis)
                    }
                }

                val up = waitForUpOrCancellation()
                repeatJob.cancel()

                launch {
                    interactionSource.emit(
                        if (up != null) PressInteraction.Release(press)
                        else PressInteraction.Cancel(press)
                    )
                }

                // a quick tap that released before repeating started = one click
                if (up != null && !repeated) currentOnClick?.invoke()
                if (up != null) currentOnRelease()
            }
        }
    }
}