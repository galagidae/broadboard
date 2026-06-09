package com.galagidae.broadboard.boards.keys

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

@Composable
fun ModeKey (
    label: String,
    onClick: (() -> Unit)? = null,
    @StringRes description: Int,
    modifier: Modifier = Modifier,
) {
    val description = stringResource(description)

    ModeKey(
        label = label,
        onClick = onClick,
        description = description,
        modifier = modifier
    )
}

@Composable
fun ModeKey (
    label: String,
    onClick: (() -> Unit)? = null,
    description: String,
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    
    BaseKey (
        modifier = modifier,
        onClick = onClick,
        description = description
    ) {
        Text(
            text = label,
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = dpToSp(sizes.modeKeyFontSize),
            fontWeight = FontWeight.Bold            
        )
    }
}
