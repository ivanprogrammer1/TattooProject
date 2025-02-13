package com.tattoshaman.tattooproject.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.tattoshaman.core.ui.theme.BlackoutColor
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.tattooproject.R
import com.tattoshaman.tattooproject.main.ArticleUI
import com.tattoshaman.tattooproject.main.CategoryUI

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun ArticleItem(
    article: ArticleUI,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            model = article.image,
            contentDescription = stringResource(R.string.category_contentdescription),
            loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BlackoutColor)
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = article.name,
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewArticleItem() {
    TattooProjectTheme {
        ArticleItem(article = ArticleUI(
            id = 2386,
            name = "Allyson Ochoa",
            image = "labores"
        ), onClick = {})
    }
}