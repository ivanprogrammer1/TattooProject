package com.tattoshaman.domain.models

import java.time.LocalDate

data class Form(
    val tattooName: String,
    val contactsPhone: String,
    val date: LocalDate
)