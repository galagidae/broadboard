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
    val naturalLayout by viewModel.naturalLayout.collectAsStateWithLifecycle()
    val highlights by viewModel.highlights.collectAsStateWithLifecycle()
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
                text = stringResource(R.string.app_name),
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

        Pickable(
            label = stringResource(R.string.pref_size),
            options = sizeLabels,
            selected = sizeTheme,
            onSelect = { viewModel.setSizeTheme(it) }
        )


        Pickable(
            label = stringResource(R.string.pref_menu_option),
            options = menuBarLabels,
            selected = menuBarOption,
            onSelect = { viewModel.setMenuBarOption(it) }
        )

        Toggle(
            title = R.string.pref_natural_layout,
            subtitle = R.string.pref_natural_layout_sub,
            checked = naturalLayout,
            onChange = { viewModel.setNaturalLayout(it) }
        )

        Toggle(
            title = R.string.pref_highlights,
            subtitle = R.string.pref_highlights_sub,
            checked = highlights,
            onChange = { viewModel.setHighlights(it) }
        )
    }
}
