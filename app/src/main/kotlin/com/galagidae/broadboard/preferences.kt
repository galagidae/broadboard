package com.galagidae.broadboard

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import androidx.lifecycle.compose.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

typealias LabelMap = Map<String, Int>

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")
val sizeOptions = listOf(
    "small",
    "medium",
    "large"
)
val sizeLabels: LabelMap = mapOf(
    "small" to R.string.pref_size_small,
    "medium" to R.string.pref_size_medium,
    "large" to R.string.pref_size_large 
)

val colorOptions = listOf(
    "light",
    "dark"
)
val colorLabels: LabelMap = mapOf(
    "light" to R.string.pref_color_light,
    "dark" to R.string.pref_color_dark
)

class PreferencesRepository(private val context: Context) {
    private object Keys {
        val SIZE_THEME = stringPreferencesKey("size_theme")
        val COLOR_THEME = stringPreferencesKey("color_theme")
    }

    val sizeThemeFlow: Flow<String> = context.dataStore.data
        .map { prefs ->
            val name = prefs[Keys.SIZE_THEME] ?: "medium"
            
            if (name !in sizeOptions)
                "medium"

            name
        }
    suspend fun setSizeTheme(theme: String) {
        context.dataStore.edit { prefs -> 
            prefs[Keys.SIZE_THEME] =  if (theme in sizeOptions) 
                theme 
            else 
                "medium"
        }
    }

    val colorThemeFlow: Flow<String> = context.dataStore.data
        .map { prefs ->
            val name = prefs[Keys.COLOR_THEME] ?: "light"
            
            if (name !in colorOptions)
                "light"

            name
        }
    suspend fun setColorTheme(theme: String) {
        context.dataStore.edit { prefs -> 
            prefs[Keys.COLOR_THEME] =  if (theme in colorOptions) 
                theme 
            else 
                "light"
        }
    }    
}

class PreferencesViewModel(private val repo: PreferencesRepository) : ViewModel() {
    val sizeTheme: StateFlow<String> = repo.sizeThemeFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "medium")
    fun setSizeTheme(theme: String) {
        viewModelScope.launch { repo.setSizeTheme(theme) }
    }

    val colorTheme: StateFlow<String> = repo.colorThemeFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "light")
    fun setColorTheme(theme: String) {
        viewModelScope.launch { repo.setColorTheme(theme) }
    }
}

val LocalColorTheme = compositionLocalOf { lightTheme }
val LocalSizeTheme = compositionLocalOf { largeSize }

@Composable
fun AppPreferences(
    viewModel: PreferencesViewModel,
    content: @Composable () -> Unit
) {
    val sizeName by viewModel.sizeTheme.collectAsStateWithLifecycle()
    val sizeTheme = when (sizeName) {
        "small" -> smallSize
        "large" -> largeSize
        else -> mediumSize
    }

    val colorName by viewModel.colorTheme.collectAsStateWithLifecycle()
    val colorTheme = when (colorName) {
        "dark" -> darkTheme
        else -> lightTheme
    }

    CompositionLocalProvider(
        LocalSizeTheme provides sizeTheme,
        LocalColorTheme provides colorTheme
    ) {
        content()
    }
}

class PreferencesViewModelFactory(
    private val repository: PreferencesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreferencesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PreferencesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}