package com.tattoshaman.tattooproject.di

import com.tattoshaman.articles_impl.ArticlesVMFactory
import com.tattoshaman.articles_impl.GetArticlesUseCase
import com.tattoshaman.domain.repository.ArticlesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArticlesModule {
    @Singleton
    @Provides
    fun providerArticlesUseCase(articlesRepository: ArticlesRepository): GetArticlesUseCase{
        return GetArticlesUseCase(articlesRepository)
    }


    @Singleton
    @Provides
    fun provideVMFactory(getArticleUseCase: GetArticlesUseCase): ArticlesVMFactory{
        return ArticlesVMFactory(getArticleUseCase)
    }
}