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

package com.galagidae.broadboard.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

fun Modifier.bodyKey(): Modifier = this
    .fillMaxHeight()
    .aspectRatio(1f)

fun Modifier.highlightBorder(
    highlights: Boolean,
    color: Color,
    cornerSize: Dp,
): Modifier = this.then(
    if (highlights)
        Modifier.border(9.dp, color, shape = RoundedCornerShape(cornerSize))
    else
        Modifier
)