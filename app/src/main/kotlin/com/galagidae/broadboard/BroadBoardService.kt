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

import android.content.Context
import android.inputmethodservice.InputMethodService
import android.text.InputType
import android.view.inputmethod.*
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.*
import androidx.savedstate.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.layout.Shell
import com.galagidae.broadboard.utils.*
import kotlinx.coroutines.cancel

import java.util.Locale

class BroadBoardService : InputMethodService(),
    LifecycleOwner,
    SavedStateRegistryOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)
    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    private val autoShift = mutableStateOf(false)
    private val inputContext = mutableStateOf<InputContext>(InputContext.NORMAL)
    private val currentLocale = mutableStateOf<String>("en-US")
    private val inputManager: InputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }
    private val actionKey = mutableStateOf<ActionKey>(ActionKey.Newline)
    private lateinit var preferencesViewModel: PreferencesViewModel    

    override val lifecycle: Lifecycle get() = lifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    override fun onCreate() {
        super.onCreate()
        savedStateRegistryController.performRestore(null)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        val repository = PreferencesRepository(applicationContext)
        preferencesViewModel = PreferencesViewModel(repository)

        // Set on the window decor view so Compose can find it walking up the hierarchy
        val decorView = window?.window?.decorView
        decorView?.setViewTreeLifecycleOwner(this)
        decorView?.setViewTreeSavedStateRegistryOwner(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        preferencesViewModel.viewModelScope.cancel()
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun onCreateInputView(): View {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return ComposeView(this).apply {
            setContent {
                AppPreferences(viewModel = preferencesViewModel) {
                    val navBarInsets = WindowInsets.navigationBars
                    val navBarBottom = with(LocalDensity.current) {
                        navBarInsets.getBottom(this).toDp()
                    }

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = navBarBottom),
                    ) {
                        Shell(
                            onInput = ::inputText,
                            onBackspace= ::onBackspace,
                            onEnter = ::onEnter,
                            autoShift = autoShift,
                            inputContext = inputContext,
                            currentLocale = currentLocale,
                            onClickKeyboardPicker = ::showKeyboardPicker,
                            actionKey = actionKey
                        )
                    }
                }
            }
        }
    }

    override fun onStartInputView(info: EditorInfo, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        actionKey.value = resolveActionKey(info)

        val ic = getCurrentInputConnection() ?: return

        val currentSubType = inputManager.currentInputMethodSubtype
        setLocale(currentSubType)

        updateAutoCasing(ic, info)
        setInputContext(info)
    }

    override fun onUpdateSelection(
        oldSelStart: Int,
        oldSelEnd: Int,
        newSelStart: Int,
        newSelEnd: Int,
        candidatesStart: Int,
        candidatesEnd: Int
    ) {
        super.onUpdateSelection(oldSelStart, oldSelEnd, newSelStart, newSelEnd, candidatesStart, candidatesEnd)
        
        val ic = getCurrentInputConnection() ?: return
        val ei = getCurrentInputEditorInfo() ?: return                

        updateAutoCasing(ic, ei)
    }

    override fun onCurrentInputMethodSubtypeChanged(subtype: InputMethodSubtype?) {
        super.onCurrentInputMethodSubtypeChanged(subtype)
        setLocale(subtype)
    }

    private fun inputText(text: String) {
        val ic = getCurrentInputConnection() ?: return
        
        ic.commitText(text, 1)
    }

    private fun onBackspace() {
        val ic = getCurrentInputConnection() ?: return
        
        ic.deleteSurroundingText(1, 0)
    }

    private fun onEnter() {
        val ic = currentInputConnection ?: return
        
        when (val key = actionKey.value) {
            is ActionKey.Standard   -> ic.performEditorAction(key.id)
            is ActionKey.Custom     -> ic.performEditorAction(key.id)
            ActionKey.Newline           -> ic.commitText("\n", 1)
        }
    }

    private fun updateAutoCasing(ic: InputConnection, ei: EditorInfo) {
        val mode = ic.getCursorCapsMode(ei.inputType)
        autoShift.value = mode != 0
    }

    private fun setInputContext(ei: EditorInfo) {
        val inputClass = ei.inputType and InputType.TYPE_MASK_CLASS
        val inputVariation = ei.inputType and InputType.TYPE_MASK_VARIATION

        when (inputClass) {
            InputType.TYPE_CLASS_TEXT -> {
                when (inputVariation) {
                    InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS,
                    InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS ->
                        inputContext.value = InputContext.EMAIL
                    InputType.TYPE_TEXT_VARIATION_URI ->
                        inputContext.value = InputContext.URL
                    else ->
                        inputContext.value = InputContext.NORMAL
                }
            }
            InputType.TYPE_CLASS_NUMBER,
            InputType.TYPE_CLASS_PHONE ->
                inputContext.value = InputContext.NUMERIC
            else ->
                inputContext.value = InputContext.NORMAL
        }        
    }

    private fun showKeyboardPicker() {
        inputManager.showInputMethodPicker();
    }

    private fun resolveActionKey(info: EditorInfo): ActionKey {
        // A custom label always wins.
        info.actionLabel?.let { label ->
            return ActionKey.Custom(info.actionId, label.toString())
        }

        val noEnterAction =
            info.imeOptions and EditorInfo.IME_FLAG_NO_ENTER_ACTION != 0

        if (noEnterAction) return ActionKey.Newline

        val action = info.imeOptions and EditorInfo.IME_MASK_ACTION

        return when (action) {
            EditorInfo.IME_ACTION_GO       -> ActionKey.Standard(action, StandardActionType.GO)
            EditorInfo.IME_ACTION_SEARCH   -> ActionKey.Standard(action, StandardActionType.SEARCH)
            EditorInfo.IME_ACTION_SEND     -> ActionKey.Standard(action, StandardActionType.SEND)
            EditorInfo.IME_ACTION_NEXT     -> ActionKey.Standard(action, StandardActionType.NEXT)
            EditorInfo.IME_ACTION_PREVIOUS -> ActionKey.Standard(action, StandardActionType.PREVIOUS)
            EditorInfo.IME_ACTION_DONE     -> ActionKey.Standard(action, StandardActionType.DONE)
            else -> ActionKey.Newline
        }
    }

    fun setLocale(subtype: InputMethodSubtype?) {
        if (subtype == null) {
            // TODO: Look at device's installed locales and pick one
            currentLocale.value = "en-US"
            return
        }

        val languageTag = subtype!!.getLanguageTag()
        val language = Locale.forLanguageTag(languageTag).language

        currentLocale.value = when(language) {
            "de" -> "de"
            "el" -> "el"
            "en" -> when(languageTag) {
                "en-GB" -> "en-GB"
                else -> "en-US"
            }
            "es" -> when(languageTag) {
                "es-ES" -> "es-ES"
                "es-US" -> "en-US" // Basically jsut a US keyboard
                else -> "es-419"
            }
            "fr" -> "fr"
            "id" -> "id"
            "it" -> "it"
            "ms" -> "ms"
            "nl" -> "nl"
            "pl" -> "pl"
            "pt" -> when(languageTag) {
                "pt-PT" -> "pt-PT"
                else -> "pt-BR"
            }
            "ru" -> "ru"
            "tr" -> "tr"
            "uk" -> "uk"
            else -> languageTag
        }
    }
}