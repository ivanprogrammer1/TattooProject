package com.tattoshaman.tattoo_detail_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.theme.space_10
import com.tattoshaman.core.ui.theme.space_20
import com.tattoshaman.core.ui.utils.convertByHtml
import com.tattoshaman.core.ui.widgets.ScreenWidget

const val EMPTY = ""

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun TattooDetailScreen(state: TattooDetailState, selectTattoo: (Int) -> Unit) {
    val tattoo = state.tattoo

    Column(
        modifier = Modifier.padding(
            bottom = padding_10
        )
    ) {
        ScreenWidget(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = tattoo?.name ?: EMPTY,
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(modifier = Modifier.height(space_20))

            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                model = tattoo?.image,
                contentScale = ContentScale.Crop,
                loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
                contentDescription = stringResource(R.string.tattoo_contentdescription)
            )

            Spacer(modifier = Modifier.height(space_20))

            Text(
                text = tattoo?.description?.convertByHtml() ?: AnnotatedString(EMPTY),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }

        Spacer(modifier = Modifier.height(space_10))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = padding_20
                ),
            enabled = tattoo != null,
            onClick = {
                selectTattoo(tattoo!!.id)
            }
        ) {
            Text(
                text = stringResource(R.string.submit_tattoo)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewTattooDetailScreen() {
    TattooProjectTheme {
        TattooDetailScreen(
            state = TattooDetailState(
                tattoo = TattooUI(
                    id = 1,
                    name = "Basic name",
                    description = "<b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b><b>HTML CONTENT</b>",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbF8xHopQ0XHILu25v0Pt1esEUogqV1iaHXw&s"
                )
            )
        ) { }
    }
}