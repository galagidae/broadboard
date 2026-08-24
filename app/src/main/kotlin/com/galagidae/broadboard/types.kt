/*
* BroadBoard – A keyboard for users with low vision
* Copyright (C) 2026  Anthony Benbrook
*   
*   This program is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*   
*   This program is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*   
*   You should have received a copy of the GNU General Public License
*   along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

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
    NORMAL, URL, EMAIL, NUMERIC
}

enum class BoardMode {
    ALPHANUMERIC, SYMBOLS, EMOJIS, NUMERIC, MENU, NAVIGATION
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

enum class NavigationDirection {
    UP, DOWN, LEFT, RIGHT
}
