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

package com.galagidae.broadboard.boards.characters

import com.galagidae.broadboard.*

val zAlternatesPL: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ż'),
            secondary = Symbol(character = 'Ż')
        ),
        SymbolSet(
            primary = Symbol(character = 'ź'),
            secondary = Symbol(character = 'Ź')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ž'),
            secondary = Symbol(character = 'Ž')
        )
    )
)
