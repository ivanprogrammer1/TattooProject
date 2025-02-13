package com.tattoshaman.data.storage

import com.tattoshaman.domain.models.TattooCategory

interface TattooCategoryStorage {
    abstract suspend fun getCategories(): List<TattooCategory>
    abstract suspend fun getCategoryById(id: Int): TattooCategory
}