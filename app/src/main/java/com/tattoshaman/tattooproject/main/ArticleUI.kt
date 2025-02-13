package com.tattoshaman.tattooproject.main

import com.tattoshaman.domain.models.Article

data class ArticleUI(
    val id: Int,
    val name: String,
    val image: String
)

internal fun Article.toUI(): ArticleUI{
    return ArticleUI(
        id = id,
        name = header,
        image = image
    )
}