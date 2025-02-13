package com.tattoshaman.tattooproject.di

import com.tattoshaman.article_detail_impl.ArticleDetailVMFactory
import com.tattoshaman.article_detail_impl.GetArticleUseCase
import com.tattoshaman.domain.repository.ArticlesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArticleDetailModule {
    @Singleton
    @Provides
    fun providerGetArticleUseCase(articlesRepository: ArticlesRepository): GetArticleUseCase{
        return GetArticleUseCase(articlesRepository)
    }

    @Singleton
    @Provides
    fun provideVMFactory(getArticleUseCase: GetArticleUseCase): ArticleDetailVMFactory{
        return ArticleDetailVMFactory(getArticleUseCase)
    }
}