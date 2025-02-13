package com.tattoshaman.core.ui.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.padding_20

/**
 * Общий виджет для экранов. Обладает вертикальным скролом и пагинацией.
 *
 * Параметр [content] - принимает внутренние элементы экрана
 **/
@Composable
fun ScreenWidget(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()).padding(
            vertical = padding_10,
            horizontal = padding_20
        ),
        content = content
    )
}