package com.galagidae.broadboard.utils

import android.content.ComponentName
import android.content.Context
import android.provider.Settings
import android.view.inputmethod.InputMethodManager

enum class ImeStatus {
    NOT_ENABLED,
    NOT_ACTIVE,
    OK
}

fun checkImeStatus(context: Context): ImeStatus {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val packageName = context.packageName

    val isEnabled = imm.enabledInputMethodList.any { it.packageName == packageName }
    if (!isEnabled) return ImeStatus.NOT_ENABLED

    val currentIme = Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.DEFAULT_INPUT_METHOD
    )
    val currentComponent = currentIme?.let { ComponentName.unflattenFromString(it) }
    val isActive = currentComponent?.packageName == packageName

    return if (isActive) ImeStatus.OK else ImeStatus.NOT_ACTIVE
}

fun showImePicker(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showInputMethodPicker()
}