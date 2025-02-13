package com.tattoshaman.catalog_impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.catalog_impl.CategoryUI
import com.tattoshaman.catalog_impl.R
import com.tattoshaman.core.ui.theme.BlackoutColor
import com.tattoshaman.core.ui.theme.TattooProjectTheme
import com.tattoshaman.core.ui.theme.space_10

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun CategoryItem(
    category: CategoryUI,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (isSelected) MaterialTheme.colorScheme.surfaceVariant else Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(10.dp)
    ) {
        GlideImage(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop,
            loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
            model = category.image,
            contentDescription = stringResource(R.string.category_contentdescription)
        )

        Spacer(modifier = Modifier.height(space_10))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            maxLines = 1,
            text = category.name,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewCategoryItem() {
    TattooProjectTheme {
        CategoryItem(
            isSelected = true,
            category = CategoryUI(
                1,
                name = "Tristan Wagner eawfawe f fwafwe erggersg fewafwe frafergser ergsg",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJxo2NFiYcR35GzCk5T3nxA7rGlSsXvIfJwg&s"
            )
        ) {}
    }
}