package com.tattoshaman.catalog_impl

import com.tattoshaman.domain.models.TattooCategory
import com.tattoshaman.domain.repository.TattooCategoryRepository

class GetCategoriesUseCase(private val repository: TattooCategoryRepository) {
    suspend fun execute(): List<TattooCategory>{
        return repository.getCategories()
    }
}