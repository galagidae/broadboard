package com.galagidae.broadboard.layout

import android.view.ViewConfiguration
import androidx.compose.animation.core.AnimationState
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.animateDecay
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.IntSize
import kotlin.math.abs
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun PanBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var viewportSize by remember { mutableStateOf(IntSize.Zero) }
    var contentSize by remember { mutableStateOf(IntSize.Zero) }
    val scope = rememberCoroutineScope()

    // Main drag offset
    val currentOffset = remember { mutableStateOf(Offset.Zero) }
    
    // fling state
    var flingJobX by remember { mutableStateOf<Job?>(null) }
    var flingJobY by remember { mutableStateOf<Job?>(null) }
    val flingDecay: DecayAnimationSpec<Float> = remember { exponentialDecay(frictionMultiplier = 1f) }
    var isFlingingX by remember { mutableStateOf(false) }
    var isFlingingY by remember { mutableStateOf(false) }
    val isFlinging = isFlingingX || isFlingingY    
    val minFlingVelocity = ViewConfiguration.get(LocalContext.current).scaledMinimumFlingVelocity

    // Prevent dragging keyboard off the screen
    fun getClampedOffset(current: Offset, delta: Offset): Offset {
        val maxX = (contentSize.width - viewportSize.width).toFloat().coerceAtLeast(0f)
        val maxY = (contentSize.height - viewportSize.height).toFloat().coerceAtLeast(0f)
        
        return Offset(
            x = (current.x + delta.x).coerceIn(-maxX, 0f),
            y = (current.y + delta.y).coerceIn(-maxY, 0f),
        )
    }

    val draggableState = rememberDraggable2DState { delta ->
        flingJobX?.cancel()
        flingJobY?.cancel()
        currentOffset.value = getClampedOffset(currentOffset.value, delta)
    }

    Box(
        modifier = modifier
            .onSizeChanged { viewportSize = it }
            .clipToBounds()
            .draggable2D(
                state = draggableState,
                onDragStopped = { flingVelocity  ->
                    val maxX = (contentSize.width - viewportSize.width)
                        .toFloat().coerceAtLeast(0f)
                    val maxY = (contentSize.height - viewportSize.height)
                        .toFloat().coerceAtLeast(0f)

                    if (abs(flingVelocity.x) > minFlingVelocity) {
                        flingJobX = scope.launch {
                            isFlingingX = true

                            try {
                                AnimationState(
                                    initialValue = currentOffset.value.x,
                                    initialVelocity = flingVelocity.x,
                                ).animateDecay(flingDecay) {
                                    val clamped = value.coerceIn(-maxX, 0f)
                                    currentOffset.value = currentOffset.value.copy(x = clamped)
                                    if (clamped != value || abs(velocity) < 200f) cancelAnimation()                                    
                                }
                            }
                            finally {
                                isFlingingX = false
                            }
                        }
                    }

                    if (abs(flingVelocity.y) > minFlingVelocity) {
                        flingJobY = scope.launch {
                            isFlingingY = true
                            try {
                                AnimationState(
                                    initialValue = currentOffset.value.y,
                                    initialVelocity = flingVelocity.y,
                                ).animateDecay(flingDecay) {
                                    val clamped = value.coerceIn(-maxY, 0f)
                                    currentOffset.value = currentOffset.value.copy(y = clamped)
                                    if (clamped != value || abs(velocity) < 200f) cancelAnimation()                                    
                                }
                            }
                            finally {
                                isFlingingY = false
                            }
                        }
                    }
                }
            )
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize(align = Alignment.TopStart, unbounded = true)
                .onSizeChanged { contentSize = it }
                .graphicsLayer {
                    translationX = currentOffset.value.x
                    translationY = currentOffset.value.y
                },
        ) {
            content()
        }

        // Intercepts taps during fling, cancels it, swallows the tap
        if (isFlinging) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .pointerInput(Unit) {
                        awaitPointerEventScope {
                            while (true) {
                                val event = awaitPointerEvent(PointerEventPass.Initial)

                                if (event.changes.any { it.pressed }) {
                                    flingJobX?.cancel()
                                    flingJobY?.cancel()
                                    
                                    // Consume all changes so nothing below sees this down event
                                    event.changes.forEach { it.consume() }
                                }
                            }
                        }
                    }
            )
        }
    }
}