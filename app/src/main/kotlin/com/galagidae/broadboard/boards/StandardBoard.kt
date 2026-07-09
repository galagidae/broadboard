package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
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
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onClickAlternate: ((Alternate) -> Unit)? = null,
    actionKey: State<ActionKey>,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val menuBarOption = LocalMenuBarOption.current
    val naturalLayout = LocalNaturalLayout.current

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
            enUS.forEach { row ->
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
                                        .fillMaxHeight(),
                                    icon = icon,
                                    description = description
                                )
                            }
                            key is Contextual -> {
                                val char = when(inputContext.value) {
                                    InputContext.NORMAL -> ','
                                    InputContext.URL -> '/'
                                    InputContext.EMAIL -> '@'
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
