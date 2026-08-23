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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*
import com.galagidae.broadboard.utils.*

@Composable
fun StandardBoard(
    onKey: ((Char) -> Unit)? = null,
    onEnter: (() -> Unit)? = null,
    shiftMode: ShiftMode,
    inputContext: State<InputContext>,
    currentLocale: State<String>,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickAlternate: ((Alternate) -> Unit)? = null,
    actionKey: State<ActionKey>,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val menuBarOption = LocalMenuBarOption.current
    val naturalLayout = LocalNaturalLayout.current
    val highlights = LocalHighlights.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(sizes.modeBarGap),
    ) {
        if (menuBarOption != "space") {
            Column(modifier = Modifier
                    .width(sizes.rowHeight),
                verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            ) {
                MenuKey(
                    onClick = { onChangeMode?.invoke(BoardMode.MENU) },
                    modifier = Modifier.bodyKey()
                )
                ModeKey(
                    label = "?!;()",
                    description = R.string.key_symbols,
                    onClick = { onChangeMode?.invoke(BoardMode.SYMBOLS) },
                    modifier = Modifier.bodyKey()
                )
                ModeKey(
                    label = "123",
                    description = R.string.key_numeric,
                    onClick = { onChangeMode?.invoke(BoardMode.NUMERIC) },
                    modifier = Modifier.bodyKey()
                )            
                ModeKey(
                    label = "🙂",
                    description = R.string.key_emojis,
                    onClick = { onChangeMode?.invoke(BoardMode.EMOJIS) },
                    modifier = Modifier.bodyKey()
                )
            }
        }

        Column(
            modifier = Modifier
                .background(colors.mainBackground)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            horizontalAlignment = Alignment.Start
        ) {
            val localeRows = when(currentLocale.value) {
                "cs" -> csCZ
                "de" -> deDE
                "el" -> elGR
                "en-GB" -> enGB
                "es-419" -> es419
                "es-ES" -> esES
                "fr" -> frFR
                "id" -> enUS
                "it" -> itIT
                "ms" -> enUS
                "nl" -> nlNL
                "pl" -> plPL
                "pt-BR" -> ptBR
                "pt-PT" -> ptPT
                "ro" -> roRO
                "ru" -> ruRU
                "sk" -> skSK
                "tr" -> trTR
                "uk" -> ukUA
                else -> enUS
            }

            localeRows.forEach { row ->
                Row(
                    modifier = modifier
                        .height(sizes.rowHeight),
                    horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing),
                ) {
                    row.forEach { key ->
                        when {
                            key is Character -> CharacterKey(
                                character = key,
                                onKey = onKey,
                                shiftMode = shiftMode,
                                modifier = Modifier.bodyKey()
                            )
                            key is SymbolSet -> SymbolKey(
                                symbolSet = key,
                                onKey = onKey,
                                shiftMode = shiftMode,
                                modifier = Modifier.bodyKey()
                            )
                            key is Alternate -> CharacterKey(
                                character = key.primary,
                                longDescription = R.string.key_alternate,
                                onKey = onKey,
                                onLongClick = { onClickAlternate?.invoke(key) },
                                shiftMode = shiftMode,
                                modifier = Modifier.bodyKey()
                            )
                            key is Enter -> {
                                val (description, icon) = when(val v = actionKey.value) {
                                    is ActionKey.Standard -> when(v.actionType) {
                                        StandardActionType.DONE -> stringResource(R.string.action_done) to check
                                        StandardActionType.GO -> stringResource(R.string.action_go) to go
                                        StandardActionType.NEXT -> stringResource(R.string.action_next) to next_arrow
                                        StandardActionType.PREVIOUS -> stringResource(R.string.action_previous) to prev_arrow
                                        StandardActionType.SEARCH -> stringResource(R.string.action_search) to search
                                        StandardActionType.SEND -> stringResource(R.string.action_send) to send
                                    }
                                    is ActionKey.Custom -> v.label to enter
                                    ActionKey.Newline -> stringResource(R.string.action_enter) to enter
                                }
                                IconKey(
                                    onClick = onEnter,
                                    modifier = Modifier
                                        .width(sizes.enterKeyWidth)
                                        .fillMaxHeight()
                                        .highlightBorder(highlights, colors.actionBorder, sizes.keyCorners),
                                    backgroundOverride = if (highlights) colors.actionBackground else null,
                                    icon = icon,
                                    description = description
                                )
                            }
                            key is Contextual -> {
                                val char = when(inputContext.value) {
                                    InputContext.URL -> '/'
                                    InputContext.EMAIL -> '@'
                                    else -> ','
                                }

                                CharacterKey(
                                    character = Character(
                                        primary = char,
                                        secondary = char
                                    ),
                                    onKey = onKey,
                                    modifier = Modifier.bodyKey()
                                )
                            }
                            key is Space && naturalLayout -> {
                                Box(modifier = Modifier.fillMaxHeight().width(sizes.keySize * key.multiplier))
                            }
                        }
                    }
                }
            }
        }
    }
}
