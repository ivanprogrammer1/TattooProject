package com.tattoshaman.tattooproject.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.tattoshaman.article_detail_impl.articleDetail
import com.tattoshaman.articles_impl.articles
import com.tattoshaman.catalog_impl.catalog
import com.tattoshaman.form_impl.form
import com.tattoshaman.sketch_impl.sketch
import com.tattoshaman.tattoo_detail_impl.tattooDetail
import kotlinx.serialization.Serializable

@Serializable
data object ChiefGraph

fun NavGraphBuilder.chiefGraph(
    mainMoveArticle: (Int) -> Unit,
    mainMoveCategory: (Int) -> Unit,
    articlesMoveArticle: (Int) -> Unit,
    catalogMoveTattooDetail: (Int) -> Unit,
    formSendForm: (Int) -> Unit,
    sketchAddSketch: (Int) -> Unit,
    tattooDetailSelectTattoo: (Int) -> Unit
) {
    navigation<ChiefGraph>(
        startDestination = MainDestination
    ) {
        mainPage(
            moveArticle = mainMoveArticle,
            moveCategory = mainMoveCategory
        )
        articleDetail()
        articles(
            moveArticle = articlesMoveArticle
        )
        catalog(
            moveTattooDetail = catalogMoveTattooDetail,
        )
        form(
            sendForm = formSendForm
        )
        sketch(
            addSketch = sketchAddSketch
        )
        tattooDetail(
            selectTattoo = tattooDetailSelectTattoo
        )
    }
}