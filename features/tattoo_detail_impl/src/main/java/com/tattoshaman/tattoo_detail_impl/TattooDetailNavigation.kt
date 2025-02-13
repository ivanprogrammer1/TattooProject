package com.tattoshaman.tattoo_detail_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tattoshaman.tattoo_detail_api.TattooDetailDestination

fun NavGraphBuilder.tattooDetail(
    selectTattoo: (Int) -> Unit,
) {
    composable<TattooDetailDestination> {
        val destination = it.toRoute<TattooDetailDestination>()
        TattooDetailPage(
            id = destination.id,
            selectTattoo = selectTattoo,
        )
    }
}

fun NavHostController.moveToTattooDetail(id: Int){
    navigate(TattooDetailDestination(id))
}