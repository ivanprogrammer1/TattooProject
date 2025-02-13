package com.tattoshaman.article_detail_impl

import android.util.Log
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Immutable
internal data class ArticleDetailState(
    val article: ArticleDetailUI? = null
)

@Stable
internal class ArticleDetailViewModel(private val getArticleUseCase: GetArticleUseCase) :
    ViewModel() {
    private val _state = MutableStateFlow(ArticleDetailState())
    val state = _state.asStateFlow()

    fun loadArticle(id: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    article = getArticleUseCase.execute(id)
                )
            }
        }
    }
}

class ArticleDetailVMFactory(private val getArticleUseCase: GetArticleUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticleDetailViewModel(getArticleUseCase) as T
    }
}

