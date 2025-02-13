package com.tattoshaman.form_impl

import android.net.Uri
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.core.ui.theme.BlackoutColor
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.space_10
import com.tattoshaman.core.ui.theme.space_20
import com.tattoshaman.core.ui.utils.SelectableRangeCurrentDay
import com.tattoshaman.core.ui.widgets.DatePickerWidget
import com.tattoshaman.core.ui.widgets.ScreenWidget
import java.time.LocalDate

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
internal fun FormScreen(
    state: FormState,
    changeName: (String) -> Unit,
    changePhone: (String) -> Unit,
    changeDate: (LocalDate?) -> Unit,
    submitForm: () -> Unit
) {
    ScreenWidget {
        GlideImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop,
            model = state.inputForm.getImage(),
            loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
            contentDescription = stringResource(R.string.tattto_contentdescription)
        )

        Spacer(
            modifier = Modifier.height(space_20)
        )

        Text(
            text = state.inputForm.getName()
        )

        Spacer(
            modifier = Modifier.height(space_10)
        )

        TextField(
            value = state.userName,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = changeName,
            colors = TextFieldDefaults.colors().copy(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.your_name),
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(space_10)
        )

        TextField(
            value = state.phoneValue,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = changePhone,
            colors = TextFieldDefaults.colors().copy(
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                focusedContainerColor = MaterialTheme.colorScheme.surface
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.input_yout_contact),
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            },
            singleLine = true
        )

        Spacer(
            modifier = Modifier.height(space_20)
        )

        var isOpen by remember { mutableStateOf(false) }
        DatePickerWidget(
            isOpen = isOpen,
            selectedDate = state.userDate,
            openDialog = {
                isOpen = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            dismissDialog = {
                isOpen = false
                changeDate(null)
            },
            confirmDialog = {
                isOpen = false
                changeDate(it)
            },
            selectableDates = SelectableRangeCurrentDay
        )

        Spacer(
            modifier = Modifier.height(space_20)
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = submitForm
        ) {
            Text(
                text = stringResource(R.string.send_form)
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewSketchFormScreen() {
    TattooProjectTheme {
        FormScreen(
            FormState(
                inputForm = InputForm.SketchForm(
                    id = 1,
                    name = "Абобус обыкновенный",
                    image = Uri.parse("content://com.tattoshaman.tattooproject.sketchesProvider/sketches/c7b6d5b0-85fe-4859-a763-0d818c4b3ff4.jpg")
                )
            ), submitForm = {}, changeDate = {}, changeName = {}, changePhone = {}
        )
    }
}