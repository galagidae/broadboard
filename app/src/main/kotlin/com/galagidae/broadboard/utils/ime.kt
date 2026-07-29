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