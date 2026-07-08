package com.galagidae.broadboard.preferencesui

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.*
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.arrow_back

@Composable
fun PreferencesScreen(viewModel: PreferencesViewModel) {
    val colorTheme by viewModel.colorTheme.collectAsStateWithLifecycle()
    val sizeTheme by viewModel.sizeTheme.collectAsStateWithLifecycle()
    val menuBarOption by viewModel.menuBarOption.collectAsStateWithLifecycle()
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    
    Column(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end= 16.dp,
                top = 64.dp
            )
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton( onClick = { dispatcher?.onBackPressed() }) {
                Icon(
                    modifier = Modifier
                        .size(32.dp), 
                    imageVector = arrow_back,
                    contentDescription = stringResource(R.string.pref_back)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.pref_title),
                style = MaterialTheme.typography.headlineLarge
            )
        }

        Spacer(Modifier.height(24.dp))

        Pickable(
            label = stringResource(R.string.pref_color),
            options = colorLabels,
            selected = colorTheme,
            onSelect = { viewModel.setColorTheme(it) }
        )

        HorizontalDivider()

        Pickable(
            label = stringResource(R.string.pref_size),
            options = sizeLabels,
            selected = sizeTheme,
            onSelect = { viewModel.setSizeTheme(it) }
        )

        HorizontalDivider()

        Pickable(
            label = stringResource(R.string.pref_menu_option),
            options = menuBarLabels,
            selected = menuBarOption,
            onSelect = { viewModel.setMenuBarOption(it) }
        )
    }
}
