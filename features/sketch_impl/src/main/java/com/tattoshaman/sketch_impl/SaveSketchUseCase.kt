package com.tattoshaman.sketch_impl

import android.net.Uri
import com.tattoshaman.core.utils.FileManager
import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.repository.SketchRepository

class SaveSketchUseCase(
    private val sketchRepository: SketchRepository,
    private val fileManager: FileManager
) {
    suspend fun execute(name: String, description: String, uri: Uri): Int {
        val savedUri = fileManager.copyFileToStorage(uri)

        val id = sketchRepository.addSketch(
            SketchInput(
                name = name,
                description = description,
                image = savedUri.toString()
            )
        )

        return id
    }
}