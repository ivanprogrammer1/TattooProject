package com.tattoshaman.catalog_impl

import com.tattoshaman.domain.models.Tattoo
import com.tattoshaman.domain.repository.TattooRepository

class GetTattoosUseCase(private val repository: TattooRepository) {
    suspend fun execute(categoryId: Int): List<Tattoo>{
        return repository.getTattoosByCategory(categoryId)
    }

    suspend fun execute(): List<Tattoo>{
        return repository.getAllTattoos()
    }
}