package com.tattoshaman.form_impl

import com.tattoshaman.domain.models.Sketch
import com.tattoshaman.domain.repository.SketchRepository

class GetSketchUseCase(
    private val sketchRepository: SketchRepository
) {
    suspend fun execute(id: Int): Sketch{
        return sketchRepository.getSketchById(id)
    }
}