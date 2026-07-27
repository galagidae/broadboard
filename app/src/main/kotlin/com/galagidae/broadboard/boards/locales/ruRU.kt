package com.galagidae.broadboard.boards.locales

import androidx.compose.runtime.*
import com.galagidae.broadboard.*

// Standard ЙЦУКЕН layout, all 33 letters.
//
// ё lives on the backtick key on a physical keyboard, so it's placed
// at the far left of the top row here. ъ sits after х at the end of
// row 1, as on a physical keyboard. Both are usually dropped (or
// long-press alternates) on mobile ЙЦУКЕН layouts.

val ruRU: List<List<Key>> = listOf(
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
        cyrShortIKey,    // й
        cyrTseKey,       // ц
        cyrUKey,         // у
        cyrKaKey,        // к
        Alternate(       // е
            primary = cyrYeKey,
            rows = yoAlternates
        ),
        cyrEnKey,        // н
        cyrGeKey,        // г
        cyrShaKey,       // ш
        cyrShchaKey,     // щ
        cyrZeKey,        // з
        cyrKhaKey,       // х
        cyrHardSignKey,  // ъ
    ),
    listOf(
        Space(multiplier = 0.75f),
        cyrEfKey,        // ф
        cyrYeryKey,      // ы
        cyrVeKey,        // в
        cyrAKey,         // а
        cyrPeKey,        // п
        cyrErKey,        // р
        cyrOKey,         // о
        cyrElKey,        // л
        cyrDeKey,        // д
        cyrZheKey,       // ж
        cyrEKey,         // э
    ),
    listOf(
        Space(multiplier = 0.25f),
        Contextual,
        cyrYaKey,        // я
        cyrCheKey,       // ч
        cyrEsKey,        // с
        cyrEmKey,        // м
        cyrIKey,         // и
        cyrTeKey,        // т
        Alternate(       // ь
            primary = cyrSoftSignKey,
            rows = softSignAlternates
        ),
        cyrBeKey,        // б
        cyrYuKey,        // ю
        Character(
            primary = '.',
            secondary = ','
        ),
        Enter
    ),
)