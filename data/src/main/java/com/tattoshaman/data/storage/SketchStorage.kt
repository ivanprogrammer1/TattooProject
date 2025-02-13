package com.tattoshaman.data.storage

import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.models.Sketch

interface SketchStorage {
    suspend fun getAllSketches(): List<Sketch>
    suspend fun getSketchById(id: Int): Sketch
    suspend fun addSketch(sketchInput: SketchInput): Int
}