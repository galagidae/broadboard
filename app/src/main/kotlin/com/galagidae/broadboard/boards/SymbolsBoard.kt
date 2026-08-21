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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.enter
import com.galagidae.broadboard.boards.characters.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*
import com.galagidae.broadboard.utils.*

@Composable
fun SymbolsBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    shiftMode: ShiftMode,
    currentLocale: State<String>,
    modifier: Modifier = Modifier
) {
    val sizes = LocalSizeTheme.current
    val barEnabled = LocalMenuBarOption.current != "space"

    Column(
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        val r =  when(currentLocale.value) {
            "ru" -> ruSymbolsTwoRow to ruSymbolsThreeRow
            "tr" -> trSymbolsTwoRow to trSymbolsThreeRow
            "uk" -> ukSymbolsTwoRow to ukSymbolsThreeRow
            else -> defaultSymbolsTwoRow to defaultSymbolsThreeRow
        }
        val rows = if (sizes.rowCount > 2) r.second else r.first
            
        rows.forEach { row ->
            Row(
                modifier = modifier
                    .height(sizes.rowHeight),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            ) {
                row.forEach { key ->
                    when {
                        key is SymbolSet -> SymbolKey(
                            symbolSet = key,
                            onKey = onKey,
                            shiftMode = shiftMode,
                            modifier = Modifier.bodyKey()
                        )
                        key is Alpha && barEnabled -> ModeKey(
                            modifier = Modifier.bodyKey(),
                            label = "abc",
                            description = R.string.key_alpha,
                            onClick = { onChangeMode?.invoke(BoardMode.ALPHANUMERIC) }
                        )
                        key is Menu && barEnabled -> MenuKey(
                            modifier = Modifier.bodyKey(),                            
                            onClick = { onChangeMode?.invoke(BoardMode.MENU) }
                        )
                        else -> {}
                    }
                }
            }
        }
    }
}
