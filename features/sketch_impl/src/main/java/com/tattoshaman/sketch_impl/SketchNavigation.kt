package com.tattoshaman.sketch_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tattoshaman.sketch_api.SketchDestination

fun NavGraphBuilder.sketch(
    addSketch: (Int) -> Unit
) {
    composable<SketchDestination> {
        SketchPage(
            addSketch = addSketch
        )
    }
}

fun NavHostController.moveToSketch(){
    navigate(SketchDestination){
        popUpTo<SketchDestination>()
        launchSingleTop = true
    }
}