package com.tattoshaman.tattooproject.di

import com.tattoshaman.core.utils.FileManager
import com.tattoshaman.domain.repository.SketchRepository
import com.tattoshaman.sketch_impl.SaveSketchUseCase
import com.tattoshaman.sketch_impl.SketchVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SketchModule {
    @Singleton
    @Provides
    fun provideSaveSketchUseCase(sketchRepository: SketchRepository, fileManager: FileManager): SaveSketchUseCase{
        return SaveSketchUseCase(sketchRepository, fileManager)
    }

    @Singleton
    @Provides
    fun provideVMFactory(saveSketchUseCase: SaveSketchUseCase): SketchVMFactory{
        return SketchVMFactory(saveSketchUseCase)
    }
}