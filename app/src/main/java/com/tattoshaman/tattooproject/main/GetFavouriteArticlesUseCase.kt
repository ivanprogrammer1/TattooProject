package com.tattoshaman.tattooproject.main

import com.tattoshaman.domain.models.Article
import com.tattoshaman.domain.repository.ArticlesRepository

class GetFavouriteArticlesUseCase(private val articlesRepository: ArticlesRepository) {
    suspend fun execute(): List<Article> {
        return articlesRepository.getArticles().take(3)
    }
}