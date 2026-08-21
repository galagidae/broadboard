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

val trTR: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = oneKey,
            secondary = exclamation,
        ),
        SymbolSet(
            primary = twoKey,
            secondary = quoteSingle,
        ),
        SymbolSet(
            primary = threeKey,
            secondary = caret,
        ),
        SymbolSet(
            primary = fourKey,
            secondary = plus,
        ),
        SymbolSet(
            primary = fiveKey,
            secondary = percent,
        ),
        SymbolSet(
            primary = sixKey,
            secondary = ampersand,
        ),
        SymbolSet(
            primary = sevenKey,
            secondary = slash,
        ),
        SymbolSet(
            primary = eightKey,
            secondary = parenLeft,
        ),
        SymbolSet(
            primary = nineKey,
            secondary = parenRight,
        ),
        SymbolSet(
            primary = zeroKey,
            secondary = equals,
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        qKey,
        wKey,
        Alternate(
            primary = eKey,
            rows = eAlternates
        ),
        rKey,
        tKey,
        yKey,
        Alternate(
            primary = uKey,
            rows = uAlternates
        ),
        dotlessIKey,
        Alternate(
            primary = oKey,
            rows = oAlternates
        ),
        pKey,
        gBreveKey,
        uDiaeresisKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate(
            primary = aKey,
            rows = aAlternates
        ),
        sKey,
        dKey,
        fKey,
        gKey,
        hKey,
        jKey,
        kKey,
        lKey,
        sCedillaKey,
        Alternate(
            primary = dottedIKey,
            rows = iAlternates
        ),
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        zKey,
        xKey,
        cKey,
        vKey,
        bKey,
        Alternate(
            primary = nKey,
            rows = nAlternates
        ),
        mKey,
        oDiaeresisKey,
        cCedillaKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)