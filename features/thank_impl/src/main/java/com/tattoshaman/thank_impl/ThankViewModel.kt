package com.tattoshaman.thank_impl

import androidx.lifecycle.ViewModel

internal data class ThankState(
    val todo: Int = 1
)

internal class ThankViewModel: ViewModel() {
}

class Thank