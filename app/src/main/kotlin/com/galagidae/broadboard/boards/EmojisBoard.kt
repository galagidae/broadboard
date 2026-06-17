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
fun EmojisBoard(
    onKey: ((String) -> Unit)? = null,
    onChangeMode: ((mode: BoardMode) -> Unit)? = null,
    shiftMode: ShiftMode,
    modifier: Modifier = Modifier
) {
    val sizes = LocalSizeTheme.current

    Column(
        verticalArrangement = Arrangement.spacedBy(sizes.keySpacing),
    ) {
        emojis.forEach { row ->
            Row(
                modifier = modifier
                    .height(sizes.rowHeight),
                horizontalArrangement = Arrangement.spacedBy(sizes.keySpacing),
            ) {
                row.forEach { key ->
                    when {
                        key is Emoji -> EmojiKey(
                            modifier = Modifier.bodyKey(),
                            emoji = key,
                            onKey = onKey,
                            shiftMode = shiftMode
                        )
                        key is Menu -> MenuKey(
                            modifier = Modifier.bodyKey(),
                            onClick = { onChangeMode?.invoke(BoardMode.MENU) }
                        )
                        key is Alpha -> ModeKey(
                            modifier = Modifier.bodyKey(),
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

private val emojis: List<List<Key>> = listOf(
    listOf(
        Menu,
        Emoji(
            primary = "🙂",
            secondary = "🙁"
        ),
        Emoji(
            primary = "😀",
            secondary = "☹️"
        ),
        Emoji(
            primary = "😃",
            secondary = "😒"
        ),
        Emoji(
            primary = "😉",
            secondary = "😣"
        ),
        Emoji(
            primary = "😄",
            secondary = "😕"
        ),
        Emoji(
            primary = "😁",
            secondary = "😓"
        ),
        Emoji(
            primary = "😅",
            secondary = "😞"
        ),
        Emoji(
            primary = "🙃",
            secondary = "😠"
        ),
        Emoji(
            primary = "☺",
            secondary = "😐"
        ),
        Emoji(
            primary = "😊",
            secondary = "😑"
        )
    ),
    listOf(
        Alpha,
        Emoji(
            primary = "😂",
            secondary = "😭"
        ),
        Emoji(
            primary = "🤣",
            secondary = "😢"
        ),
        Emoji(
            primary = "😆",
            secondary = "😥"
        ),
        Emoji(
            primary = "😜",
            secondary = "😳"
        ),
        Emoji(
            primary = "🤪",
            secondary = "🥺"
        ),
        Emoji(
            primary = "😋",
            secondary = "😟"
        ),
        Emoji(
            primary = "😏",
            secondary = "😰"
        ),
        Emoji(
            primary = "😛",
            secondary = "😖"
        ),
        Emoji(
            primary = "😝",
            secondary = "😩"
        ),
        Emoji(
            primary = "🥴",
            secondary = "😪"
        )
    ),
    listOf(
        Emoji(
            primary = "😘",
            secondary = "😬"
        ),
        Emoji(
            primary = "🤗",
            secondary = "😨"
        ),
        Emoji(
            primary = "🥰",
            secondary = "😱"
        ),
        Emoji(
            primary = "😍",
            secondary = "😲"
        ),
        Emoji(
            primary = "🤩",
            secondary = "😧"
        ),
        Emoji(
            primary = "😌",
            secondary = "😦"
        ),
        Emoji(
            primary = "😗",
            secondary = "😮"
        ),
        Emoji(
            primary = "😙",
            secondary = "😯"
        ),
        Emoji(
            primary = "😚",
            secondary = "😫"
        ),
        Emoji(
            primary = "😔",
            secondary = "😵"
        ),
        Emoji(
            primary = "🥲",
            secondary = "😵"
        )
    ),
    listOf(
        Emoji(
            primary = "😎",
            secondary = "🙄"
        ),
        Emoji(
            primary = "😴",
            secondary = "🤨"
        ),
        Emoji(
            primary = "😇",
            secondary = "😶"
        ),
        Emoji(
            primary = "🤤",
            secondary = "🤧"
        ),
        Emoji(
            primary = "😷",
            secondary = "🤒"
        ),
        Emoji(
            primary = "🤑",
            secondary = "🤕"
        ),
        Emoji(
            primary = "🥳",
            secondary = "🥱"
        ),
        Emoji(
            primary = "🤓",
            secondary = "🤔"
        ),
        Emoji(
            primary = "🤠",
            secondary = "🤫"
        ),
        Emoji(
            primary = "🧐",
            secondary = "🤭"
        ),
        Emoji(
            primary = "😸",
            secondary = "😾"
        )
    ),
    listOf(
        Emoji(
            primary = "🤐",
            secondary = "🤯"
        ),
        Emoji(
            primary = "🌝",
            secondary = "🤢"
        ),
        Emoji(
            primary = "🌞",
            secondary = "🤮"
        ),
        Emoji(
            primary = "🌛",
            secondary = "😤"
        ),
        Emoji(
            primary = "🌜",
            secondary = "🤥"
        ),
        Emoji(
            primary = "🌚",
            secondary = "🥵"
        ),
        Emoji(
            primary = "💩",
            secondary = "🥶"
        ),
        Emoji(
            primary = "🤡",
            secondary = "😡"
        ),
        Emoji(
            primary = "👽",
            secondary = "🤬"
        ),
        Emoji(
            primary = "😈",
            secondary = "👿"
        ),
        Emoji(
            primary = "❤️",
            secondary = "💔"
        )
    )
)