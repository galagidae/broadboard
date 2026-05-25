package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.icons.space_bar
import com.galagidae.broadboard.utils.*

@Composable
fun BottomRowKey(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String
) {
    val sizes = LocalSizeTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()    
    val vibrate = rememberHapticFeedback()    

    Button(
        modifier = modifier
            .fillMaxHeight(),
        colors = getKeyColors(isPressed),
        interactionSource = interactionSource,
        shape = RoundedCornerShape(3.dp),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
        onClick = {vibrate()}
    ) {
        Icon(
            modifier = Modifier
                .size(sizes.keyIconSize),
            imageVector = icon,
            contentDescription = description,
        )
    }
}

