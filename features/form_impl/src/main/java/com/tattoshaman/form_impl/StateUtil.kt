package com.tattoshaman.form_impl

import android.net.Uri

internal fun InputForm.getImage(): Uri?{
    return when(this){
        InputForm.None -> null
        is InputForm.SketchForm -> {
            return image
        }
        is InputForm.TattooForm -> {
            return Uri.parse(image)
        }
    }
}

internal fun InputForm.getName(): String{
    return when(this){
        InputForm.None -> ""
        is InputForm.SketchForm -> name
        is InputForm.TattooForm -> name
    }
}