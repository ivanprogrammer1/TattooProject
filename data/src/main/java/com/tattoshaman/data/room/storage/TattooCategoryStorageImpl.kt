package com.tattoshaman.data.room.storage

import com.tattoshaman.data.room.dao.TattooCategoryDao
import com.tattoshaman.data.room.entities.toDomain
import com.tattoshaman.data.storage.TattooCategoryStorage
import com.tattoshaman.domain.models.TattooCategory

class TattooCategoryStorageImpl(private val tattooCategoryDao: TattooCategoryDao) :
    TattooCategoryStorage {
    override suspend fun getCategories(): List<TattooCategory> {
        return tattooCategoryDao.getCategories().map { it.toDomain() }
    }

    override suspend fun getCategoryById(id: Int): TattooCategory {
        return tattooCategoryDao.getCategoryById(id).toDomain()
    }
}