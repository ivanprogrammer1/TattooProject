package com.tattoshaman.data.repository

import com.tattoshaman.data.storage.TattooCategoryStorage
import com.tattoshaman.domain.models.TattooCategory
import com.tattoshaman.domain.repository.TattooCategoryRepository

class TattooCategoryRepositoryImpl(private val tattooCategoryStorage: TattooCategoryStorage) :
    TattooCategoryRepository() {
    override suspend fun getCategories(): List<TattooCategory> {
        return tattooCategoryStorage.getCategories()
    }

    override suspend fun getCategoryById(id: Int): TattooCategory {
        return tattooCategoryStorage.getCategoryById(id)
    }
}