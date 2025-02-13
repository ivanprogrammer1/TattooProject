package com.tattoshaman.form_impl

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.Normalizer.Form
import java.time.LocalDate

internal sealed interface FormEffect {
    data class FormSuccessSend(val id: Long) : FormEffect
}

@Immutable
internal data class FormState(
    val inputForm: InputForm = InputForm.None,

    val userName: String = "",
    val isUserNameError: Boolean = false,

    val phoneValue: String = "",
    val isUserPhoneError: Boolean = false,

    val userDate: LocalDate? = null,
    val isUserDateError: Boolean = false,
)

@Stable
internal class FormViewModel(
    private val getSketchUseCase: GetSketchUseCase,
    private val getTattooUseCase: GetTattooUseCase,
    private val sendFormUseCase: SendFormUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(FormState())
    val state = _state.asStateFlow()

    private val _effect: MutableStateFlow<FormEffect?> = MutableStateFlow(null)
    val effect = _effect.asStateFlow()

    fun changeDate(date: LocalDate?) {
        _state.update {
            it.copy(
                userDate = date,
                isUserDateError = false
            )
        }
    }

    fun changeName(value: String) {
        _state.update {
            it.copy(
                userName = value,
                isUserNameError = false
            )
        }
    }

    fun changePhone(value: String) {
        _state.update {
            it.copy(
                phoneValue = value,
                isUserPhoneError = false
            )
        }
    }

    fun updateFormByTattoo(id: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    inputForm = getTattooUseCase.execute(id).toForm()
                )
            }
        }
    }

    fun updateFormBySketch(id: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    inputForm = getSketchUseCase.execute(id).toForm()
                )
            }
        }
    }

    private fun validate(): Boolean {
        var hasError = false

        val values = _state.value
        if (values.userName.isEmpty()) {
            hasError = true
            _state.update {
                it.copy(
                    isUserNameError = true
                )
            }
        }

        if (values.phoneValue.isEmpty()) {
            hasError = true
            _state.update {
                it.copy(
                    isUserPhoneError = true
                )
            }
        }

        if (values.userDate == null) {
            hasError = true
            _state.update {
                it.copy(
                    isUserDateError = true
                )
            }
        }


        return hasError.not()
    }

    fun sendForm() {
        if (validate()) {
            viewModelScope.launch {
                val dataValue = _state.value
                _effect.update {
                    FormEffect.FormSuccessSend(
                        sendFormUseCase.execute(
                            com.tattoshaman.domain.models.Form(
                                tattooName = dataValue.inputForm.getName(),
                                contactsPhone = dataValue.phoneValue,
                                date = dataValue.userDate!!
                            )
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

class FormVMFactory(
    private val getSketchUseCase: GetSketchUseCase,
    private val getTattooUseCase: GetTattooUseCase,
    private val sendFormUseCase: SendFormUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FormViewModel(getSketchUseCase, getTattooUseCase, sendFormUseCase) as T
    }
}