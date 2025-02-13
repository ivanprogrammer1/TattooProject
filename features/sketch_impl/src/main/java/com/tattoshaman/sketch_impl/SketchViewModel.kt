package com.tattoshaman.sketch_impl

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal sealed interface SketchEffect {
    data class FormSuccessSend(val id: Int) : SketchEffect
}

internal data class SketchState(
    val sketchName: String = "",
    val sketchNameError: Boolean = false,

    val sketchDescription: String = "",

    val sketchSource: Uri? = null,
    val sketchSourceError: Boolean = false
)

internal class SketchViewModel(private val saveSketchUseCase: SaveSketchUseCase) : ViewModel() {
    private val _effect: MutableStateFlow<SketchEffect?> = MutableStateFlow(null)
    val effect = _effect.asStateFlow()

    private val _state = MutableStateFlow(SketchState())
    val state = _state.asStateFlow()

    fun changeName(value: String) {
        _state.update {
            it.copy(
                sketchName = value,
                sketchNameError = false
            )
        }
    }

    fun changeDescription(value: String) {
        _state.update {
            it.copy(
                sketchDescription = value
            )
        }
    }

    fun selectSketchSource(uri: Uri?) {
        _state.update {
            it.copy(
                sketchSourceError = false,
                sketchSource = uri
            )
        }
    }

    private fun validate(): Boolean {
        val sketchForm = state.value

        var isValid = true

        if (sketchForm.sketchSource == null) {
            _state.update {
                it.copy(
                    sketchSourceError = true
                )
            }
            isValid = false
        }

        if (sketchForm.sketchName.isEmpty()) {
            _state.update {
                it.copy(
                    sketchNameError = true
                )
            }
            isValid = false
        }

        return isValid
    }

    fun submitSketch() {
        if (validate()) {
            val form = _state.value
            viewModelScope.launch {
                _effect.update {
                    SketchEffect.FormSuccessSend(
                        saveSketchUseCase.execute(
                            name = form.sketchName,
                            description = form.sketchDescription,
                            uri = form.sketchSource!!
                        )
                    )
                }
            }
        }
    }

    fun clearEffect() {
        _effect.update {
            null
        }
    }
}

class SketchVMFactory(private val saveSketchUseCase: SaveSketchUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SketchViewModel(saveSketchUseCase) as T
    }
}