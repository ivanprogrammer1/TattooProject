package com.tattoshaman.thank_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tattoshaman.thank_api.ThankDestination

fun NavGraphBuilder.thank(
    moveToMain: () -> Unit
) {
    composable<ThankDestination> {
        ThankPage(moveToMain)
    }
}

fun NavHostController.moveToThank(id: Int) {
    navigate(ThankDestination(id))
}