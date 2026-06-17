package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.utils.*
import com.galagidae.broadboard.boards.icons.menu

@Composable
fun MenuKey (
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    IconKey (
        onClick = onClick,
        icon = menu,
        description = R.string.key_menu,
        modifier = modifier
    )
}
