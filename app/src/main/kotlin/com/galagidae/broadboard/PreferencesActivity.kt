package com.galagidae.broadboard

import android.content.Intent
import android.database.ContentObserver
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
            val colorScheme = if (darkTheme) dynamicDarkColorScheme(this) else dynamicLightColorScheme(this)
            val preferencesViewModel: PreferencesViewModel = viewModel(factory = factory)
            val context = LocalContext.current

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