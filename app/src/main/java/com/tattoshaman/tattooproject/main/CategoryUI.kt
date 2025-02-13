package com.tattoshaman.tattooproject.main

import com.tattoshaman.domain.models.TattooCategory

internal data class CategoryUI(
    val id: Int,
    val name: String,
    val image: String
)

internal fun TattooCategory.toUI(): CategoryUI{
    return CategoryUI(
        id = id,
        name = name,
        image = image
    )
}