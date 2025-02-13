package com.tattoshaman.form_impl

import com.tattoshaman.domain.models.Form
import com.tattoshaman.domain.repository.FormRepository

class SendFormUseCase(private val formRepository: FormRepository) {
    suspend fun execute(form: Form): Long {
        return formRepository.sendForm(form)
    }
}