package com.tattoshaman.domain.repository

import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.models.Sketch

abstract class SketchRepository {
    abstract suspend fun getAllSketches(): List<Sketch>
    abstract suspend fun getSketchById(id: Int): Sketch
    abstract suspend fun addSketch(sketch: SketchInput): Int
}