package com.tattoshaman.data.room.storage

import com.tattoshaman.data.room.dao.TattooDao
import com.tattoshaman.data.room.entities.toDomain
import com.tattoshaman.data.storage.TattooStorage
import com.tattoshaman.domain.models.Tattoo

class TattooStorageImpl(private val tattooDao: TattooDao): TattooStorage {
    override suspend fun getAllTattoos(): List<Tattoo> {
        return tattooDao.getAllTattoos().map { it.toDomain() }
    }

    override suspend fun getTattoosByCategory(categoryId: Int): List<Tattoo> {
        return tattooDao.getTattoosByCategoryId(categoryId).map { it.toDomain() }
    }

    override suspend fun getTattooById(id: Int): Tattoo {
        return tattooDao.getTattooById(id).toDomain()
    }
}