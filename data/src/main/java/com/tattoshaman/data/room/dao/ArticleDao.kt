package com.tattoshaman.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.tattoshaman.data.room.entities.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM ${ArticleEntity.ARTICLE_TABLE}")
    suspend fun getArticles(): List<ArticleEntity>

    @Query(
        "SELECT * FROM ${ArticleEntity.ARTICLE_TABLE} " +
                "WHERE ${ArticleEntity.ARTICLE_TABLE}.${ArticleEntity.ARTICLE_ID} = :id"
    )
    suspend fun getArticleById(id: Int): ArticleEntity

}