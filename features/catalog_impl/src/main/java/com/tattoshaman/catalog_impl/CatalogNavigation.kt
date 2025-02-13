package com.tattoshaman.catalog_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tattoshaman.catalog_api.CatalogDestination
import com.tattoshaman.catalog_api.CategoryDestination

fun NavGraphBuilder.catalog(
    moveTattooDetail: (Int) -> Unit,
) {
    composable<CatalogDestination> {
        CatalogPage(
            moveTattooDetail = moveTattooDetail,
            null
        )
    }

    composable<CategoryDestination> {
        val destination = it.toRoute<CategoryDestination>()
        CatalogPage(
            moveTattooDetail = moveTattooDetail,
            destination.id
        )
    }
}

fun NavHostController.moveToCatalog() {
    navigate(CatalogDestination){
        popUpTo<CatalogDestination>()
        launchSingleTop = true
    }
}

fun NavHostController.moveToCategory(id: Int) {
    navigate(CategoryDestination(id))
}