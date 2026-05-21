package com.galagidae.broadboard

import androidx.compose.ui.draw.clipToBounds
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

private val ROW_1 = listOf("Q","W","E","R","T","Y","U","I","O","P")
private val ROW_2 = listOf("A","S","D","F","G","H","J","K","L")
private val ROW_3 = listOf("Z","X","C","V","B","N","M")

@Composable
fun placeholderKeyboard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .wrapContentSize()
            .padding(24.dp)
            .background(Color.Red),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row 1: Q–P
        KeyboardRow(keys = ROW_1)

        // Row 2: A–L
        KeyboardRow(keys = ROW_2)

        // Row 3: ⌫ + Z–M + ↵
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                4.dp,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            KeyboardKey(
                label = "⌫",
                modifier = Modifier.width(128.dp)
            )

            KeyboardRow(keys = ROW_3)

            KeyboardKey(
                label = "↵",
                modifier = Modifier.width(128.dp)
            )
        }
    }
}

@Composable
private fun KeyboardRow(
    keys: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            4.dp,
            Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        keys.forEach { key ->
            KeyboardKey(label = key)
        }
    }
}

@Composable
private fun KeyboardKey(
    label: String,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .defaultMinSize(
                minWidth = 128.dp,
                minHeight = 128.dp
            ),
        shape = RoundedCornerShape(3.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(
            horizontal = 4.dp,
            vertical = 0.dp
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp
        ),
        onClick = {}
    ) {
        Text(
            text = label,
            fontSize = 64.sp
        )
    }
}