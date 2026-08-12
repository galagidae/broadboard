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

package com.galagidae.broadboard.preferencesui

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Light theme — near-black text on near-white surfaces (~19:1)
// Accent: strong blue, distinguishable without relying on hue alone
val LightPrimary        = Color(0xFF0B5FA5) // ~5.4:1 on white — meets AA for normal text
val LightOnPrimary      = Color(0xFFFFFFFF)
val LightPrimaryContainer   = Color(0xFFD3E4F5)
val LightOnPrimaryContainer = Color(0xFF00263D) // ~11:1 on container

val LightSecondary      = Color(0xFF6B5900) // dark amber, distinct from primary blue
val LightOnSecondary    = Color(0xFFFFFFFF)
val LightSecondaryContainer   = Color(0xFFFCE8A0)
val LightOnSecondaryContainer = Color(0xFF241E00)

val LightBackground     = Color(0xFFFFFFFF)
val LightOnBackground   = Color(0xFF1A1A1A) // ~17.9:1
val LightSurface        = Color(0xFFFAFAFA)
val LightOnSurface      = Color(0xFF1A1A1A) // ~16.9:1

val LightError           = Color(0xFFB3261E) // ~5.9:1 on white
val LightOnError         = Color(0xFFFFFFFF)
val LightErrorContainer  = Color(0xFFF9DEDC)
val LightOnErrorContainer = Color(0xFF410E0B)

val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
)

// Dark theme — near-white text on near-black surfaces (~18:1)
// Lighter, desaturated versions of the accents so they don't glare on dark backgrounds
val DarkPrimary        = Color(0xFF9AC9F2) // ~10.5:1 on dark background
val DarkOnPrimary      = Color(0xFF00304E)
val DarkPrimaryContainer   = Color(0xFF00456F)
val DarkOnPrimaryContainer = Color(0xFFD3E4F5)

val DarkSecondary      = Color(0xFFE3C440) // ~11.5:1 on dark background
val DarkOnSecondary    = Color(0xFF3A2F00)
val DarkSecondaryContainer   = Color(0xFF544600)
val DarkOnSecondaryContainer = Color(0xFFFCE8A0)

val DarkBackground     = Color(0xFF121212)
val DarkOnBackground   = Color(0xFFF2F2F2) // ~16.5:1
val DarkSurface        = Color(0xFF1C1C1C)
val DarkOnSurface      = Color(0xFFF2F2F2) // ~15.5:1

val DarkErrorScheme      = Color(0xFFF2B8B5) // ~10.7:1 on dark background
val DarkOnError           = Color(0xFF601410)
val DarkErrorContainer    = Color(0xFF8C1D18)
val DarkOnErrorContainer  = Color(0xFFF9DEDC)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    error = DarkErrorScheme,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
)