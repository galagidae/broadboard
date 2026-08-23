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

import androidx.compose.runtime.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.characters.*

val skSK: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = plus,
            secondary = oneKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'ľ'),
            secondary = twoKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'š'),
            secondary = threeKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'č'),
            secondary = fourKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'ť'),
            secondary = fiveKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'ž'),
            secondary = sixKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'ý'),
            secondary = sevenKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'á'),
            secondary = eightKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'í'),
            secondary = nineKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'é'),
            secondary = zeroKey,
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        qKey,
        wKey,
        Alternate(
            primary = eKey,
            rows = eAlternatesSK
        ),
        Alternate(
            primary = rKey,
            rows = rAlternatesSK
        ),
        Alternate(
            primary = tKey,
            rows = tAlternatesSK
        ),
        Alternate(
            primary = zKey,
            rows = zAlternatesSK
        ),
        Alternate(
            primary = uKey,
            rows = uAlternatesSK
        ),
        Alternate(
            primary = iKey,
            rows = iAlternatesSK
        ),
        Alternate(
            primary = oKey,
            rows = oAlternatesSK
        ),
        pKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate(
            primary = aKey,
            rows = aAlternatesSK
        ),
        Alternate(
            primary = sKey,
            rows = sAlternates
        ),
        Alternate(
            primary = dKey,
            rows = dAlternatesSK
        ),
        fKey,
        gKey,
        hKey,
        jKey,
        kKey,
        Alternate(
            primary = lKey,
            rows = lAlternatesSK
        )
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        Alternate(
            primary = yKey,
            rows = yAlternatesSK
        ),
        xKey,
        Alternate(
            primary = cKey,
            rows = cAlternates
        ),
        vKey,
        bKey,
        Alternate(
            primary = nKey,
            rows = nAlternatesSK
        ),
        mKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)