package com.tattoshaman.data.repository

import com.tattoshaman.data.storage.ArticlesStorage
import com.tattoshaman.domain.models.Article
import com.tattoshaman.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(private val articlesStorage: ArticlesStorage): ArticlesRepository() {
    override suspend fun getArticles(): List<Article> {
        return articlesStorage.getArticles()
    }

    override suspend fun getArticleById(id: Int): Article {
        return articlesStorage.getArticleById(id)
    }
}