package com.tattoshaman.thank_impl

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.widgets.ScreenWidget

@Composable
fun ThankPage(
    moveToMain: () -> Unit
) {
    Scaffold {
        ScreenWidget(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Box(
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(padding_20),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.thanks_text),
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            }

            Button(
                onClick = moveToMain,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.move_to_main)
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewThankPage() {
    TattooProjectTheme {
        ThankPage {}
    }
}