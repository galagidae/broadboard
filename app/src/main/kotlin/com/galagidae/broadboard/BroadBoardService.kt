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
import com.galagidae.broadboard.layout.Shell

class BroadBoardService : InputMethodService(),
    LifecycleOwner,
    SavedStateRegistryOwner {

    private val lifecycleRegistry = LifecycleRegistry(this)
    private val savedStateRegistryController = SavedStateRegistryController.create(this)
    private val autoShift = mutableStateOf(false)
    private val inputContext = mutableStateOf<InputContext>(InputContext.NORMAL)
    private val inputManager: InputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override val lifecycle: Lifecycle get() = lifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    override fun onCreate() {
        super.onCreate()
        savedStateRegistryController.performRestore(null)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)

        // Set on the window decor view so Compose can find it walking up the hierarchy
        val decorView = window?.window?.decorView
        decorView?.setViewTreeLifecycleOwner(this)
        decorView?.setViewTreeSavedStateRegistryOwner(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override fun onCreateInputView(): View {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

        return ComposeView(this).apply {
            setContent {
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
                        onClickKeyboardPicker = ::showKeyboardPicker
                    )
                }
            }
        }
    }

    override fun onStartInputView(info: EditorInfo, restarting: Boolean) {
        super.onStartInputView(info, restarting)

        val ic = getCurrentInputConnection() ?: return

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

    private fun inputText(text: String) {
        val ic = getCurrentInputConnection() ?: return
        
        ic.commitText(text, 1)
    }

    private fun onBackspace() {
        val ic = getCurrentInputConnection() ?: return
        
        ic.deleteSurroundingText(1, 0)
    }

    private fun onEnter() {
        val ic = getCurrentInputConnection() ?: return
        val ei = getCurrentInputEditorInfo() ?: return        

        val imeOptions = ei.imeOptions        
        val noEnterAction = (imeOptions and EditorInfo.IME_FLAG_NO_ENTER_ACTION) != 0

        if (noEnterAction) {
            ic.commitText("\n", 1)
        } else {
            val action = imeOptions and EditorInfo.IME_MASK_ACTION
            ic.performEditorAction(action)
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
            else ->
                inputContext.value = InputContext.NORMAL
        }        
    }

    private fun showKeyboardPicker() {
        inputManager.showInputMethodPicker();
    }
}