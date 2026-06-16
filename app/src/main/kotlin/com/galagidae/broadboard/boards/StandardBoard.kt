package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.enter
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*
import com.galagidae.broadboard.utils.*

@Composable
fun StandardBoard(
    onKey: (Char) -> Unit,    
    onEnter: () -> Unit,
    shiftMode: ShiftMode,
    inputContext: InputContext,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        Column(modifier = Modifier
                .width(sizes.rowHeight),
            verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
        ) {
            ModeKey(
                label = "?!;()",
                description = R.string.key_symbols,
                onClick = { onChangeMode?.invoke(BoardMode.SYMBOLS) },
                modifier = Modifier.bodyKey()
            )
            ModeKey(
                label = "123",
                description = R.string.key_symbols,
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
        Column(
            modifier = Modifier
                .background(colors.mainBackground)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            horizontalAlignment = Alignment.CenterHorizontally
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
                            key is Enter -> IconKey(
                                onClick = onEnter,
                                modifier = Modifier
                                    .width(sizes.enterKeyWidth),
                                icon = enter,
                                description = R.string.key_enter
                            )
                            key is Contextual -> {
                                val char = when(inputContext) {
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
                        }
                    }
                }
            }
        }
    }
}
