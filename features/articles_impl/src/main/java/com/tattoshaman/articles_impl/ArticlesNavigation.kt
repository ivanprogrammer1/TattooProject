package com.tattoshaman.articles_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tattoshaman.articles_api.ArticlesDestination

fun NavGraphBuilder.articles(
    moveArticle: (Int) -> Unit
){
    composable<ArticlesDestination> {
        ArticlesPage(moveArticle)
    }
}

fun NavHostController.moveToArticles(){
    navigate(ArticlesDestination){
        popUpTo<ArticlesDestination>()
        launchSingleTop = true
    }
}