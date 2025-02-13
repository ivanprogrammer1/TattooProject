package com.tattoshaman.catalog_impl

import com.tattoshaman.domain.models.Tattoo

internal data class TattooUI(
    val id: Int,
    val categoryID: Int,
    val name: String,
    val image: String
)

internal fun Tattoo.toUI(): TattooUI{
    return TattooUI(
        id = id,
        categoryID = categoryID,
        name = name,
        image = image
    )
}