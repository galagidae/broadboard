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

val greekAlphaKey = Character(      // α
    primary = 'α',
    secondary = 'Α',
)
val greekBetaKey = Character(       // β
    primary = 'β',
    secondary = 'Β',
)
val greekGammaKey = Character(      // γ
    primary = 'γ',
    secondary = 'Γ',
)
val greekDeltaKey = Character(      // δ
    primary = 'δ',
    secondary = 'Δ',
)
val greekEpsilonKey = Character(    // ε
    primary = 'ε',
    secondary = 'Ε',
)
val greekZetaKey = Character(       // ζ
    primary = 'ζ',
    secondary = 'Ζ',
)
val greekEtaKey = Character(        // η
    primary = 'η',
    secondary = 'Η',
)
val greekThetaKey = Character(      // θ
    primary = 'θ',
    secondary = 'Θ',
)
val greekIotaKey = Character(       // ι
    primary = 'ι',
    secondary = 'Ι',
)
val greekKappaKey = Character(      // κ
    primary = 'κ',
    secondary = 'Κ',
)
val greekLambdaKey = Character(     // λ
    primary = 'λ',
    secondary = 'Λ',
)
val greekMuKey = Character(         // μ
    primary = 'μ',
    secondary = 'Μ',
)
val greekNuKey = Character(         // ν
    primary = 'ν',
    secondary = 'Ν',
)
val greekXiKey = Character(         // ξ
    primary = 'ξ',
    secondary = 'Ξ',
)
val greekOmicronKey = Character(    // ο
    primary = 'ο',
    secondary = 'Ο',
)
val greekPiKey = Character(         // π
    primary = 'π',
    secondary = 'Π',
)
val greekRhoKey = Character(        // ρ
    primary = 'ρ',
    secondary = 'Ρ',
)
val greekSigmaKey = Character(      // σ
    primary = 'σ',
    secondary = 'Σ',
)
val greekFinalSigmaKey = Character( // ς (τελικό σίγμα)
    primary = 'ς',
    secondary = 'ς',
)
val greekTauKey = Character(        // τ
    primary = 'τ',
    secondary = 'Τ',
)
val greekUpsilonKey = Character(    // υ
    primary = 'υ',
    secondary = 'Υ',
)
val greekPhiKey = Character(        // φ
    primary = 'φ',
    secondary = 'Φ',
)
val greekChiKey = Character(        // χ
    primary = 'χ',
    secondary = 'Χ',
)
val greekPsiKey = Character(        // ψ
    primary = 'ψ',
    secondary = 'Ψ',
)
val greekOmegaKey = Character(      // ω
    primary = 'ω',
    secondary = 'Ω',
)

val alphaAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ά',
                description = R.string.char_alpha_tonos
            ),
            secondary = Symbol(
                character = 'Ά',
                description = R.string.char_alpha_tonos_cap
            )
        )
    )
)

val epsilonAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'έ',
                description = R.string.char_epsilon_tonos
            ),
            secondary = Symbol(
                character = 'Έ',
                description = R.string.char_epsilon_tonos_cap
            )
        )
    )
)

val etaAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ή',
                description = R.string.char_eta_tonos
            ),
            secondary = Symbol(
                character = 'Ή',
                description = R.string.char_eta_tonos_cap
            )
        )
    )
)

val iotaAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ί',
                description = R.string.char_iota_tonos
            ),
            secondary = Symbol(
                character = 'Ί',
                description = R.string.char_iota_tonos_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ϊ',
                description = R.string.char_iota_dialytika
            ),
            secondary = Symbol(
                character = 'Ϊ',
                description = R.string.char_iota_dialytika_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ΐ',
                description = R.string.char_iota_dialytika_tonos
            ),
            secondary = Symbol(
                character = 'ΐ',
                description = R.string.char_iota_dialytika_tonos
            )
        )

    )
)

val omicronAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ό',
                description = R.string.char_omicron_tonos
            ),
            secondary = Symbol(
                character = 'Ό',
                description = R.string.char_omicron_tonos_cap
            )
        )
    )
)

val upsilonAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ύ',
                description = R.string.char_upsilon_tonos
            ),
            secondary = Symbol(
                character = 'Ύ',
                description = R.string.char_upsilon_tonos_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ϋ',
                description = R.string.char_upsilon_dialytika
            ),
            secondary = Symbol(
                character = 'Ϋ',
                description = R.string.char_upsilon_dialytika_cap
            )
        ),
        SymbolSet(
            primary = Symbol(
                character = 'ΰ',
                description = R.string.char_upsilon_dialytika_tonos
            ),
            secondary = Symbol(
                character = 'ΰ',
                description = R.string.char_upsilon_dialytika_tonos
            )
        )

    )
)

val omegaAlternates: List<List<SymbolSet>> = listOf(
    listOf(
        SymbolSet(
            primary = Symbol(
                character = 'ώ',
                description = R.string.char_omega_tonos
            ),
            secondary = Symbol(
                character = 'Ώ',
                description = R.string.char_omega_tonos_cap
            )
        )
    )
)
