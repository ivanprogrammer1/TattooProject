package com.tattoshaman.domain.repository

import com.tattoshaman.domain.models.TattooCategory

abstract class TattooCategoryRepository {
    abstract suspend fun getCategories(): List<TattooCategory>
    abstract suspend fun getCategoryById(id: Int): TattooCategory
}