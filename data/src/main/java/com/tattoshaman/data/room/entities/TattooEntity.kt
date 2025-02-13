package com.tattoshaman.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.tattoshaman.data.room.entities.TattooEntity.Companion.TATTOO_CATEGORY
import com.tattoshaman.data.room.entities.TattooEntity.Companion.TATTOO_TABLE
import com.tattoshaman.domain.models.Tattoo

@Entity(
    tableName = TATTOO_TABLE,
    foreignKeys = [
        ForeignKey(
            TattooCategoryEntity::class,
            parentColumns = [TattooCategoryEntity.TATTOO_CATEGORY_ID],
            childColumns = [TATTOO_CATEGORY],
        )
    ]
)
data class TattooEntity(
    @ColumnInfo(name = TATTOO_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = TATTOO_CATEGORY)
    val categoryID: Int,

    @ColumnInfo(name = TATTOO_NAME)
    val name: String,

    @ColumnInfo(name = TATTOO_DESCRIPTION)
    val description: String,

    @ColumnInfo(name = TATTOO_IMAGE)
    val image: String
){
    companion object{
        const val TATTOO_TABLE = "tattoos"
        const val TATTOO_ID = "id"
        const val TATTOO_CATEGORY = "category"
        const val TATTOO_NAME = "name"
        const val TATTOO_DESCRIPTION = "description"
        const val TATTOO_IMAGE = "image"
    }
}

fun TattooEntity.toDomain(): Tattoo{
    return Tattoo(
        id = id,
        categoryID = categoryID,
        name = name,
        description = description,
        image = image
    )
}