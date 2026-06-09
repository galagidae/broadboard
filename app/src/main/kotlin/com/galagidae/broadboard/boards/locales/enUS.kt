package com.galagidae.broadboard.boards.locales

import androidx.compose.runtime.*
import com.galagidae.broadboard.*

val enUS: List<List<Key>> = listOf(
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
        qKey,
        wKey,
        eKey,
        rKey,
        tKey,
        yKey,
        uKey,
        iKey,
        oKey,
        pKey,
    ),
    listOf(
        aKey,
        sKey,
        dKey,
        fKey,
        gKey,
        hKey,
        jKey,
        kKey,
        lKey,
        Contextual,
    ),
    listOf(
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