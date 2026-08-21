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
import com.galagidae.broadboard.R
import com.galagidae.broadboard.boards.characters.*

val frFR: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = ampersand,
            secondary = oneKey,
        ),
        SymbolSet(
            primary = Symbol(
                character = 'é',
                description = R.string.char_e_acute
            ),
            secondary = twoKey,
        ),
        SymbolSet(
            primary = quoteDouble,
            secondary = threeKey,
        ),
        SymbolSet(
            primary = quoteSingle,
            secondary = fourKey,
        ),
        SymbolSet(
            primary = parenLeft,
            secondary = fiveKey,
        ),
        SymbolSet(
            primary = dash,
            secondary = sixKey,
        ),
        SymbolSet(
            primary = Symbol(
                character = 'è',
                description = R.string.char_e_grave
            ),
            secondary = sevenKey,
        ),
        SymbolSet(
            primary = underscore,
            secondary = eightKey,
        ),                                                        
        SymbolSet(
            primary = Symbol(
                character = 'ç',
                description = R.string.char_c_cedilla
            ),
            secondary = nineKey,
        ),
        SymbolSet(
            primary = Symbol(
                character = 'à',
                description = R.string.char_a_grave
            ),
            secondary = zeroKey,
        ),
        SymbolSet(
            primary = parenRight,
            secondary = degree,
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        Alternate(
            primary = aKey,
            rows = aAlternates
        ),
        zKey,
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
        Alternate(
            primary = iKey,
            rows = iAlternates
        ),
        Alternate(
            primary = oKey,
            rows = oAlternates
        ),
        pKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        qKey,
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
        mKey
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        wKey,
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
        Enter
    ),
)