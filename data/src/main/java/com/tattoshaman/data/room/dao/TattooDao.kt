package com.tattoshaman.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.tattoshaman.data.room.entities.TattooEntity

@Dao
interface TattooDao {
    @Query("SELECT * FROM ${TattooEntity.TATTOO_TABLE}")
    suspend fun getAllTattoos(): List<TattooEntity>

    @Query("SELECT * FROM ${TattooEntity.TATTOO_TABLE} " +
            "WHERE ${TattooEntity.TATTOO_CATEGORY} = :categoryId")
    suspend fun getTattoosByCategoryId(categoryId: Int): List<TattooEntity>

    @Query(
        "SELECT * FROM ${TattooEntity.TATTOO_TABLE} " +
                "WHERE ${TattooEntity.TATTOO_TABLE}.${TattooEntity.TATTOO_ID} = :id"
    )
    suspend fun getTattooById(id: Int): TattooEntity
}