package com.tattoshaman.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tattoshaman.data.room.dao.ArticleDao
import com.tattoshaman.data.room.dao.FormDao
import com.tattoshaman.data.room.dao.SketchDao
import com.tattoshaman.data.room.dao.TattooCategoryDao
import com.tattoshaman.data.room.dao.TattooDao
import com.tattoshaman.data.room.entities.ArticleEntity
import com.tattoshaman.data.room.entities.FormEntity
import com.tattoshaman.data.room.entities.SketchEntity
import com.tattoshaman.data.room.entities.TattooCategoryEntity
import com.tattoshaman.data.room.entities.TattooEntity

@Database(
    version = 1,
    entities = [
        ArticleEntity::class,
        FormEntity::class,
        SketchEntity::class,
        TattooCategoryEntity::class,
        TattooEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao
    abstract fun getFormDao(): FormDao
    abstract fun getSketchDao(): SketchDao
    abstract fun getTattooCategoryDao(): TattooCategoryDao
    abstract fun getTattooDao(): TattooDao

    companion object {
        const val DATABASE_NAME: String = "tattoo_base.db"

        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .createFromAsset(
                    DATABASE_NAME
                ).build()
        }
    }
}