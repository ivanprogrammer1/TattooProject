package com.tattoshaman.core.ui.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

object DateUtil {
    fun convertMillisToLocalDate(millis: Long): ZonedDateTime {
        val utcDateAtStartOfDay = Instant
            .ofEpochMilli(millis)
            .atZone(ZoneOffset.UTC)
            .toLocalDate()

        val localDate = utcDateAtStartOfDay.atStartOfDay(ZoneId.systemDefault())

        return localDate
    }
}

@OptIn(ExperimentalMaterial3Api::class)
object SelectableRangeCurrentDay : SelectableDates {
    private val currentYear by lazy {
        LocalDate.now().year
    }
    private val currentDateMillis by lazy {
        val currentDate = ZonedDateTime.now(ZoneOffset.UTC)
        currentDate.toInstant().toEpochMilli()
    }

    override fun isSelectableYear(year: Int): Boolean {
        return year >= currentYear
    }

    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
        return utcTimeMillis >= currentDateMillis
    }
}