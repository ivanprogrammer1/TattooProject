package com.tattoshaman.tattoo_detail_impl

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
internal data class TattooDetailState(
    val tattoo: TattooUI? = null
)

@Stable
internal class TattooDetailViewModel(private val getTattooUseCase: GetTattooUseCase) : ViewModel() {
    private val _state = MutableStateFlow(TattooDetailState())
    val state = _state.asStateFlow()

    fun updateTattoo(id: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    tattoo = getTattooUseCase.execute(id).toUI()
                )
            }
        }
    }
}

class TattooDetailVMFactory(private val getTattooUseCase: GetTattooUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TattooDetailViewModel(getTattooUseCase) as T
    }
}