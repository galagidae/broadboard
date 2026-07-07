package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.enter
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*
import com.galagidae.broadboard.utils.*

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
        val rows = if (sizes.rowCount > 2) 
            threeRowSymbols 
        else 
            twoRowSymbols
            
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
                        key is Alpha -> ModeKey(
                            modifier = Modifier.bodyKey(),
                            label = "abc",
                            description = R.string.key_alpha,
                            onClick = { onChangeMode?.invoke(BoardMode.ALPHANUMERIC) }
                        )
                        key is Menu -> MenuKey(
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

private val rowOne: List<Key> = listOf(
    Menu,
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
)

private val rowTwo: List<Key> = listOf(
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

private const val THREE_ROW_SPLIT = 10

private val twoRowSymbols: List<List<Key>> = listOf(
    rowOne,
    rowTwo,
)

private val threeRowSymbols: List<List<Key>> = listOf(
    rowOne.take(THREE_ROW_SPLIT),
    rowTwo.take(THREE_ROW_SPLIT),
    rowOne.drop(THREE_ROW_SPLIT) + rowTwo.drop(THREE_ROW_SPLIT),
)
