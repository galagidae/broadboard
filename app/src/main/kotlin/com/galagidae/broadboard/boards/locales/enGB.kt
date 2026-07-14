package com.galagidae.broadboard.boards.locales

import androidx.compose.runtime.*
import com.galagidae.broadboard.*

val enGB: List<List<Key>> = listOf(
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
            secondary = poundSign,
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
        lKey
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