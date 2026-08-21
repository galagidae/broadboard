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
import com.galagidae.broadboard.R

val aAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'à',
                description = R.string.char_a_grave
            ),
            secondary = Symbol(
                character = 'À',
                description = R.string.char_a_grave_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'â',
                description = R.string.char_a_circumflex
            ),
            secondary = Symbol(
                character = 'Â',
                description = R.string.char_a_circumflex_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'á',
                description = R.string.char_a_acute
            ),
            secondary = Symbol(
                character = 'Á',
                description = R.string.char_a_acute_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ª',
                description = R.string.char_a_ordinal
            ),
            secondary = Symbol(
                character = 'ª',
                description = R.string.char_a_ordinal
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'å',
                description = R.string.char_a_overring
            ),
            secondary = Symbol(
                character = 'Å',
                description = R.string.char_a_overring_cap
            )
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ä',
                description = R.string.char_a_diaeresis
            ),
            secondary = Symbol(
                character = 'Ä',
                description = R.string.char_a_diaeresis_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ā',
                description = R.string.char_a_macron
            ),
            secondary = Symbol(
                character = 'Ā',
                description = R.string.char_a_macron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ã',
                description = R.string.char_a_tilde
            ),
            secondary = Symbol(
                character = 'Ã',
                description = R.string.char_a_tilde_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ą',
                description = R.string.char_a_ogonek
            ),
            secondary = Symbol(
                character = 'Ą',
                description = R.string.char_a_ogonek_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'æ',
                description = R.string.char_a_ash
            ),
            secondary = Symbol(
                character = 'Æ',
                description = R.string.char_a_ash_cap
            )
        )
    )
)

val cAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'č',
                description = R.string.char_c_caron
            ),
            secondary = Symbol(
                character = 'Č',
                description = R.string.char_c_caron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ć',
                description = R.string.char_c_acute
            ),
            secondary = Symbol(
                character = 'Ć',
                description = R.string.char_c_acute_cap
            )
        ),
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ç',
                description = R.string.char_c_cedilla
            ),
            secondary = Symbol(
                character = 'Ç',
                description = R.string.char_c_cedilla_cap
            )
        )
    )
)

val eAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'è',
                description = R.string.char_e_grave
            ),
            secondary = Symbol(
                character = 'È',
                description = R.string.char_e_grave_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ê',
                description = R.string.char_e_circumflex
            ),
            secondary = Symbol(
                character = 'Ê',
                description = R.string.char_e_circumflex_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'é',
                description = R.string.char_e_acute
            ),
            secondary = Symbol(
                character = 'É',
                description = R.string.char_e_acute_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ė',
                description = R.string.char_e_overdot
            ),
            secondary = Symbol(
                character = 'Ė',
                description = R.string.char_e_overdot_cap
            )
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ë',
                description = R.string.char_e_diaeresis
            ),
            secondary = Symbol(
                character = 'Ë',
                description = R.string.char_e_diaeresis_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ē',
                description = R.string.char_e_macron
            ),
            secondary = Symbol(
                character = 'Ē',
                description = R.string.char_e_macron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ę',
                description = R.string.char_e_ogonek
            ),
            secondary = Symbol(
                character = 'Ę',
                description = R.string.char_e_ogonek_cap
            )
        )
    )
)

val iAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ì',
                description = R.string.char_i_grave
            ),
            secondary = Symbol(
                character = 'Ì',
                description = R.string.char_i_grave_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'î',
                description = R.string.char_i_circumflex
            ),
            secondary = Symbol(
                character = 'Î',
                description = R.string.char_i_circumflex_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'í',
                description = R.string.char_i_acute
            ),
            secondary = Symbol(
                character = 'Í',
                description = R.string.char_i_acute_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ĳ',
                description = R.string.char_ij_ligature
            ),
            secondary = Symbol(
                character = 'Ĳ',
                description = R.string.char_ij_ligature_cap
            )
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ï',
                description = R.string.char_i_diaeresis
            ),
            secondary = Symbol(
                character = 'Ï',
                description = R.string.char_i_diaeresis_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ī',
                description = R.string.char_i_macron
            ),
            secondary = Symbol(
                character = 'Ī',
                description = R.string.char_i_macron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'į',
                description = R.string.char_i_ogonek
            ),
            secondary = Symbol(
                character = 'Į',
                description = R.string.char_i_ogonek_cap
            )
        )
    )
)

val nAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ñ',
                description = R.string.char_n_tilde
            ),
            secondary = Symbol(
                character = 'Ñ',
                description = R.string.char_n_tilde_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ń',
                description = R.string.char_n_acute
            ),
            secondary = Symbol(
                character = 'Ń',
                description = R.string.char_n_acute_cap
            )
        ),
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ň',
                description = R.string.char_n_caron
            ),
            secondary = Symbol(
                character = 'Ň',
                description = R.string.char_n_caron_cap
            )
        )
    )
)

val oAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ò',
                description = R.string.char_o_grave
            ),
            secondary = Symbol(
                character = 'Ò',
                description = R.string.char_o_grave_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ô',
                description = R.string.char_o_circumflex
            ),
            secondary = Symbol(
                character = 'Ô',
                description = R.string.char_o_circumflex_cap
            )
        ),        
        SymbolSet(
            primary = Symbol(
                character = 'ó',
                description = R.string.char_o_acute
            ),
            secondary = Symbol(
                character = 'Ó',
                description = R.string.char_o_acute_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'º',
                description = R.string.char_o_ordinal
            ),
            secondary = Symbol(
                character = 'º',
                description = R.string.char_o_ordinal
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ø',
                description = R.string.char_o_stroke
            ),
            secondary = Symbol(
                character = 'Ø',
                description = R.string.char_o_stroke_cap
            )
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ö',
                description = R.string.char_o_diaeresis
            ),
            secondary = Symbol(
                character = 'Ö',
                description = R.string.char_o_diaeresis_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ō',
                description = R.string.char_o_macron
            ),
            secondary = Symbol(
                character = 'Ō',
                description = R.string.char_o_macron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'õ',
                description = R.string.char_o_tilde
            ),
            secondary = Symbol(
                character = 'Õ',
                description = R.string.char_o_tilde_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'œ',
                description = R.string.char_o_oe
            ),
            secondary = Symbol(
                character = 'Œ',
                description = R.string.char_o_oe_cap
            )
        )        
    )
)

val sAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'š',
                description = R.string.char_s_caron
            ),
            secondary = Symbol(
                character = 'Š',
                description = R.string.char_s_caron_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ś',
                description = R.string.char_s_acute
            ),
            secondary = Symbol(
                character = 'Ś',
                description = R.string.char_s_acute_cap
            )
        ),
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ß',
                description = R.string.char_s_sharp
            ),
            secondary = Symbol(
                character = 'ẞ',
                description = R.string.char_s_sharp
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ş',
                description = R.string.char_s_cedilla
            ),
            secondary = Symbol(
                character = 'Ş',
                description = R.string.char_s_cedilla
            )
        )
    )
)

val uAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ù',
                description = R.string.char_u_grave
            ),
            secondary = Symbol(
                character = 'Ù',
                description = R.string.char_u_grave_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'û',
                description = R.string.char_u_circumflex
            ),
            secondary = Symbol(
                character = 'Û',
                description = R.string.char_u_circumflex_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ú',
                description = R.string.char_u_acute
            ),
            secondary = Symbol(
                character = 'Ú',
                description = R.string.char_u_acute_cap
            )
        )
    ),
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ü',
                description = R.string.char_u_diaeresis
            ),
            secondary = Symbol(
                character = 'Ü',
                description = R.string.char_u_diaeresis_cap
            )
        ),        
        SymbolSet(
            primary = Symbol(
                character = 'ū',
                description = R.string.char_u_macron
            ),
            secondary = Symbol(
                character = 'Ū',
                description = R.string.char_u_macron_cap
            )
        )
    )
)
