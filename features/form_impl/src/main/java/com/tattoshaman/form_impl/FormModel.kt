package com.tattoshaman.form_impl

import java.time.LocalDate

data class FormModel(
    val tattooName: String,
    val contactsPhone: String,
    val date: LocalDate
)