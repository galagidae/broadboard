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

val es419: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = oneKey,
            secondary = exclamation,
        ),
        SymbolSet(
            primary = twoKey,
            secondary = quoteDouble,
        ),
        SymbolSet(
            primary = threeKey,
            secondary = hashtag,
        ),
        SymbolSet(
            primary = fourKey,
            secondary = dollarSign,
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
        Alternate(
            primary = aKey,
            rows = aAlternates
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
        SymbolSet(
            primary = Symbol(
                character = 'ñ',
                description = R.string.char_n_tilde
            ),
            secondary = Symbol(
                character = 'Ñ',
                description = R.string.char_n_tilde_cap
            )
        )
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        zKey,
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