package com.tattoshaman.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tattoshaman.data.room.entities.FormEntity.Companion.FORM_TABLE
import com.tattoshaman.domain.models.Form

@Entity(tableName = FORM_TABLE)
data class FormEntity(
    @ColumnInfo(name = FORM_ID)
    @PrimaryKey(autoGenerate = true)
    val id: Int
){
    companion object{
        const val FORM_TABLE = "forms"
        const val FORM_ID = "id"
    }
}