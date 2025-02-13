package com.tattoshaman.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tattoshaman.data.room.entities.SketchEntity.Companion.SKETCH_TABLE
import com.tattoshaman.domain.forms.SketchInput
import com.tattoshaman.domain.models.Sketch

@Entity(tableName = SKETCH_TABLE)
data class SketchEntity(
    @ColumnInfo(name = SKETCH_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = SKETCH_NAME)
    val name: String,

    @ColumnInfo(name = SKETCH_IMAGE)
    val image: String
){
    companion object{
        const val SKETCH_TABLE = "sketches"
        const val SKETCH_ID = "id"
        const val SKETCH_NAME = "name"
        const val SKETCH_IMAGE = "image"
    }
}

fun SketchEntity.toDomain(): Sketch{
    return Sketch(
        id = id,
        name = name,
        description = "",
        image = image
    )
}

fun SketchInput.toEntity(): SketchEntity{
    return SketchEntity(
        name = name,
        image = image
    )
}