package com.galagidae.broadboard.boards.keys

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import com.galagidae.broadboard.*

@Composable
fun IconKey(
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    icon: ImageVector,
    @StringRes description: Int,
    @StringRes longDescription: Int? = null,
    repeating: Boolean = false,    
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier
) {
    val description = stringResource(description)

    IconKey(
        onClick = onClick,
        onLongClick = onLongClick,
        icon = icon,
        description = description,
        longDescription = longDescription,
        repeating = repeating,
        backgroundOverride = backgroundOverride,
        modifier = modifier,
    )
}

@Composable
fun IconKey(
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    icon: ImageVector,
    description: String,
    @StringRes longDescription: Int? = null,
    repeating: Boolean = false,
    backgroundOverride: Color? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    BaseKey(
        modifier = modifier,
        onClick = onClick,
        description = description,
        longDescription = longDescription,
        repeating = repeating,
        onLongClick = onLongClick,
        backgroundOverride = backgroundOverride
    ) {
        Icon(
            modifier = Modifier
                .size(sizes.keyIconSize),
            imageVector = icon,
            tint = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            contentDescription = description,
        )
    }
}

