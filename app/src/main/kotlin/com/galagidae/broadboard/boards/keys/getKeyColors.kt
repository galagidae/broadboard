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

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.galagidae.broadboard.*

@Composable
fun getKeyColors(isPressed: Boolean): ButtonColors {
    val colors = LocalColorTheme.current

    return ButtonDefaults.buttonColors(
        containerColor = if (isPressed) colors.keyBackgroundPressed else colors.keyBackground,
        contentColor = if (isPressed) colors.keyLabelPressed else colors.keyLabel
    )
}