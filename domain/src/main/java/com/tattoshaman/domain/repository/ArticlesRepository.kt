package com.tattoshaman.domain.repository

import com.tattoshaman.domain.models.Article

abstract class ArticlesRepository(){
    abstract suspend fun getArticles(): List<Article>
    abstract suspend fun getArticleById(id: Int): Article
}