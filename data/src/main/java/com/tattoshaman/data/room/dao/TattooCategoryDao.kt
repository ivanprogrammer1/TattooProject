package com.tattoshaman.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.tattoshaman.data.room.entities.TattooCategoryEntity

@Dao
interface TattooCategoryDao {

    @Query("SELECT * FROM ${TattooCategoryEntity.TATTOO_CATEGORY_TABLE}")
    suspend fun getCategories(): List<TattooCategoryEntity>

    @Query(
        "SELECT * FROM ${TattooCategoryEntity.TATTOO_CATEGORY_TABLE} " +
                "WHERE ${TattooCategoryEntity.TATTOO_CATEGORY_TABLE}.${TattooCategoryEntity.TATTOO_CATEGORY_ID} = :id"
    )
    suspend fun getCategoryById(id: Int): TattooCategoryEntity

}