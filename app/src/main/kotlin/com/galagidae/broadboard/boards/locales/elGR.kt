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

val elGR: List<List<Key>> = listOf(
    listOf(
        SymbolSet(
            primary = oneKey,
            secondary = exclamation,
        ),
        SymbolSet(
            primary = twoKey,
            secondary = atSign,
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
            secondary = caret,
        ),
        SymbolSet(
            primary = sevenKey,
            secondary = ampersand,
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
        SymbolSet(
            primary = semicolon,
            secondary = colon,
        ),
        greekFinalSigmaKey,
        Alternate (
            primary = greekEpsilonKey,
            rows = epsilonAlternates
        ),
        greekRhoKey,
        greekTauKey,
        Alternate (
            primary = greekUpsilonKey,
            rows = upsilonAlternates
        ),
        greekThetaKey,
        Alternate (
            primary = greekIotaKey,
            rows = iotaAlternates
        ),
        Alternate (
            primary = greekOmicronKey,
            rows = omicronAlternates
        ),
        greekPiKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate (
            primary = greekAlphaKey,
            rows = alphaAlternates
        ),
        greekSigmaKey,
        greekDeltaKey,
        greekPhiKey,
        greekGammaKey,
        Alternate (
            primary = greekEtaKey,
            rows = etaAlternates
        ),
        greekXiKey,
        greekKappaKey,
        greekLambdaKey
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        greekZetaKey,
        greekChiKey,
        greekPsiKey,
        Alternate (
            primary = greekOmegaKey,
            rows = omegaAlternates
        ),
        greekBetaKey,
        greekNuKey,
        greekMuKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)