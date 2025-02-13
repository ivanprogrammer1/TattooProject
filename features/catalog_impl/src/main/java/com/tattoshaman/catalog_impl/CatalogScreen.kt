package com.tattoshaman.catalog_impl

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tattoshaman.catalog_impl.ui.CategoryItem
import com.tattoshaman.catalog_impl.ui.TattooItem
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.padding_10
import com.tattoshaman.core.ui.theme.padding_20
import com.tattoshaman.core.ui.theme.space_20
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun CatalogScreen(
    state: CatalogState,
    selectCategory: (CategoryUI) -> Unit,
    selectTattoo: (TattooUI) -> Unit,
) {
    Column(
        modifier = Modifier.padding(
            vertical = padding_20,
        )
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space_20)
        ) {
            items(state.categories) {
                CategoryItem(
                    it,
                    modifier = Modifier.size(100.dp),
                    isSelected = it == state.selectedCategory
                ) {
                    selectCategory(it)
                }
            }
        }

        Spacer(
            modifier = Modifier.height(space_20)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space_20),
            contentPadding = PaddingValues(
                horizontal = padding_20
            )
        ) {
            items(state.tattoos) {
                TattooItem(
                    it,
                    modifier = Modifier.height(200.dp)
                ) {
                    selectTattoo(it)
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewCatalogScreen() {
    TattooProjectTheme {
        CatalogScreen(
            state = CatalogState(
                categories = persistentListOf(
                    CategoryUI(
                        id = 7266,
                        name = "Staci Blackfeafaefergergergersgergfre fweafwaefawe ref e afwfe",
                        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJxo2NFiYcR35GzCk5T3nxA7rGlSsXvIfJwg&s"
                    ),
                    CategoryUI(
                        id = 6600,
                        name = "Jane Greene",
                        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJxo2NFiYcR35GzCk5T3nxA7rGlSsXvIfJwg&s"
                    )
                ),
                tattoos = persistentListOf(
                    TattooUI(id = 9562, categoryID = 7673, name = "Peter Snow", image = "has"),
                    TattooUI(
                        id = 8576,
                        categoryID = 1498,
                        name = "Marquis Schmidt",
                        image = "splendide"
                    )
                )
            ),
            selectCategory = {}
        ) { }
    }
}