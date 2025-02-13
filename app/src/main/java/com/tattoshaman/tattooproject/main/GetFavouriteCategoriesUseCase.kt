package com.tattoshaman.tattooproject.main

import com.tattoshaman.domain.models.TattooCategory
import com.tattoshaman.domain.repository.TattooCategoryRepository

class GetFavouriteCategoriesUseCase(private val categoriesRepository: TattooCategoryRepository) {
    suspend fun execute(): List<TattooCategory>{
        return categoriesRepository.getCategories().take(3)
    }
}