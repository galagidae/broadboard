package com.galagidae.broadboard.boards.keys

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import com.galagidae.broadboard.*
import com.galagidae.broadboard.utils.*

@Composable
fun SymbolKey (
    onKey: ((Char) -> Unit)? = null,
    shiftMode: ShiftMode = ShiftMode.NORMAL,
    symbolSet: SymbolSet,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current
    val currentSymbol = if (shiftMode == ShiftMode.SHIFT) 
        symbolSet.secondary
    else 
        symbolSet.primary
    val description = if (currentSymbol.description != null) 
        stringResource(currentSymbol.description) 
    else
        currentSymbol.character.toString()

    BaseKey (
        modifier = modifier
            .fillMaxHeight()
            .aspectRatio(1f),
        description = description,
        onClick = {
            onKey?.invoke(currentSymbol.character)
        }
    ) {
        Text(
            text = currentSymbol.character.toString(),
            color = if (isPressed) colors.keyLabelPressed else colors.keyLabel,
            fontSize = dpToSp(sizes.keyFontSize)
        )
    }
}
