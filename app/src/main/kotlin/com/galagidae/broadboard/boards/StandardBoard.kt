package com.galagidae.broadboard.boards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.icons.enter
import com.galagidae.broadboard.boards.keys.*
import com.galagidae.broadboard.boards.locales.*

@Composable
fun StandardBoard(
    onKey: (Char) -> Unit,    
    onEnter: () -> Unit,
    shiftMode: ShiftMode,
    inputContext: InputContext,
    modifier: Modifier = Modifier
) {
    val colors = LocalColorTheme.current
    val sizes = LocalSizeTheme.current

    Column(
        modifier = modifier
            .background(colors.mainBackground)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        enUS.forEach { row ->
            Row(
                modifier = modifier
                    .height(sizes.rowHeight),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                row.forEach { key ->
                    when {
                        key is Character -> CharacterKey(
                            character = key,
                            onKey = onKey,
                            shiftMode = shiftMode
                        )
                        key is Enter -> IconKey(
                            onClick = onEnter,
                            modifier = Modifier
                                .width(sizes.enterKeyWidth),
                            icon = enter,
                            description = stringResource(R.string.key_enter)
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
                            )
                        }
                    }
                }
            }
        }
    }
}