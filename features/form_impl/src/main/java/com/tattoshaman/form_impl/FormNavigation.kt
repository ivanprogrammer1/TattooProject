package com.tattoshaman.form_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tattoshaman.form_api.SketchFormDestination
import com.tattoshaman.form_api.TattooFormDestination

fun NavGraphBuilder.form(
    sendForm: (Int) -> Unit
) {
    composable<TattooFormDestination> {
        val destination = it.toRoute<TattooFormDestination>()
        FormTattooPage(destination.id, sendForm)
    }
    composable<SketchFormDestination> {
        val destination = it.toRoute<SketchFormDestination>()
        FormSketchPage(destination.id, sendForm)
    }
}

@JvmInline
value class SketchInput(val id: Int)

@JvmInline
value class TattooInput(val id: Int)

fun NavHostController.moveToForm(sketch: TattooInput){
    navigate(TattooFormDestination(sketch.id))
}

fun NavHostController.moveToForm(tattoo: SketchInput){
    navigate(SketchFormDestination(tattoo.id))
}