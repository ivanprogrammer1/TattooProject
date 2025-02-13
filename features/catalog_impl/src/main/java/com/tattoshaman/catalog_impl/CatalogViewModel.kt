package com.tattoshaman.catalog_impl

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
internal data class CatalogState(
    val categories: ImmutableList<CategoryUI> = persistentListOf(),
    val selectedCategory: CategoryUI? = null,
    val tattoos: ImmutableList<TattooUI> = persistentListOf()
)

@Stable
internal class CatalogViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getTattoosUseCase: GetTattoosUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CatalogState())
    val state = _state.asStateFlow()

    fun loadCategoriesAndSelect(id: Int) {
        viewModelScope.launch {
            val categories = getCategoriesUseCase.execute().map { it.toUI() }.toImmutableList()
            _state.update { state ->
                state.copy(
                    categories = categories,
                    selectedCategory = categories.first { it.id == id }
                )
            }
            loadTattoos()
        }
    }

    fun loadCategories() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    categories = getCategoriesUseCase.execute().map { it.toUI() }.toImmutableList()
                )
            }
            loadTattoos()
        }
    }

    fun selectCategory(category: CategoryUI?) {
        _state.update {
            it.copy(
                selectedCategory = category
            )
        }
        loadTattoos()
    }

    private fun loadTattoos() {
        viewModelScope.launch {
            _state.update { state ->
                if (state.selectedCategory != null) {
                    state.copy(
                        tattoos = getTattoosUseCase.execute(state.selectedCategory.id)
                            .map { it.toUI() }
                            .toImmutableList()
                    )
                } else {
                    state.copy(
                        tattoos = getTattoosUseCase.execute().map { it.toUI() }
                            .toImmutableList()
                    )
                }
            }
        }
    }
}

class CatalogVMFactory(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getTattoosUseCase: GetTattoosUseCase
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogViewModel(getCategoriesUseCase, getTattoosUseCase) as T
    }
}