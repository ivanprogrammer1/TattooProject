package com.tattoshaman.data.room.storage

import com.tattoshaman.data.room.dao.FormDao
import com.tattoshaman.data.storage.FormStorage
import com.tattoshaman.domain.models.Form

class FormStorageImpl(private val formDao: FormDao): FormStorage {
    override suspend fun sendForm(form: Form) {
        //formDao.addForm(form)
        TODO()
    }
}