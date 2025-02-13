package com.tattoshaman.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tattoshaman.data.room.entities.TattooCategoryEntity.Companion.TATTOO_CATEGORY_TABLE
import com.tattoshaman.domain.models.TattooCategory

@Entity(tableName = TATTOO_CATEGORY_TABLE)
data class TattooCategoryEntity(
    @ColumnInfo(name = TATTOO_CATEGORY_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = TATTOO_CATEGORY_NAME)
    val name: String,

    @ColumnInfo(name = TATTOO_CATEGORY_IMAGE)
    val image: String
){
    companion object{
        const val TATTOO_CATEGORY_TABLE = "categories"
        const val TATTOO_CATEGORY_ID = "id"
        const val TATTOO_CATEGORY_NAME = "name"
        const val TATTOO_CATEGORY_IMAGE = "image"
    }
}

fun TattooCategoryEntity.toDomain(): TattooCategory{
    return TattooCategory(
        id = id,
        name = name,
        image = image
    )
}