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

package com.galagidae.broadboard

import android.content.Intent
import android.content.res.Resources
import android.database.ContentObserver
import android.os.*
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.galagidae.broadboard.*
import com.galagidae.broadboard.preferencesui.*
import com.galagidae.broadboard.utils.*

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = PreferencesRepository(applicationContext)
        val factory = PreferencesViewModelFactory(repository)

        setContent {
            val darkTheme = isSystemInDarkTheme()
            val preferencesViewModel: PreferencesViewModel = viewModel(factory = factory)
            val context = LocalContext.current
            val colorScheme = when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                    try {
                        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
                    } catch (e: Resources.NotFoundException) {
                        if (darkTheme) DarkColorScheme else LightColorScheme
                    }
                }
                darkTheme -> DarkColorScheme
                else -> LightColorScheme
            }

            var imeStatus by remember { mutableStateOf(checkImeStatus(context)) }

            // Recheck on resume (covers the "enable IME" -> Settings -> back flow)
            val lifecycleOwner = LocalLifecycleOwner.current
            DisposableEffect(lifecycleOwner) {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_RESUME) {
                        imeStatus = checkImeStatus(context)
                    }
                }
                lifecycleOwner.lifecycle.addObserver(observer)
                onDispose {
                    lifecycleOwner.lifecycle.removeObserver(observer)
                }
            }

            // Recheck immediately when the default IME setting changes
            // (covers the IME picker dialog, which doesn't reliably trigger onResume)
            DisposableEffect(Unit) {
                val contentObserver = object : ContentObserver(Handler(Looper.getMainLooper())) {
                    override fun onChange(selfChange: Boolean) {
                        imeStatus = checkImeStatus(context)
                    }
                }
                context.contentResolver.registerContentObserver(
                    Settings.Secure.getUriFor(Settings.Secure.DEFAULT_INPUT_METHOD),
                    false,
                    contentObserver
                )
                onDispose {
                    context.contentResolver.unregisterContentObserver(contentObserver)
                }
            }

            MaterialTheme(colorScheme = colorScheme) {
                AppPreferences(viewModel = preferencesViewModel) {
                    Surface {
                        Column {
                            PreferencesScreen(
                                viewModel = preferencesViewModel,
                                imeStatus = imeStatus
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
    }
}