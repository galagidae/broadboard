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

package com.galagidae.broadboard.preferencesui

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.*
import android.content.Intent
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.compose.ui.platform.LocalContext
import com.galagidae.broadboard.*
import com.galagidae.broadboard.R
import com.galagidae.broadboard.icons.arrow_back
import com.galagidae.broadboard.utils.*

@Composable
fun PreferencesScreen(
    viewModel: PreferencesViewModel,
    imeStatus: ImeStatus,
) {
    val colorTheme by viewModel.colorTheme.collectAsStateWithLifecycle()
    val sizeTheme by viewModel.sizeTheme.collectAsStateWithLifecycle()
    val menuBarOption by viewModel.menuBarOption.collectAsStateWithLifecycle()
    val naturalLayout by viewModel.naturalLayout.collectAsStateWithLifecycle()
    val highlights by viewModel.highlights.collectAsStateWithLifecycle()
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val vibrate = LocalVibrate.current
	val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
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
        
        ImeBanner(status = imeStatus)

        Spacer(Modifier.height(24.dp))

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.clickable {
					val imm =
						context.getSystemService(InputMethodManager::class.java)

					val inputMethodId = imm.inputMethodList
						.firstOrNull {
							it.packageName == context.packageName
						}
						?.id

					val intent =
						Intent(Settings.ACTION_INPUT_METHOD_SUBTYPE_SETTINGS)

					if (inputMethodId != null) {
						intent.putExtra(
							Settings.EXTRA_INPUT_METHOD_ID,
							inputMethodId
						)
					}

					context.startActivity(intent)
				}
				.padding(vertical = 16.dp),
			verticalAlignment = Alignment.CenterVertically
		) {
			Column(
				modifier = Modifier.weight(1f)
			) {
				Text(
					text = stringResource(R.string.pref_languages),
					style = MaterialTheme.typography.titleMedium
				)

				Text(
					text = stringResource(R.string.pref_languages_sub),
					style = MaterialTheme.typography.bodyMedium,
					color = MaterialTheme.colorScheme.onSurfaceVariant
				)
			}

			Text(
				text = ">",
				style = MaterialTheme.typography.titleLarge
			)
		}

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

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
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

            Toggle(
                title = R.string.pref_vibrate,
                subtitle = R.string.pref_vibrate_sub,
                checked = vibrate,
                onChange = { viewModel.setVibrate(it) }
            )
        }
    }
}
