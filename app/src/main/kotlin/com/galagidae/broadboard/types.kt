package com.galagidae.broadboard

import androidx.annotation.StringRes

sealed class Key

data class Character(
    val primary: Char,
    val secondary: Char,
) : Key()

data class Symbol(
    val character: Char,
    @param:StringRes val description: Int? = null
)

data class SymbolSet(
    val primary: Symbol,
    val secondary: Symbol,
) : Key()

data class Alternate(
    val primary: Character,
    val rows: List<List<SymbolSet>>
) : Key()

data class Emoji(
    val primary: String,
    val secondary: String,
) : Key()

object Enter : Key()

object Contextual : Key()

object Alpha : Key()

object Menu : Key()

data class Space(
    val multiplier: Float,
) : Key()

enum class ShiftMode {
    NORMAL, SHIFT, LOCK
}

enum class InputContext {
    NORMAL, URL, EMAIL
}

enum class BoardMode {
    ALPHANUMERIC, SYMBOLS, EMOJIS, NUMERIC, MENU
}

enum class StandardActionType {
    DONE, GO, NEXT, PREVIOUS, SEARCH, SEND
}

sealed interface ActionKey {
    data class Standard(val id: Int, val actionType: StandardActionType) : ActionKey
    data class Custom(val id: Int, val label: String) : ActionKey
    object Newline : ActionKey   // no action, or NO_ENTER_ACTION set
}

enum class Orientation {
    LANDSCAPE, PORTRAIT
}
