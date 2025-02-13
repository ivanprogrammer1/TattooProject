package com.tattoshaman.form_impl

import com.tattoshaman.domain.models.Tattoo
import com.tattoshaman.domain.repository.TattooRepository

class GetTattooUseCase(private val tattooRepository: TattooRepository) {
    suspend fun execute(id: Int): Tattoo{
        return tattooRepository.getTattooById(id)
    }
}