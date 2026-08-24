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
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.utils.*
import com.galagidae.broadboard.icons.*

@Composable
fun NavigationBoard(
    visibleWidth: Dp,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickKeyboardPicker: (() -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    onNavigate: ((direction: NavigationDirection) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val context = LocalContext.current    
    val highlights = LocalHighlights.current

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.panBoxHeight)
            .width(visibleWidth),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        MenuRow() {
            IconKey(
                modifier = menuKey,
                onClick = { onNavigate?.invoke(NavigationDirection.LEFT) },
                icon = arrow_left,
                description = R.string.key_cursor_left,
                backgroundOverride = colors.modeKeyBackground
            )
            IconKey(
                modifier = menuKey,
                onClick = { onNavigate?.invoke(NavigationDirection.RIGHT) },
                icon = arrow_right,
                description = R.string.key_cursor_right,
                backgroundOverride = colors.modeKeyBackground
            )
        }
        MenuRow() {
            IconKey(
                modifier = menuKey,
                onClick = { onNavigate?.invoke(NavigationDirection.UP) },
                icon = arrow_left_double,
                description = R.string.key_cursor_home,
                backgroundOverride = colors.modeKeyBackground
            )
            IconKey(
                modifier = menuKey,
                onClick = { onNavigate?.invoke(NavigationDirection.DOWN) },
                icon = arrow_right_double,
                description = R.string.key_cursor_end,
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