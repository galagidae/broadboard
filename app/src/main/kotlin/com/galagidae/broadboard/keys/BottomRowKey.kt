package com.galagidae.broadboard.keys

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
import com.galagidae.broadboard.icons.space_bar

@Composable
fun BottomRowKey(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    description: String
) {
    val colors = LocalColorTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()    

    Button(
        modifier = modifier
            .fillMaxHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) colors.keyBackgroundPressed else colors.keyBackground,
            contentColor = if (isPressed) colors.keyLabelPressed else colors.keyLabel        
        ),
        interactionSource = interactionSource,
        shape = RoundedCornerShape(3.dp),
        onClick = {}
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp),
                imageVector = icon,
            contentDescription = description,
        )
    }
}

