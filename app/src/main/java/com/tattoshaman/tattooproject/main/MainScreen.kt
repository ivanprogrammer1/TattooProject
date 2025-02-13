package com.tattoshaman.tattooproject.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.size_100
import com.tattoshaman.core.ui.theme.size_200
import com.tattoshaman.core.ui.theme.space_10
import com.tattoshaman.core.ui.theme.space_20
import com.tattoshaman.tattooproject.R
import com.tattoshaman.tattooproject.main.ui.ArticleItem
import com.tattoshaman.tattooproject.main.ui.CategoryItem
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun MainScreen(
    state: MainState,
    moveArticle: (Int) -> Unit,
    moveCategory: (Int) -> Unit
) {
    Column {
        Spacer(
            modifier = Modifier.height(space_20)
        )

        Text(
            text = stringResource(R.string.main_header),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = padding_10
                ),
            style = MaterialTheme.typography.headlineLarge.copy(
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(modifier = Modifier.height(space_20))

        Text(
            modifier = Modifier.padding(
                horizontal = padding_10
            ),
            text = stringResource(R.string.popular_categories),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(modifier = Modifier.height(space_10))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space_20)
        ) {
            items(state.categories) {
                CategoryItem(
                    category = it,
                    modifier = Modifier.size(size_100)
                ) {
                    moveCategory(it.id)
                }
            }
        }

        Spacer(modifier = Modifier.height(space_20))

        Text(
            modifier = Modifier.padding(
                horizontal = padding_10
            ),
            text = stringResource(R.string.popular_articles),
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(modifier = Modifier.height(space_10))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space_20),
            contentPadding = PaddingValues(space_10)
        ) {
            items(state.articles) {
                ArticleItem(
                    modifier = Modifier.height(size_200),
                    article = it
                ) {
                    moveArticle(it.id)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewMainScreen() {
    TattooProjectTheme {
        MainScreen(MainState(
            categories = persistentListOf(
                CategoryUI(id = 2848, name = "Millie Cook", image = "regione"),
                CategoryUI(id = 2848, name = "Millie Cook", image = "regione"),
                CategoryUI(id = 2848, name = "Millie Cook", image = "regione"),
            ),
            articles = persistentListOf(
                ArticleUI(id = 5279, name = "Irwin Black", image = "natoque"),
                ArticleUI(id = 5279, name = "Irwin Black", image = "natoque"),
                ArticleUI(id = 5279, name = "Irwin Black", image = "natoque"),
            )
        ), moveArticle = {}, moveCategory = {})
    }
}