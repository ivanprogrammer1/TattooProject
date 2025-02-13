package com.tattoshaman.catalog_impl

import com.tattoshaman.domain.models.TattooCategory

internal data class CategoryUI(
    val id: Int,
    val image: String,
    val name: String
)

internal fun TattooCategory.toUI(): CategoryUI{
    return CategoryUI(
        id = id,
        image = image,
        name = name
    )
}