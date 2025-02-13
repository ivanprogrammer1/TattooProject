package com.tattoshaman.form_impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FormSketchPage(id: Int, sendForm: (Int) -> Unit) {
    val viewModel = viewModel<FormViewModel>(
        factory = FormDIProvider.viewModelFactory ?: throw Exception("Factory not have instance")
    )

    val state by viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.updateFormBySketch(id)
        viewModel.effect.collectLatest {
            when (it) {
                is FormEffect.FormSuccessSend -> sendForm(it.id.toInt())
                null -> {}
            }
            if (it != null) {
                viewModel.clearEffect()
            }
        }
    }

    FormScreen(
        state,
        changeDate = viewModel::changeDate,
        submitForm = viewModel::sendForm,
        changeName = viewModel::changeName,
        changePhone = viewModel::changePhone
    )
}

@Composable
fun FormTattooPage(id: Int, sendForm: (Int) -> Unit) {
    val viewModel = viewModel<FormViewModel>(
        factory = FormDIProvider.viewModelFactory ?: throw Exception("Factory not have instance")
    )

    val state by viewModel.state.collectAsState()
    LaunchedEffect(id) {
        viewModel.updateFormByTattoo(id)
        viewModel.effect.collectLatest {
            when (it) {
                is FormEffect.FormSuccessSend -> sendForm(it.id.toInt())
                null -> {}
            }
            if (it != null) {
                viewModel.clearEffect()
            }
        }
    }

    FormScreen(
        state,
        changeDate = viewModel::changeDate,
        submitForm = viewModel::sendForm,
        changeName = viewModel::changeName,
        changePhone = viewModel::changePhone
    )
}