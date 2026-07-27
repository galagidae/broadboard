package com.galagidae.broadboard.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource

@Composable
fun AccessibilityAnnouncement(
    @StringRes messageRes: Int,
    key: Any?,
    vararg formatArgs: Any
) {
    val view = LocalView.current
    val message = stringResource(messageRes, *formatArgs)

    LaunchedEffect(key) {
        view.announceForAccessibility(message)
    }
}