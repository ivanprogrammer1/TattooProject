package com.tattoshaman.article_detail_impl

import com.tattoshaman.domain.repository.ArticlesRepository

class GetArticleUseCase(private val articleRepository: ArticlesRepository) {
    suspend fun execute(id: Int): ArticleDetailUI{
        return articleRepository.getArticleById(id).toUI()
    }
}