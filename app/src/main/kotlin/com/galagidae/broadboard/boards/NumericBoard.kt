package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.*
import com.galagidae.broadboard.boards.keys.*

@Composable
fun NumericBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    orientation: Orientation,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    val rows = when(orientation) {
            Orientation.LANDSCAPE -> numericLayout_land
            else -> numericLayout
    }

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.appHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        rows.forEach { row ->
            NumberRow(row, onKey)
        }

        if (orientation == Orientation.PORTRAIT) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
            ) {
                MenuKey(
                    onClick = { onChangeMode?.invoke(BoardMode.MENU) },
                    modifier = Modifier.weight(1f)
                )
                NumberKey(
                    number = '0',
                    onClick = onKey,
                    modifier = Modifier.weight(1f)
                )
                IconKey(
                    onClick = onBackspace,
                    icon = backspace,
                    description = R.string.key_delete,
                    repeating = true,
                    modifier = Modifier.fillMaxHeight().weight(1f)
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.NumberRow(
    numbers: List<Char>,
    onKey: ((Char) -> Unit)? = null
) {
    val sizes = LocalSizeTheme.current

    Row(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
    ) {
        numbers.forEach { n ->
            NumberKey(
                number = n, 
                onClick = onKey,
                modifier = Modifier.weight(1f)
            )
        }                
    }
}

@Composable
private fun NumberKey(
    number: Char, 
    onClick: ((char: Char) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    BaseKey(
        description = number,
        onClick = { onClick?.invoke(number) },
        modifier = modifier.fillMaxHeight()
    ) {
        Text(
            text = number.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = sizes.keyNumericFontSize
        )
    }
}

private val numericLayout = listOf(
    listOf('1', '2', '3'),
    listOf('4', '5', '6'),
    listOf('7', '8', '9'),
)

private val numericLayout_land = listOf(
    listOf('1', '2', '3', '4', '5'),
    listOf('6', '7', '8', '9', '0')
)
