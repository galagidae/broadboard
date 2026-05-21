package com.galagidae.broadboard

import android.inputmethodservice.InputMethodService
import android.view.View
import androidx.compose.foundation.layout.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.*
import androidx.savedstate.*

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
                    Shell()
                }
            }
        }
    }
}