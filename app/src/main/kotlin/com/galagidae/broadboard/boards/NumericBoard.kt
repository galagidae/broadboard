package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.*
import com.galagidae.broadboard.boards.keys.*

@Composable
fun NumericBoard(
    onKey: ((Char) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    onBackspace: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth()
            .height(sizes.appHeight),
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        numericLayout.forEach { row ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing)
            ) {
                row.forEach { n ->
                    NumberKey(
                        number = n, 
                        onClick = onKey,
                        modifier = Modifier.weight(1f)
                    )
                }                
            }
        }
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
                modifier = Modifier.fillMaxHeight().weight(1f)
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
