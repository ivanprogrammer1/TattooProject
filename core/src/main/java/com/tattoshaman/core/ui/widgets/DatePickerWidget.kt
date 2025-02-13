package com.tattoshaman.core.ui.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tattoshaman.core.R
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.utils.DateUtil
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWidget(
    isOpen: Boolean,
    modifier: Modifier = Modifier,
    selectedDate: LocalDate? = null,
    selectableDates: SelectableDates,
    openDialog: () -> Unit,
    dismissDialog: () -> Unit,
    confirmDialog: (LocalDate) -> Unit,
) {
    Text(
        modifier = modifier
            .border(2.dp, TextFieldDefaults.colors().unfocusedContainerColor)
            .clickable(onClick = openDialog)
            .padding(
                vertical = 15.dp,
                horizontal = 10.dp
            ),
        text = selectedDate?.toString() ?: stringResource(R.string.select_availiable_date)
    )

    if (isOpen) {
        val datePickerState = rememberDatePickerState(
            selectableDates = selectableDates
        )
        val confirmEnabled = remember {
            derivedStateOf { datePickerState.selectedDateMillis != null }
        }
        DatePickerDialog(
            onDismissRequest = dismissDialog,
            confirmButton = {
                TextButton(
                    onClick = {
                        val date =
                            DateUtil
                                .convertMillisToLocalDate(datePickerState.selectedDateMillis!!)
                                .toLocalDate()
                        confirmDialog(date)
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text(stringResource(R.string.Accept))
                }
            },
            dismissButton = {
                TextButton(onClick = dismissDialog) { Text(stringResource(R.string.cancel)) }
            }
        ) {
            DatePicker(
                state = datePickerState,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewDatePickerWidget() {
    TattooProjectTheme {
        DatePickerWidget(isOpen = true, openDialog = {}, dismissDialog = {}, confirmDialog = {},
            selectableDates = DatePickerDefaults.AllDates
        )
    }
}