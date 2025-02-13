package com.tattoshaman.form_impl

import android.net.Uri
import androidx.compose.runtime.Immutable
import com.tattoshaman.domain.models.Sketch
import com.tattoshaman.domain.models.Tattoo

internal sealed interface InputForm{
    @Immutable
    data class SketchForm(
        val id: Int,
        val name: String,
        val image: Uri
    ): InputForm

    @Immutable
    data class TattooForm(
        val id: Int,
        val name: String,
        val image: String
    ): InputForm

    data object None: InputForm
}


internal fun Tattoo.toForm(): InputForm.TattooForm{
    return InputForm.TattooForm(
        id = id,
        name = name,
        image = image
    )
}

internal fun Sketch.toForm(): InputForm.SketchForm{
    return InputForm.SketchForm(
        id = id,
        name = name,
        image = Uri.parse(image)
    )
}