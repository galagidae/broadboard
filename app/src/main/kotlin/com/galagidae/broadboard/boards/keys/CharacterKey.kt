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
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*

@Composable
fun CharacterKey (
    onKey: ((Char) -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    shiftMode: ShiftMode = ShiftMode.NORMAL,
    character: Character,
    @StringRes longDescription: Int? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val currentChar = if (shiftMode == ShiftMode.NORMAL) 
        character.primary
    else 
        character.secondary

    BaseKey (
        modifier = modifier,
        description = currentChar,
        longDescription = longDescription,
        onClick = {
            onKey?.invoke(currentChar)
        },
        onLongClick = onLongClick
    ) {
        Text(
            text = currentChar.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = sizes.keyFontSize
        )
    }
}
