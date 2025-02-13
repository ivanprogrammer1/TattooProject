package com.tattoshaman.tattoo_detail_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TattooDetailPage(id: Int, selectTattoo: (Int) -> Unit) {
    val viewModel = viewModel<TattooDetailViewModel>(
        factory = TattooDetailDIProvider.viewModelFactory
            ?: throw Exception("Factory not have instance")
    )

    val state by viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.updateTattoo(id)
    }

    TattooDetailScreen(state, selectTattoo)
}