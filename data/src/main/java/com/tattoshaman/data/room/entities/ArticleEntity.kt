package com.tattoshaman.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tattoshaman.data.room.entities.ArticleEntity.Companion.ARTICLE_TABLE
import com.tattoshaman.domain.models.Article

@Entity(tableName = ARTICLE_TABLE)
data class ArticleEntity(
    @ColumnInfo(name = ARTICLE_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = ARTICLE_HEADER)
    val header: String,

    @ColumnInfo(name = ARTICLE_TEXT)
    val text: String,

    @ColumnInfo(name = ARTICLE_IMAGE)
    val image: String

){
    companion object {
        const val ARTICLE_TABLE = "articles"
        const val ARTICLE_ID = "id"
        const val ARTICLE_HEADER = "header"
        const val ARTICLE_TEXT = "text"
        const val ARTICLE_IMAGE = "image"
    }
}

fun ArticleEntity.toDomain(): Article{
    return Article(
        id = id,
        header = header,
        text = text,
        image = image
    )
}