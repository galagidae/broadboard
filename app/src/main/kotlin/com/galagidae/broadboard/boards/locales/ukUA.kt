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

val ukUA: List<List<Key>> = listOf(
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
            secondary = numero,
        ),
        SymbolSet(
            primary = fourKey,
            secondary = semicolon,
        ),
        SymbolSet(
            primary = fiveKey,
            secondary = percent,
        ),
        SymbolSet(
            primary = sixKey,
            secondary = colon,
        ),
        SymbolSet(
            primary = sevenKey,
            secondary = question,
        ),
        SymbolSet(
            primary = eightKey,
            secondary = asterisk,
        ),
        SymbolSet(
            primary = nineKey,
            secondary = parenLeft,
        ),
        SymbolSet(
            primary = zeroKey,
            secondary = parenRight,
        ),
    ),
    listOf(
        Space(multiplier = 0.5f),
        cyrShortIKey,     // й
        cyrTseKey,        // ц
        cyrUKey,          // у
        cyrKaKey,         // к
        cyrYeKey,         // е
        cyrEnKey,         // н
        cyrGeKey,         // г
        cyrShaKey,        // ш
        cyrShchaKey,      // щ
        cyrZeKey,         // з
        cyrKhaKey,        // х
        cyrYiKey,         // ї
    ),
    listOf(
        Space(multiplier = 0.75f),
        cyrEfKey,         // ф
        cyrDottedIKey,    // і
        cyrVeKey,         // в
        cyrAKey,          // а
        cyrPeKey,         // п
        cyrErKey,         // р
        cyrOKey,          // о
        cyrElKey,         // л
        cyrDeKey,         // д
        cyrZheKey,        // ж
        cyrUkrYeKey,      // є
        SymbolSet(
            primary = quoteSingle,
            secondary = Symbol(
                character = '’',
            )
        )
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        cyrYaKey,         // я
        cyrCheKey,        // ч
        cyrEsKey,         // с
        cyrEmKey,         // м
        cyrIKey,          // и
        cyrTeKey,         // т
        cyrSoftSignKey,   // ь
        cyrBeKey,         // б
        cyrYuKey,         // ю
        cyrGeUpturnKey,
        Character(
            primary = '.',
            secondary = ','
        ),
        Enter
    ),
)