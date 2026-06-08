package com.galagidae.broadboard

sealed class Key

data class Character(
    val primary: Char,
    val secondary: Char,
    val lockable: Boolean = true,
) : Key()

object Enter : Key()

object Contextual : Key()

enum class ShiftMode {
    NORMAL, SHIFT, LOCK
}

enum class InputContext {
    NORMAL, URL, EMAIL
}
