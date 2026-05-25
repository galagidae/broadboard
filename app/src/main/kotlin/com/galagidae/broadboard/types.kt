package com.galagidae.broadboard

sealed class Key

data class Character(
    val primary: Char,
    val secondary: Char,
) : Key()

object Enter : Key()