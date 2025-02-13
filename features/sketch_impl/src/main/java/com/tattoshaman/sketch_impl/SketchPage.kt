package com.tattoshaman.sketch_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun SketchPage(
    addSketch: (Int) -> Unit
) {
    val viewModel = viewModel<SketchViewModel>(
        factory = SketchDIProvider.viewModelFactory ?: throw Exception("Factory not have instance")
    )

    LaunchedEffect(Unit) {
        launch {
            viewModel.effect.collectLatest {
                when (it) {
                    is SketchEffect.FormSuccessSend -> addSketch(it.id)
                    null -> {}
                }
                if (it != null) {
                    viewModel.clearEffect()
                }
            }
        }
    }

    val state by viewModel.state.collectAsState()

    SketchScreen(
        state,
        selectImage = viewModel::selectSketchSource,
        nameChange = viewModel::changeName,
        descriptionChange = viewModel::changeDescription,
        submitSketch = viewModel::submitSketch
    )
}