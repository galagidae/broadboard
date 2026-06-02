package com.galagidae.broadboard

import android.inputmethodservice.InputMethodService
import android.view.inputmethod.EditorInfo
import android.view.View
import androidx.compose.foundation.layout.*
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
                        onKey = ::onKey,
                        onBackspace= ::onBackspace,
                        onEnter = ::onEnter
                    )
                }
            }
        }
    }

    private fun onKey(char: Char) {
        val ic = getCurrentInputConnection() ?: return
        
        ic.commitText(char.toString(), 1)
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
}