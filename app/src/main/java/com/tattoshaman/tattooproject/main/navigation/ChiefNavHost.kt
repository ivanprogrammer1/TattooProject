package com.tattoshaman.tattooproject.main.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tattoshaman.article_detail_impl.moveToArticleDetail
import com.tattoshaman.articles_impl.moveToArticles
import com.tattoshaman.catalog_impl.moveToCatalog
import com.tattoshaman.catalog_impl.moveToCategory
import com.tattoshaman.form_impl.SketchInput
import com.tattoshaman.form_impl.TattooInput
import com.tattoshaman.form_impl.moveToForm
import com.tattoshaman.sketch_impl.moveToSketch
import com.tattoshaman.tattoo_detail_impl.moveToTattooDetail
import com.tattoshaman.tattooproject.R
import kotlinx.serialization.Serializable

@Serializable
object ChiefDestination

fun NavGraphBuilder.chiefs(moveToThank: (Int) -> Unit) {
    composable<ChiefDestination> {
        ChiefNavHost(
            moveToThank = {
                moveToThank(it)
            }
        )
    }
}

fun NavController.moveToChief() {
    navigate(ChiefDestination){
        launchSingleTop = true
        popUpTo<ChiefDestination>(){
            inclusive = true
        }
    }
}

@Composable
private fun ChiefNavHost(
    moveToThank: (Int) -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar(actions = {
                IconButton(onClick = {
                    navController.moveToMain()
                }) {
                    Icon(
                        painter = painterResource(com.tattoshaman.core.R.drawable.ic_main),
                        contentDescription = stringResource(R.string.main)
                    )
                }

                IconButton(onClick = {
                    navController.moveToCatalog()
                }) {
                    Icon(
                        painter = painterResource(com.tattoshaman.core.R.drawable.ic_tattoo),
                        contentDescription = stringResource(R.string.catalog)
                    )
                }

                IconButton(onClick = {
                    navController.moveToArticles()
                }) {
                    Icon(
                        painter = painterResource(com.tattoshaman.core.R.drawable.ic_articles),
                        contentDescription = stringResource(R.string.articles)
                    )
                }

                IconButton(onClick = {
                    navController.moveToSketch()
                }) {
                    Icon(
                        painter = painterResource(com.tattoshaman.core.R.drawable.ic_sketch),
                        contentDescription = stringResource(R.string.sketches)
                    )
                }
            })
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = ChiefGraph
        ) {
            chiefGraph(
                catalogMoveTattooDetail = { id ->
                    navController.moveToTattooDetail(id)
                },
                formSendForm = {
                    navController.moveToMain()
                    moveToThank(it)
                },
                sketchAddSketch = { id ->
                    navController.moveToForm(SketchInput(id))
                },
                tattooDetailSelectTattoo = { id ->
                    navController.moveToForm(TattooInput(id))
                },
                articlesMoveArticle = { id ->
                    navController.moveToArticleDetail(id)
                },
                mainMoveArticle = { id ->
                    navController.moveToArticleDetail(id)
                },
                mainMoveCategory = { id ->
                    navController.moveToCategory(id)
                }
            )
        }
    }
}