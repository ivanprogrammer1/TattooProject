package com.tattoshaman.catalog_impl

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CatalogPage(
    moveTattooDetail: (Int) -> Unit,
    categoryId: Int?
) {
    val viewModel = viewModel<CatalogViewModel>(
        factory = CatalogDIProvider.viewModelFactory
    )

    LaunchedEffect(categoryId) {
        if (categoryId == null) {
            viewModel.loadCategories()
        } else {
            viewModel.loadCategoriesAndSelect(categoryId)
        }
    }

    val state by viewModel.state.collectAsState()

    CatalogScreen(
        state,
        selectTattoo = { moveTattooDetail(it.id) },
        selectCategory = { viewModel.selectCategory(it) }
    )
}