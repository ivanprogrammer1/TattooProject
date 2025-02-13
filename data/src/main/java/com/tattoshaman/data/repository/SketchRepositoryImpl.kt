package com.tattoshaman.data.repository

import com.tattoshaman.data.storage.SketchStorage
import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.models.Sketch
import com.tattoshaman.domain.repository.SketchRepository

class SketchRepositoryImpl(private val storage: SketchStorage): SketchRepository() {
    override suspend fun getAllSketches(): List<Sketch> {
        return storage.getAllSketches()
    }

    override suspend fun getSketchById(id: Int): Sketch {
        return storage.getSketchById(id)
    }

    override suspend fun addSketch(sketch: SketchInput): Int {
        return storage.addSketch(sketch)
    }
}