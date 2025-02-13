package com.tattoshaman.article_detail_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.tattoshaman.article_detail_api.ArticleDetailDestination

fun NavGraphBuilder.articleDetail(){
    composable<ArticleDetailDestination> {
        val articleDestination =  it.toRoute<ArticleDetailDestination>()
        ArticleDetailPage(
            articleId = articleDestination.id,
        )
    }
}

fun NavHostController.moveToArticleDetail(id: Int){
    navigate(ArticleDetailDestination(id))
}