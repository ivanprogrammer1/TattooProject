package com.tattoshaman.tattooproject.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tattoshaman.tattooproject.main.MainPage
import kotlinx.serialization.Serializable

@Serializable
data object MainDestination

fun NavGraphBuilder.mainPage(
    moveArticle: (Int) -> Unit,
    moveCategory: (Int) -> Unit
) {
    composable<MainDestination> {
        MainPage(
            moveArticle = moveArticle,
            moveCategory = moveCategory
        )
    }
}

fun NavController.moveToMain() {
    navigate(MainDestination){
        launchSingleTop = true
        popUpTo(MainDestination) {
            inclusive = true
        }
    }
}