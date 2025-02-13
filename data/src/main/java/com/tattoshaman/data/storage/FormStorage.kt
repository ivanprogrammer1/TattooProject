package com.tattoshaman.data.storage

import com.tattoshaman.domain.models.Form

interface FormStorage {
    abstract suspend fun sendForm(form: Form)
}