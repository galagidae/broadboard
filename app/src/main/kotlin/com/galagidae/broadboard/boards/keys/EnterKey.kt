package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import androidx.compose.ui.platform.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.enter
import com.galagidae.broadboard.utils.*

@Composable
fun EnterKey (
    onEnter: () -> Unit,
    modifier: Modifier = Modifier
) {
    val sizes = LocalSizeTheme.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsStateMin()
    val vibrate = rememberHapticFeedback()    

    Button (
        modifier = modifier
            .fillMaxHeight()
            .width(sizes.enterKeyWidth),
        shape = RoundedCornerShape(3.dp),
        colors = getKeyColors(isPressed),
        interactionSource = interactionSource,
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
        onClick = {
            onEnter()
            vibrate()
        }
    ) {
        Icon(
            modifier = Modifier
                .size(sizes.keyIconSize),
            imageVector = enter,
            contentDescription = stringResource(R.string.key_enter),
        )
    }
}

/**
  * Converts dp to sp for fontSize
  * Normally you would never do this as it overrides a user's accessibility preferences
  * But this is an accessibility keyboard that will have size options that scale
  * key font size much more than the system would on its own.
**/
@Composable
private fun dpToSp(dp: Dp): TextUnit {
    val density = LocalDensity.current
    return with(density) {
        (dp.toPx() / fontScale).sp
    }
}
