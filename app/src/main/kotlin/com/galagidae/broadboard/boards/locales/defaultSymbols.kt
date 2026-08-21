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

package com.galagidae.broadboard.boards.locales

import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.characters.*

private val rowOne: List<Key> = listOf(
    Menu,
    SymbolSet(
        primary = exclamation,
        secondary = exclamationInverted,
    ),
    SymbolSet(
        primary = quoteSingle,
        secondary = quoteDouble,
    ),
    SymbolSet(
        primary = atSign,
        secondary = hashtag,
    ),
    SymbolSet(
        primary = dollarSign,
        secondary = poundSign,
    ),
    SymbolSet(
        primary = asterisk,
        secondary = ampersand,
    ),
    SymbolSet(
        primary = dash,
        secondary = underscore,
    ),
    SymbolSet(
        primary = bracketLeft,
        secondary = braceLeft,
    ),
    SymbolSet(
        primary = bracketRight,
        secondary = braceRight,
    ),                                                        
    SymbolSet(
        primary = division,
        secondary = multiplication,
    ),
    SymbolSet(
        primary = graveAccent,
        secondary = tilde,
    ),
    SymbolSet(
        primary = pipe,
        secondary = paragraph,
    ),
    SymbolSet(
        primary = ellipsis,
        secondary = trademark,
    ),
    SymbolSet(
        primary = copyright,
        secondary = registered,
    ),
)

private val rowTwo: List<Key> = listOf(
    Alpha,
    SymbolSet(
        primary = question,
        secondary = questionInverted,
    ),
    SymbolSet(
        primary = colon,
        secondary = semicolon,
    ),
    SymbolSet(
        primary = percent,
        secondary = caret,
    ),
    SymbolSet(
        primary = euro,
        secondary = yen,
    ),
    SymbolSet(
        primary = equals,
        secondary = plus,
    ),
    SymbolSet(
        primary = slash,
        secondary = backslash,
    ),
    SymbolSet(
        primary = parenLeft,
        secondary = lessThan,
    ),
    SymbolSet(
        primary = parenRight,
        secondary = greaterThan,
    ),                                                        
    SymbolSet(
        primary = pi,
        secondary = infinity,
    ),
    SymbolSet(
        primary = cent,
        secondary = section,
    ),
    SymbolSet(
        primary = endash,
        secondary = emdash,
    ),
    SymbolSet(
        primary = degree,
        secondary = bullet,
    ),
    SymbolSet(
        primary = squareroot,
        secondary = checkmark,
    ),
)

private const val THREE_ROW_SPLIT = 10

val defaultSymbolsTwoRow: List<List<Key>> = listOf(
    rowOne,
    rowTwo,
)

val defaultSymbolsThreeRow: List<List<Key>> = listOf(
    rowOne.take(THREE_ROW_SPLIT),
    rowTwo.take(THREE_ROW_SPLIT),
    rowOne.drop(THREE_ROW_SPLIT) + rowTwo.drop(THREE_ROW_SPLIT),
)
