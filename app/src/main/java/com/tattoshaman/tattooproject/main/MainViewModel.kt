package com.tattoshaman.tattooproject.main

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

internal data class MainState(
    val categories: ImmutableList<CategoryUI> = persistentListOf(),
    val articles: ImmutableList<ArticleUI> = persistentListOf()
)

internal class MainViewModel(
    private val articlesUseCase: GetFavouriteArticlesUseCase,
    private val categoriesUseCase: GetFavouriteCategoriesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        loadCategories()
        loadArticles()
    }

    fun loadCategories() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    categories = categoriesUseCase.execute().map { it.toUI() }.toImmutableList()
                )
            }
        }
    }

    fun loadArticles() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    articles = articlesUseCase.execute().map { it.toUI() }.toImmutableList()
                )
            }
        }
    }
}

class MainVMFactory(
    private val articlesUseCase: GetFavouriteArticlesUseCase,
    private val categoriesUseCase: GetFavouriteCategoriesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(articlesUseCase, categoriesUseCase) as T
    }
}