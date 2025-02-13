package com.tattoshaman.data.room.storage

import com.tattoshaman.data.room.dao.SketchDao
import com.tattoshaman.data.room.entities.toDomain
import com.tattoshaman.data.room.entities.toEntity
import com.tattoshaman.data.storage.SketchStorage
import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.models.Sketch

class SketchesStorageImpl(private val sketchDao: SketchDao): SketchStorage {
    override suspend fun getAllSketches(): List<Sketch> {
        return sketchDao.getAll().map { it.toDomain() }
    }

    override suspend fun getSketchById(id: Int): Sketch {
        return sketchDao.getSketchById(id).toDomain()
    }

    override suspend fun addSketch(sketchInput: SketchInput): Int {
        return sketchDao.addSketch(
            sketchInput.toEntity()
        ).toInt()
    }
}