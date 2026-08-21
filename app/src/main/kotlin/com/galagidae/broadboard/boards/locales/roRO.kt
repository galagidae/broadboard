package com.galagidae.broadboard.boards.locales

import androidx.compose.runtime.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.boards.characters.*

val roRO: List<List<Key>> = listOf(
    listOf(
        SymbolSet(primary = oneKey, secondary = exclamation),
        SymbolSet(primary = twoKey, secondary = atSign),
        SymbolSet(primary = threeKey, secondary = hashtag),
        SymbolSet(primary = fourKey, secondary = dollarSign),
        SymbolSet(primary = fiveKey, secondary = percent),
        SymbolSet(primary = sixKey, secondary = caret),
        SymbolSet(primary = sevenKey, secondary = ampersand),
        SymbolSet(primary = eightKey, secondary = asterisk),
        SymbolSet(primary = nineKey, secondary = parenLeft),
        SymbolSet(primary = zeroKey, secondary = parenRight),
    ),
    listOf(
        Space(multiplier = 0.5f),
        qKey,
        wKey,
        eKey,
        rKey,
        Alternate(
            primary = tKey,
            rows = tAlternatesRO
        ),
        yKey,
        uKey,
        Alternate(
            primary = iKey,
            rows = iAlternates // reused: î already present
        ),
        oKey,
        pKey,
    ),
    listOf(
        Space(multiplier = 0.75f),
        Alternate(
            primary = aKey,
            rows = aAlternatesRO
        ),
        Alternate(
            primary = sKey,
            rows = sAlternatesRO
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
        cKey,
        vKey,
        bKey,
        nKey,
        mKey,
        Character(
            primary = '.',
            secondary = '.'
        ),
        Enter
    ),
)
