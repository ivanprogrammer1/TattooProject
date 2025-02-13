package com.tattoshaman.articles_impl

import com.tattoshaman.domain.models.Article
import com.tattoshaman.domain.repository.ArticlesRepository

class GetArticlesUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun execute(): List<Article>{
        return articlesRepository.getArticles()
    }
}