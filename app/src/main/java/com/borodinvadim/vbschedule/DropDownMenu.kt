package com.borodinvadim.vbschedule

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DropDownMenu(
    label: String,
    value: String,
    items: List<T>,
    modifier: Modifier = Modifier,
    dropDownModifier: Modifier = Modifier,
    onItemSelected: (T) -> Unit,
) {
    var expanded: Boolean by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = dropDownModifier.fillMaxWidth()
    ) {
        TextField(
            value = value,
            label = { Text(label) },
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            content = {
                items.forEachIndexed { index, element ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = element as? String ?: "",
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        onClick = {
                            onItemSelected(element)
                            expanded = false
                        }
                    )
                }
            }
        )
    }
}