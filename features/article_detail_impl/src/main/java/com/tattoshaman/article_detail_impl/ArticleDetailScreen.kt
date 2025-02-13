package com.tattoshaman.article_detail_impl

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.theme.space_20
import com.tattoshaman.core.ui.utils.convertByHtml
import com.tattoshaman.core.ui.widgets.ScreenWidget

private const val EMPTY = ""

@Composable
internal fun ArticleDetailScreen(
    state: ArticleDetailState,
) {
    val article = state.article

    ScreenWidget {
        Text(
            text = article?.header ?: EMPTY,
            style = MaterialTheme.typography.headlineMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            ),
        )

        Spacer(modifier = Modifier.height(space_20))

        Text(
            text = article?.text?.convertByHtml() ?: AnnotatedString(""),
            style = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewArticleDetailScreen() {
    TattooProjectTheme {
        ArticleDetailScreen(
            ArticleDetailState(
                ArticleDetailUI(
                    id = 1,
                    header = "Заголовок",
                    text = "<b>Интересный текст</b> fewafe <h3>Как дела?</h3>"
                )
            )
        )
    }
}