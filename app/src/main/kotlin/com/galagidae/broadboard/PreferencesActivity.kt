package com.galagidae.broadboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.galagidae.broadboard.preferencesui.PreferencesScreen

class PreferencesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = PreferencesRepository(applicationContext)
        val factory = PreferencesViewModelFactory(repository)

        setContent {
            val darkTheme = isSystemInDarkTheme()
            val colorScheme = if (darkTheme) dynamicDarkColorScheme(this) else dynamicLightColorScheme(this)
            val preferencesViewModel: PreferencesViewModel = viewModel(factory = factory)

            MaterialTheme(colorScheme = colorScheme) {
                AppPreferences(viewModel = preferencesViewModel) {                
                    Surface {
                        PreferencesScreen(viewModel = preferencesViewModel)
                    }
                }
            }
        }
    }
}