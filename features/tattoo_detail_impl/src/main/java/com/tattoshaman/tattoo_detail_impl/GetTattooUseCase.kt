package com.tattoshaman.tattoo_detail_impl

import com.tattoshaman.domain.models.Tattoo
import com.tattoshaman.domain.repository.TattooRepository

class GetTattooUseCase(private val repository: TattooRepository) {
    suspend fun execute(id: Int): Tattoo{
        return repository.getTattooById(id)
    }
}