package com.galagidae.broadboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.keys.BottomRowKey


@Composable
fun BottomRow(
    modifier: Modifier = Modifier,
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .height(sizes.bottomRowHeight)
            .fillMaxWidth()
            .background(colors.mainBackground)
            .padding(horizontal = 8.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BottomRowKey(
            modifier = Modifier.weight(1f),
            icon = shift,
            description = stringResource(R.string.key_shift)
        )        
        BottomRowKey(
            modifier = Modifier.weight(2f),
            icon = space_bar,
            description = stringResource(R.string.key_space)
        )
        BottomRowKey(
            modifier = Modifier.weight(1f),
            icon = backspace,
            description = stringResource(R.string.key_delete)
        )              
    }
}