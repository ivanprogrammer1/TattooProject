package com.tattoshaman.domain.repository

import com.tattoshaman.domain.models.Tattoo

abstract class TattooRepository {
    abstract suspend fun getAllTattoos(): List<Tattoo>
    abstract suspend fun getTattoosByCategory(categoryId: Int): List<Tattoo>
    abstract suspend fun getTattooById(id: Int): Tattoo
}