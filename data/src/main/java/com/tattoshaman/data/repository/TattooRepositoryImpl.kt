package com.tattoshaman.data.repository

import com.tattoshaman.data.storage.TattooStorage
import com.tattoshaman.domain.models.Tattoo
import com.tattoshaman.domain.repository.TattooRepository

class TattooRepositoryImpl(private val tattooStorage: TattooStorage): TattooRepository() {
    override suspend fun getAllTattoos(): List<Tattoo> {
        return tattooStorage.getAllTattoos()
    }

    override suspend fun getTattoosByCategory(categoryId: Int): List<Tattoo> {
        return tattooStorage.getTattoosByCategory(categoryId)
    }

    override suspend fun getTattooById(id: Int): Tattoo {
        return tattooStorage.getTattooById(id)
    }
}