package com.tattoshaman.data.storage

import com.tattoshaman.domain.models.Article

interface ArticlesStorage {
    abstract suspend fun getArticles(): List<Article>
    abstract suspend fun getArticleById(id: Int): Article
}