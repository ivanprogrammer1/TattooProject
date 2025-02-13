package com.tattoshaman.article_detail_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tattoshaman.core.ui.theme.TattooProjectTheme

@Composable
fun ArticleDetailPage(
    articleId: Int
) {
    val viewModel = viewModel<ArticleDetailViewModel>(
        factory = ArticleDIProvider.viewModelFactory ?: throw Exception("Factory not have instance")
    )

    LaunchedEffect(articleId) {
        viewModel.loadArticle(articleId)
    }

    val state by viewModel.state.collectAsState()
    ArticleDetailScreen(state)
}