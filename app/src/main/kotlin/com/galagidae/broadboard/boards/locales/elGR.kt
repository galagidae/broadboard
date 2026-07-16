package com.galagidae.broadboard.boards.locales

import androidx.compose.runtime.*
import com.galagidae.broadboard.*

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