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

val symbols: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = exclamation,
            secondary = exclamationInverted,
        ),
        SymbolSet(
            primary = quoteSingle,
            secondary = quoteDouble,
        ),
        SymbolSet(
            primary = atSign,
            secondary = hashtag,
        ),
        SymbolSet(
            primary = dollarSign,
            secondary = poundSign,
        ),
        SymbolSet(
            primary = asterisk,
            secondary = ampersand,
        ),
        SymbolSet(
            primary = dash,
            secondary = underscore,
        ),
        SymbolSet(
            primary = bracketLeft,
            secondary = braceLeft,
        ),
        SymbolSet(
            primary = bracketRight,
            secondary = braceRight,
        ),                                                        
        SymbolSet(
            primary = division,
            secondary = multiplication,
        ),
        SymbolSet(
            primary = graveAccent,
            secondary = tilde,
        ),
        SymbolSet(
            primary = pipe,
            secondary = paragraph,
        ),
        SymbolSet(
            primary = ellipsis,
            secondary = trademark,
        ),
        SymbolSet(
            primary = copyright,
            secondary = registered,
        ),
    ),
    listOf(
        Alpha,
        SymbolSet(
            primary = question,
            secondary = questionInverted,
        ),
        SymbolSet(
            primary = colon,
            secondary = semicolon,
        ),
        SymbolSet(
            primary = percent,
            secondary = caret,
        ),
        SymbolSet(
            primary = euro,
            secondary = yen,
        ),
        SymbolSet(
            primary = equals,
            secondary = plus,
        ),
        SymbolSet(
            primary = slash,
            secondary = backslash,
        ),
        SymbolSet(
            primary = parenLeft,
            secondary = lessThan,
        ),
        SymbolSet(
            primary = parenRight,
            secondary = greaterThan,
        ),                                                        
        SymbolSet(
            primary = pi,
            secondary = infinity,
        ),
        SymbolSet(
            primary = cent,
            secondary = section,
        ),
        SymbolSet(
            primary = endash,
            secondary = emdash,
        ),
        SymbolSet(
            primary = degree,
            secondary = bullet,
        ),
        SymbolSet(
            primary = squareroot,
            secondary = checkmark,
        ),
    )
)

@Composable
fun SymbolsBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    shiftMode: ShiftMode,
    modifier: Modifier = Modifier
) {
    val sizes = LocalSizeTheme.current

    Column(
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        symbols.forEach { row ->
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
                            shiftMode = shiftMode
                        )
                        key is Alpha -> ModeKey(
                            modifier = Modifier
                                .height(sizes.rowHeight)
                                .aspectRatio(1f),
                            label = "abc",
                            description = R.string.key_alpha,
                            onClick = { onChangeMode?.invoke(BoardMode.ALPHANUMERIC) }
                        )
                        else -> {}
                    }
                }
            }
        }
    }
}