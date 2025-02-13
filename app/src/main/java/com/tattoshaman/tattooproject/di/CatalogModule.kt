package com.tattoshaman.tattooproject.di

import com.tattoshaman.catalog_impl.CatalogVMFactory
import com.tattoshaman.catalog_impl.GetCategoriesUseCase
import com.tattoshaman.catalog_impl.GetTattoosUseCase
import com.tattoshaman.domain.repository.TattooCategoryRepository
import com.tattoshaman.domain.repository.TattooRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CatalogModule {

    @Singleton
    @Provides
    fun provideGetCategoriesUseCase(tattooCategoryRepository: TattooCategoryRepository): GetCategoriesUseCase {
        return GetCategoriesUseCase(tattooCategoryRepository)
    }

    @Singleton
    @Provides
    fun providerGetTattoosUseCase(tattooRepository: TattooRepository): GetTattoosUseCase {
        return GetTattoosUseCase(tattooRepository)
    }

    @Singleton
    @Provides
    fun provideVMFactory(
        getCategoriesUseCase: GetCategoriesUseCase,
        getTattoosUseCase: GetTattoosUseCase
    ): CatalogVMFactory {
        return CatalogVMFactory(
            getCategoriesUseCase = getCategoriesUseCase,
            getTattoosUseCase = getTattoosUseCase
        )
    }
}