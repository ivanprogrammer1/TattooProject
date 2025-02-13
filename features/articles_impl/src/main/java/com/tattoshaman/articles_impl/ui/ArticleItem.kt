package com.tattoshaman.articles_impl.ui

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.articles_impl.ArticleUI
import com.tattoshaman.articles_impl.R
import com.tattoshaman.core.ui.theme.BlackoutColor
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_10

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun ArticleItem(
    articleUI: ArticleUI,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        GlideImage(
            modifier = Modifier.fillMaxSize(),
            model = articleUI.image,
            contentScale = ContentScale.Crop,
            contentDescription = stringResource(R.string.article_contentdescription),
            loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
        )

        Box(modifier = Modifier
            .fillMaxSize()
            .background(BlackoutColor)
        )

        Text(
            modifier = Modifier.align(Alignment.Center).padding(padding_10),
            textAlign = TextAlign.Center,
            text = articleUI.name,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = MaterialTheme.colorScheme.surface
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewArticleItem() {
    TattooProjectTheme {
        ArticleItem(ArticleUI(1, name = "Kitty Richardson", "https://i.sstatic.net/zes5D.png")) {}
    }
}