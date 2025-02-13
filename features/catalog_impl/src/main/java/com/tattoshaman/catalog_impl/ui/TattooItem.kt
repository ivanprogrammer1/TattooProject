package com.tattoshaman.catalog_impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.catalog_impl.R
import com.tattoshaman.catalog_impl.TattooUI
import com.tattoshaman.core.ui.theme.BlackoutColor
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_20

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun TattooItem(tattoo: TattooUI, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = modifier.clickable(onClick = onClick)) {
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            model = tattoo.image,
            contentScale = ContentScale.Crop,
            loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
            contentDescription = stringResource(R.string.tattoo_contentdescription)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BlackoutColor)
        )

        Text(
            modifier = Modifier.align(Alignment.Center).padding(padding_20),
            text = tattoo.name,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewTattooItem() {
    TattooProjectTheme {
        TattooItem(TattooUI(id = 4643, categoryID = 6942, name = "Annabelle Sharp", image = "vero"),
            onClick = {})
    }
}