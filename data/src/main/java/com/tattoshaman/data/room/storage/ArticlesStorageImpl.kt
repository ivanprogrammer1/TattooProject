package com.tattoshaman.data.room.storage

import com.tattoshaman.data.room.dao.ArticleDao
import com.tattoshaman.data.room.entities.toDomain
import com.tattoshaman.data.storage.ArticlesStorage
import com.tattoshaman.domain.models.Article

class ArticlesStorageImpl(private val articleDao: ArticleDao) : ArticlesStorage {
    override suspend fun getArticles(): List<Article> {
        return articleDao.getArticles().map { it.toDomain() }
    }

    override suspend fun getArticleById(id: Int): Article {
        return articleDao.getArticleById(id).toDomain()
    }
}