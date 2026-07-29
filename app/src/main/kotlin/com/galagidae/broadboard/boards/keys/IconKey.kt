/*
* BroadBoard – A keyboard for users with low vision
* Copyright (C) 2026  Anthony Benbrook
*   
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*   
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*   
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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

