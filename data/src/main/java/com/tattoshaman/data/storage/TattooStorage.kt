package com.tattoshaman.data.storage

import com.tattoshaman.domain.models.Tattoo

interface TattooStorage {
    suspend fun getAllTattoos(): List<Tattoo>
    suspend fun getTattoosByCategory(categoryId: Int): List<Tattoo>
    suspend fun getTattooById(id: Int): Tattoo
}