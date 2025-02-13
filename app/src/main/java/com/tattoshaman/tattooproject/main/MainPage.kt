package com.tattoshaman.tattooproject.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun MainPage(
    moveArticle: (Int) -> Unit,
    moveCategory: (Int) -> Unit
) {
    val viewModel = viewModel<MainViewModel>(
        factory = MainDIProvider.viewModelFactory
    )

    val state by viewModel.state.collectAsState()

    MainScreen(state, moveArticle = moveArticle, moveCategory = moveCategory)
}