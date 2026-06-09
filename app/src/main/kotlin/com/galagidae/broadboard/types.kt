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

object Enter : Key()

object Contextual : Key()

object Alpha : Key()

enum class ShiftMode {
    NORMAL, SHIFT, LOCK
}

enum class InputContext {
    NORMAL, URL, EMAIL
}

enum class BoardMode {
    ALPHANUMERIC, SYMBOLS
}
