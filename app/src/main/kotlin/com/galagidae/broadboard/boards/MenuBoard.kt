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

package com.galagidae.broadboard.boards

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*
import com.galagidae.broadboard.icons.*

@Composable
fun MenuBoard(
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickKeyboardPicker: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val context = LocalContext.current    

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.appHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        MenuRow() {
            ModeKey(
                modifier = menuKey,
                label = "abc",
                description = R.string.key_alpha,
                onClick = { onChangeMode?.invoke(BoardMode.ALPHANUMERIC) }
            )
            ModeKey(
                modifier = menuKey,
                label = "?!;()",
                description = R.string.key_symbols,
                onClick = { onChangeMode?.invoke(BoardMode.SYMBOLS) }
            )
            ModeKey(
                modifier = menuKey,
                label = "123",
                description = R.string.key_numeric,
                onClick = { onChangeMode?.invoke(BoardMode.NUMERIC) }
            )
        }
        MenuRow() {
            ModeKey(
                modifier = menuKey,
                label = "🙂",
                description = R.string.key_emojis,
                onClick = { onChangeMode?.invoke(BoardMode.EMOJIS) },
            )
            IconKey(
                modifier = menuKey,
                onClick = onClickKeyboardPicker,
                icon = keyboard,
                description = R.string.key_picker,
                backgroundOverride = colors.modeKeyBackground
            )
            IconKey(
                modifier = menuKey,
                onClick = {
                    val intent = Intent(context, PreferencesActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                },
                icon = preferences,
                description = R.string.key_preferences,
                backgroundOverride = colors.modeKeyBackground
            )            
        }
    }
}

private val RowScope.menuKey: Modifier
    get() = Modifier
        .fillMaxHeight()
        .weight(1f)

@Composable
private fun ColumnScope.MenuRow(
    content: @Composable RowScope.() -> Unit
) {
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .weight(1f),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        content()
    }
}
