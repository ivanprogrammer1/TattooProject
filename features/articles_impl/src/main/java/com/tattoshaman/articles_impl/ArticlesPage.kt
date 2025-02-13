package com.tattoshaman.articles_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ArticlesPage(
    moveArticle: (Int) -> Unit,
) {
    val viewModel = viewModel<ArticlesViewModel>(
        factory = ArticlesDIProvider.viewModelFactory
            ?: throw Exception("Factory not have instance")
    )

    val state by viewModel.state.collectAsState()

    ArticlesScreen(
        state = state,
        moveArticle = { article ->
            moveArticle(article.id)
        }
    )
}