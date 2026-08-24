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

/*
 * Dedicated accented-vowel keys used by the Hungarian layout.
 * ő / Ő and ű / Ű do not appear anywhere in the shared Latin
 * alternates, so they are new characters for the project.
 */

val aAcuteKey = Character(
    primary = 'á',
    secondary = 'Á'
)

val eAcuteKey = Character(
    primary = 'é',
    secondary = 'É'
)

val iAcuteKey = Character(
    primary = 'í',
    secondary = 'Í'
)

val oAcuteKey = Character(
    primary = 'ó',
    secondary = 'Ó'
)

val oDiaeresisKey: SymbolSet = SymbolSet(
    primary = Symbol(character = 'ö'),
    secondary = Symbol(character = 'Ö')
)

val oDoubleAcuteKey = Character(
    primary = 'ő',
    secondary = 'Ő'
)

val uAcuteKey = Character(
    primary = 'ú',
    secondary = 'Ú'
)

val uDiaeresisKey = Character(
    primary = 'ü',
    secondary = 'Ü'
)

val uDoubleAcuteKey = Character(
    primary = 'ű',
    secondary = 'Ű'
)

val aAlternatesHU: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'á'),
            secondary = Symbol(character = 'Á')
        ),
        SymbolSet(
            primary = Symbol(character = 'à'),
            secondary = Symbol(character = 'À')
        ),
        SymbolSet(
            primary = Symbol(character = 'â'),
            secondary = Symbol(character = 'Â')
        ),
        SymbolSet(
            primary = Symbol(character = 'ä'),
            secondary = Symbol(character = 'Ä')
        ),
        SymbolSet(
            primary = Symbol(character = 'å'),
            secondary = Symbol(character = 'Å')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ã'),
            secondary = Symbol(character = 'Ã')
        ),
        SymbolSet(
            primary = Symbol(character = 'ā'),
            secondary = Symbol(character = 'Ā')
        ),
        SymbolSet(
            primary = Symbol(character = 'ą'),
            secondary = Symbol(character = 'Ą')
        ),
        SymbolSet(
            primary = Symbol(character = 'æ'),
            secondary = Symbol(character = 'Æ')
        ),
        SymbolSet(
            primary = Symbol(character = 'ª'),
            secondary = Symbol(character = 'ª')
        )
    )
)

val eAlternatesHU: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'é'),
            secondary = Symbol(character = 'É')
        ),
        SymbolSet(
            primary = Symbol(character = 'è'),
            secondary = Symbol(character = 'È')
        ),
        SymbolSet(
            primary = Symbol(character = 'ê'),
            secondary = Symbol(character = 'Ê')
        ),
        SymbolSet(
            primary = Symbol(character = 'ë'),
            secondary = Symbol(character = 'Ë')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ē'),
            secondary = Symbol(character = 'Ē')
        ),
        SymbolSet(
            primary = Symbol(character = 'ę'),
            secondary = Symbol(character = 'Ę')
        ),
        SymbolSet(
            primary = Symbol(character = 'ė'),
            secondary = Symbol(character = 'Ė')
        )
    )
)

val iAlternatesHU: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'í'),
            secondary = Symbol(character = 'Í')
        ),
        SymbolSet(
            primary = Symbol(character = 'ì'),
            secondary = Symbol(character = 'Ì')
        ),
        SymbolSet(
            primary = Symbol(character = 'î'),
            secondary = Symbol(character = 'Î')
        ),
        SymbolSet(
            primary = Symbol(character = 'ï'),
            secondary = Symbol(character = 'Ï')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ī'),
            secondary = Symbol(character = 'Ī')
        ),
        SymbolSet(
            primary = Symbol(character = 'į'),
            secondary = Symbol(character = 'Į')
        ),
        SymbolSet(
            primary = Symbol(character = 'ĳ'),
            secondary = Symbol(character = 'Ĳ')
        )
    )
)

val oAlternatesHU: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ó'),
            secondary = Symbol(character = 'Ó')
        ),
        SymbolSet(
            primary = Symbol(character = 'ö'),
            secondary = Symbol(character = 'Ö')
        ),
        SymbolSet(
            primary = Symbol(character = 'ő'),
            secondary = Symbol(character = 'Ő')
        ),
        SymbolSet(
            primary = Symbol(character = 'ò'),
            secondary = Symbol(character = 'Ò')
        ),
        SymbolSet(
            primary = Symbol(character = 'ô'),
            secondary = Symbol(character = 'Ô')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'õ'),
            secondary = Symbol(character = 'Õ')
        ),
        SymbolSet(
            primary = Symbol(character = 'ø'),
            secondary = Symbol(character = 'Ø')
        ),
        SymbolSet(
            primary = Symbol(character = 'ō'),
            secondary = Symbol(character = 'Ō')
        ),
        SymbolSet(
            primary = Symbol(character = 'œ'),
            secondary = Symbol(character = 'Œ')
        ),
        SymbolSet(
            primary = Symbol(character = 'º'),
            secondary = Symbol(character = 'º')
        )
    )
)

val uAlternatesHU: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ú'),
            secondary = Symbol(character = 'Ú')
        ),
        SymbolSet(
            primary = Symbol(character = 'ü'),
            secondary = Symbol(character = 'Ü')
        ),
        SymbolSet(
            primary = Symbol(character = 'ű'),
            secondary = Symbol(character = 'Ű')
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(character = 'ù'),
            secondary = Symbol(character = 'Ù')
        ),
        SymbolSet(
            primary = Symbol(character = 'û'),
            secondary = Symbol(character = 'Û')
        ),
        SymbolSet(
            primary = Symbol(character = 'ū'),
            secondary = Symbol(character = 'Ū')
        )
    )
)