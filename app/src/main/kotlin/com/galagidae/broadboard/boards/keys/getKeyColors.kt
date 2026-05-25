package com.galagidae.broadboard.boards.keys

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.galagidae.broadboard.*

@Composable
fun getKeyColors(isPressed: Boolean): ButtonColors {
    val colors = LocalColorTheme.current

    return ButtonDefaults.buttonColors(
        containerColor = if (isPressed) colors.keyBackgroundPressed else colors.keyBackground,
        contentColor = if (isPressed) colors.keyLabelPressed else colors.keyLabel
    )
}