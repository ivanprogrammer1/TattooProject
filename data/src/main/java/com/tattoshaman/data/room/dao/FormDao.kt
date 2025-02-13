package com.tattoshaman.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.tattoshaman.data.room.entities.FormEntity

@Dao
interface FormDao {

    @Insert(entity = FormEntity::class)
    suspend fun addForm(form: FormEntity)

}