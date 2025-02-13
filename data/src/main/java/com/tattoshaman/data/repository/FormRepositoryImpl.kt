package com.tattoshaman.data.repository

import com.tattoshaman.data.storage.FormStorage
import com.tattoshaman.domain.models.Form
import com.tattoshaman.domain.repository.FormRepository

class FormRepositoryImpl(private val formStorage: FormStorage): FormRepository() {
    override suspend fun sendForm(form: Form): Long {
        return 1
    }
}