package com.tattoshaman.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tattoshaman.data.room.entities.SketchEntity

@Dao
interface SketchDao {

    @Query("SELECT * FROM ${SketchEntity.SKETCH_TABLE}")
    suspend fun getAll(): List<SketchEntity>

    @Query("SELECT * FROM ${SketchEntity.SKETCH_TABLE} WHERE ${SketchEntity.SKETCH_TABLE}.${SketchEntity.SKETCH_ID} = :id")
    suspend fun getSketchById(id: Int): SketchEntity

    @Insert
    suspend fun addSketch(sketch: SketchEntity): Long
}