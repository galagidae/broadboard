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
import com.galagidae.broadboard.Character

val cyrAKey = Character(          // а
    primary = 'а',
    secondary = 'А',
)

val cyrBeKey = Character(         // б
    primary = 'б',
    secondary = 'Б',
)

val cyrVeKey = Character(         // в
    primary = 'в',
    secondary = 'В',
)

val cyrGeKey = Character(         // г
    primary = 'г',
    secondary = 'Г',
)

val cyrGeUpturnKey = Character(   // ґ
    primary = 'ґ',
    secondary = 'Ґ',
)

val cyrDeKey = Character(         // д
    primary = 'д',
    secondary = 'Д',
)

val cyrYeKey = Character(         // е
    primary = 'е',
    secondary = 'Е',
)

val cyrUkrYeKey = Character(      // є
    primary = 'є',
    secondary = 'Є',
)

val cyrZheKey = Character(        // ж
    primary = 'ж',
    secondary = 'Ж',
)

val cyrZeKey = Character(         // з
    primary = 'з',
    secondary = 'З',
)

val cyrIKey = Character(          // и
    primary = 'и',
    secondary = 'И',
)

val cyrDottedIKey = Character(    // і
    primary = 'і',
    secondary = 'І',
)

val cyrShortIKey = Character(     // й (и краткое)
    primary = 'й',
    secondary = 'Й',
)

val cyrKaKey = Character(         // к
    primary = 'к',
    secondary = 'К',
)

val cyrElKey = Character(         // л
    primary = 'л',
    secondary = 'Л',
)

val cyrEmKey = Character(         // м
    primary = 'м',
    secondary = 'М',
)

val cyrEnKey = Character(         // н
    primary = 'н',
    secondary = 'Н',
)

val cyrOKey = Character(          // о
    primary = 'о',
    secondary = 'О',
)

val cyrPeKey = Character(         // п
    primary = 'п',
    secondary = 'П',
)

val cyrErKey = Character(         // р
    primary = 'р',
    secondary = 'Р',
)

val cyrEsKey = Character(         // с
    primary = 'с',
    secondary = 'С',
)

val cyrTeKey = Character(         // т
    primary = 'т',
    secondary = 'Т',
)

val cyrUKey = Character(          // у
    primary = 'у',
    secondary = 'У',
)

val cyrEfKey = Character(         // ф
    primary = 'ф',
    secondary = 'Ф',
)

val cyrKhaKey = Character(        // х
    primary = 'х',
    secondary = 'Х',
)

val cyrTseKey = Character(        // ц
    primary = 'ц',
    secondary = 'Ц',
)

val cyrCheKey = Character(        // ч
    primary = 'ч',
    secondary = 'Ч',
)

val cyrShaKey = Character(        // ш
    primary = 'ш',
    secondary = 'Ш',
)

val cyrShchaKey = Character(      // щ
    primary = 'щ',
    secondary = 'Щ',
)

val cyrHardSignKey = Character(   // ъ (твёрдый знак)
    primary = 'ъ',
    secondary = 'Ъ',
)

val cyrYeryKey = Character(       // ы
    primary = 'ы',
    secondary = 'Ы',
)

val cyrYiKey = Character(         // ї
    primary = 'ї',
    secondary = 'Ї',
)

val cyrSoftSignKey = Character(   // ь (мягкий знак)
    primary = 'ь',
    secondary = 'Ь',
)

val cyrEKey = Character(          // э
    primary = 'э',
    secondary = 'Э',
)

val cyrYuKey = Character(         // ю
    primary = 'ю',
    secondary = 'Ю',
)

val cyrYaKey = Character(         // я
    primary = 'я',
    secondary = 'Я',
)

val yoAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ё',
            ),
            secondary = Symbol(
                character = 'Ё',
            )
        )
    )
)

val softSignAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ъ',
            ),
            secondary = Symbol(
                character = 'Ъ',
            )
        )
    )
)
