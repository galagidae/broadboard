package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.Text
import com.galagidae.broadboard.*

@Composable
fun IconKey(
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    BaseKey(
        modifier = modifier
            .fillMaxHeight(),
        onClick = onClick,
        onLongClick = onLongClick,
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

