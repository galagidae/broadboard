package com.galagidae.broadboard.preferencesui

import android.content.Intent
import android.provider.Settings
import androidx.annotation.StringRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.utils.*

@Composable
fun ImeBanner(status: ImeStatus) {
    val context = LocalContext.current
    val darkTheme = isSystemInDarkTheme()

    when (status) {
        ImeStatus.NOT_ENABLED -> Banner(
            headline = R.string.pref_banner_enable_1,
            subtext = R.string.pref_banner_enable_2,
            color = MaterialTheme.colorScheme.errorContainer,
            onClick = { context.startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)) }
        )
        ImeStatus.NOT_ACTIVE -> Banner(
            headline = R.string.pref_banner_use_1,
            subtext = R.string.pref_banner_use_2,
            color = if (darkTheme) Color(0xFF004400) else Color.Green,
            onClick = { showImePicker(context)   }
        )
        ImeStatus.OK -> {}
    }
}

@Composable
private fun Banner(
    @StringRes headline: Int,
    @StringRes subtext: Int,
    color: Color,
    onClick: () -> Unit,
) {
    Surface(
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .clickable (onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(headline),
                fontSize = 24.sp
            )
            Text(
                text = stringResource(subtext),
                fontSize = 16.sp
            )
        }
    }
}
