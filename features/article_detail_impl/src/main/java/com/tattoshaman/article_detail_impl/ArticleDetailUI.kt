package com.tattoshaman.article_detail_impl

import com.tattoshaman.domain.models.Article

data class ArticleDetailUI (
    val id: Int,
    val header: String,
    val text: String
)

internal fun Article.toUI(): ArticleDetailUI{
    return ArticleDetailUI(
        id = id,
        header = header,
        text = text
    )
}