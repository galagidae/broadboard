package com.galagidae.broadboard.utils

import android.util.Log

private const val TAG = "BRDBRD"

fun log(msg: String) {
    Log.d(TAG, msg)
}

fun log(msg: String, data: Any?) {
    Log.d(TAG, "$msg: $data")
}