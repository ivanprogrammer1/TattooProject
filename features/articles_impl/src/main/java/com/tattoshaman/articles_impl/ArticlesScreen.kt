package com.tattoshaman.articles_impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tattoshaman.articles_impl.ui.ArticleItem
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.article_height
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.theme.space_10
import com.tattoshaman.core.ui.theme.space_20
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun ArticlesScreen(
    state: ArticlesState,
    moveArticle: (ArticleUI) -> Unit,
) {
    Column(
        modifier = Modifier.padding(vertical = padding_10)
    ) {
        Text(
            text = stringResource(R.string.list_articles_header),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.padding(
                horizontal = padding_20
            )
        )

        Spacer(modifier = Modifier.height(space_20))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space_10),
            contentPadding = PaddingValues(
                horizontal = padding_20
            )
        ) {
            items(state.articles) {
                ArticleItem(
                    articleUI = it,
                    modifier = Modifier.height(article_height)
                ) {
                    moveArticle(it)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewArticlesScreen() {
    TattooProjectTheme {
        ArticlesScreen(ArticlesState(
            articles = persistentListOf(
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
                ArticleUI(1, name = "Margaret Henson", "https://i.sstatic.net/zes5D.png"),
            )
        ), moveArticle = {})
    }
}