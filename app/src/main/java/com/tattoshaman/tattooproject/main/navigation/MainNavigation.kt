package com.tattoshaman.tattooproject.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tattoshaman.thank_impl.moveToThank
import com.tattoshaman.thank_impl.thank

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = ChiefDestination
    ) {
        chiefs(
            moveToThank = navController::moveToThank
        )
        thank {
            navController.moveToChief()
        }
    }
}