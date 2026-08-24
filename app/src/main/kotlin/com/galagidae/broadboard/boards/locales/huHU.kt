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

val huHU: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = oneKey,
            secondary = quoteSingle,
        ),
        SymbolSet(
            primary = twoKey,
            secondary = quoteDouble,
        ),
        SymbolSet(
            primary = threeKey,
            secondary = plus,
        ),
        SymbolSet(
            primary = fourKey,
            secondary = exclamation,
        ),
        SymbolSet(
            primary = fiveKey,
            secondary = percent,
        ),
        SymbolSet(
            primary = sixKey,
            secondary = slash,
        ),
        SymbolSet(
            primary = sevenKey,
            secondary = equals,
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
            secondary = section,
        ),
        Alternate(
            primary = oDiaeresisKey,
            rows = oAlternatesHU
        ),
        Alternate(
            primary = uDiaeresisKey,
            rows = uAlternatesHU
        ),
        Alternate(
            primary = oAcuteKey,
            rows = oAlternatesHU
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        qKey,
        wKey,
        Alternate(
            primary = eKey,
            rows = eAlternatesHU
        ),
        rKey,
        tKey,
        zKey,
        Alternate(
            primary = uKey,
            rows = uAlternatesHU
        ),
        Alternate(
            primary = iKey,
            rows = iAlternatesHU
        ),
        Alternate(
            primary = oKey,
            rows = oAlternatesHU
        ),
        pKey,
        Alternate(
            primary = oDoubleAcuteKey,
            rows = oAlternatesHU
        ),
        Alternate(
            primary = uAcuteKey,
            rows = uAlternatesHU
        ),
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate(
            primary = aKey,
            rows = aAlternatesHU
        ),
        Alternate(
            primary = sKey,
            rows = sAlternates
        ),
        dKey,
        fKey,
        gKey,
        hKey,
        jKey,
        kKey,
        lKey,
        Alternate(
            primary = eAcuteKey,
            rows = eAlternatesHU
        ),
        Alternate(
            primary = aAcuteKey,
            rows = aAlternatesHU
        ),
        Alternate(
            primary = uDoubleAcuteKey,
            rows = uAlternatesHU
        ),
    ),
    listOf(
        Space(multiplier = 0.25f),
        Alternate(
            primary = iAcuteKey,
            rows = iAlternatesHU
        ),
        yKey,
        xKey,
        Alternate(
            primary = cKey,
            rows = cAlternates
        ),
        vKey,
        bKey,
        Alternate(
            primary = nKey,
            rows = nAlternates
        ),
        mKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Contextual,
        Enter
    ),
)