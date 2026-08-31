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

val faIR: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = faOneKey,
            secondary = exclamation,
        ),
        SymbolSet(
            primary = faTwoKey,
            secondary = atSign,
        ),
        SymbolSet(
            primary = faThreeKey,
            secondary = hashtag,
        ),
        SymbolSet(
            primary = faFourKey,
            secondary = dollarSign,
        ),
        SymbolSet(
            primary = faFiveKey,
            secondary = percent,
        ),
        SymbolSet(
            primary = faSixKey,
            secondary = caret,
        ),
        SymbolSet(
            primary = faSevenKey,
            secondary = ampersand,
        ),
        SymbolSet(
            primary = faEightKey,
            secondary = asterisk,
        ),                                                        
        SymbolSet(
            primary = faNineKey,
            secondary = parenLeft,
        ),
        SymbolSet(
            primary = faZeroKey,
            secondary = parenRight,
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        faZadKey,
        faSadKey,
        faTheKey,
        faGhafKey,
        faFeKey,
        faGheynKey,
        faEynKey,
        faHeKey,
        faKheKey,
        faHeJimiKey,
		faJimKey
    ),
    listOf(
        Space(multiplier = 0.75f),
        faShinKey,
        faSinKey,
        faYeKey,
        faBeKey,
        faLamKey,
        faAlefKey,
        faTeKey,
        faNoonKey,
        faMimKey,
		faKafKey,
		faGhafKey
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        faZaKey,
        faTaKey,
        faZheKey,
        faZeKey,
        faReKey,
        faZalKey,
        faDalKey,
		faPeKey,
		faVavKey,
		faCheKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)