package com.tattoshaman.sketch_impl

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.theme.space_10
import com.tattoshaman.core.ui.theme.space_20
import com.tattoshaman.core.ui.widgets.ScreenWidget
import com.tattoshaman.sketch_impl.ui.ImageProvider

@Composable
internal fun SketchScreen(
    state: SketchState,
    nameChange: (String) -> Unit,
    descriptionChange: (String) -> Unit,
    selectImage: (Uri?) -> Unit,
    submitSketch: () -> Unit
) {
    Column(
        modifier = Modifier.padding(
            vertical = padding_20
        )
    ) {
        ScreenWidget(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.create_sketch),
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(modifier = Modifier.height(space_20))

            ImageProvider(
                state.sketchSource,
                isError = state.sketchSourceError,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                selectImage = selectImage
            )

            Spacer(modifier = Modifier.height(space_20))

            TextField(
                value = state.sketchName,
                isError = state.sketchNameError,
                placeholder = {
                    Text(
                        text = stringResource(R.string.tattoo_name),
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = nameChange,
                colors = TextFieldDefaults.colors().copy(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(space_10))

            TextField(
                value = state.sketchDescription,
                placeholder = {
                    Text(
                        text = stringResource(R.string.tattoo_description),
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = descriptionChange,
                colors = TextFieldDefaults.colors().copy(
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedContainerColor = MaterialTheme.colorScheme.surface
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(space_20))
        }

        Button(
            onClick = submitSketch,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding_10)
        ) {
            Text(
                text = stringResource(R.string.add_sketch)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewSketchScreen() {
    TattooProjectTheme {
        SketchScreen(SketchState(), nameChange = {}, descriptionChange = {}, selectImage = {}) {}
    }
}