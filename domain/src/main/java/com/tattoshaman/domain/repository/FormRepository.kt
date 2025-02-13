package com.tattoshaman.domain.repository

import com.tattoshaman.domain.models.Form

abstract class FormRepository {
    abstract suspend fun sendForm(form: Form): Long
}