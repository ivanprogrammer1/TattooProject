package com.tattoshaman.tattoo_detail_impl

import com.tattoshaman.domain.models.Tattoo

internal data class TattooUI(
    val id: Int,
    val name: String,
    val description: String,
    val image: String
)

internal fun Tattoo.toUI(): TattooUI{
    return TattooUI(
        id = id,
        name = name,
        description = description,
        image = image
    )
}