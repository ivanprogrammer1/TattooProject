package com.tattoshaman.domain.models

data class Tattoo(
    val id: Int,
    val categoryID: Int,
    val name: String,
    val description: String,
    val image: String
)