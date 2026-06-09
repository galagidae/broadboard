package com.galagidae.broadboard.utils

import androidx.compose.runtime.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*

/**
  * Converts dp to sp for fontSize
  * Normally you would never do this as it overrides a user's accessibility preferences
  * But this is an accessibility keyboard that will have size options that scale
  * key font size much more than the system would on its own.
**/
@Composable
fun dpToSp(dp: Dp): TextUnit {
    val density = LocalDensity.current
    return with(density) {
        (dp.toPx() / fontScale).sp
    }
}
