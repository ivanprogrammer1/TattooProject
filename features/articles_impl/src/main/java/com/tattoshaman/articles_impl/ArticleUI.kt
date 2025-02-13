package com.tattoshaman.articles_impl

import com.tattoshaman.domain.models.Article

internal data class ArticleUI(
    val id: Int,
    val name: String,
    val image: String
)

internal fun Article.toUI(): ArticleUI {
    return ArticleUI(
        id = id,
        name = header,
        image = image
    )
}