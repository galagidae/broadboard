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

val csCZ: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = plus,
            secondary = oneKey,
        ),
        SymbolSet(
            primary = Symbol(character = 'ě'),
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
            primary = Symbol(character = 'ř'),
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
            rows = eAlternatesCS
        ),
        Alternate(
            primary = rKey,
            rows = rAlternatesCS
        ),
        Alternate(
            primary = tKey,
            rows = tAlternatesCS
        ),
        Alternate(
            primary = zKey,
            rows = zAlternatesCS
        ),
        Alternate(
            primary = uKey,
            rows = uAlternatesCS
        ),
        Alternate(
            primary = iKey,
            rows = iAlternatesCS
        ),
        Alternate(
            primary = oKey,
            rows = oAlternatesCS
        ),
        pKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate(
            primary = aKey,
            rows = aAlternatesCS
        ),
        Alternate(
            primary = sKey,
            rows = sAlternates
        ),
        Alternate(
            primary = dKey,
            rows = dAlternatesCS
        ),
        fKey,
        gKey,
        hKey,
        jKey,
        kKey,
        lKey
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        Alternate(
            primary = yKey,
            rows = yAlternatesCS
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
            rows = nAlternatesCS
        ),
        mKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)