package com.tattoshaman.articles_impl

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Immutable
internal data class ArticlesState(
    val articles: ImmutableList<ArticleUI> = persistentListOf()
)

internal class ArticlesViewModel(private val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {
    private val _state = MutableStateFlow(ArticlesState())
    val state = _state.asStateFlow()

    init {
        loadArticles()
    }

    private fun loadArticles() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    articles = getArticlesUseCase.execute().map {
                        it.toUI()
                    }.toImmutableList()
                )
            }
        }
    }
}


class ArticlesVMFactory(private val getArticlesUseCase: GetArticlesUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticlesViewModel(getArticlesUseCase) as T
    }
}