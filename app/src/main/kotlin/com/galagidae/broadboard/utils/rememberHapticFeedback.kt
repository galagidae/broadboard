package com.galagidae.broadboard.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun rememberHapticFeedback(): () -> Unit {
    val haptic = LocalHapticFeedback.current
    
    return { haptic.performHapticFeedback(HapticFeedbackType.LongPress) }
}