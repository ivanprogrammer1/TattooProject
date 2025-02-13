package com.tattoshaman.tattooproject.di

import com.tattoshaman.domain.repository.ArticlesRepository
import com.tattoshaman.domain.repository.TattooCategoryRepository
import com.tattoshaman.tattooproject.main.GetFavouriteArticlesUseCase
import com.tattoshaman.tattooproject.main.GetFavouriteCategoriesUseCase
import com.tattoshaman.tattooproject.main.MainVMFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun provideGetFavouriteArticlesUseCase(articlesRepository: ArticlesRepository): GetFavouriteArticlesUseCase {
        return GetFavouriteArticlesUseCase(articlesRepository)
    }

    @Provides
    fun provideGetFavouriteCategoriesUseCase(categoriesRepository: TattooCategoryRepository): GetFavouriteCategoriesUseCase {
        return GetFavouriteCategoriesUseCase(categoriesRepository)
    }

    @Provides
    fun provideVMFactory(
        articlesUseCase: GetFavouriteArticlesUseCase,
        categoriesUseCase: GetFavouriteCategoriesUseCase
    ): MainVMFactory {
        return MainVMFactory(articlesUseCase, categoriesUseCase)
    }
}