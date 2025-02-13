package com.tattoshaman.sketch_impl.ui

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.tattoshaman.core.ui.theme.ErrorColor
import com.tattoshaman.sketch_impl.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageProvider(
    currentImage: Uri?,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    selectImage: (Uri?) -> Unit,
) {
    val request = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) {
        selectImage(it)
    }

    GlideImage(
        modifier = modifier
            .border(
                2.dp, if (isError) ErrorColor else MaterialTheme.colorScheme.onSurface
            )
            .clickable {
                request.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            },
        model = currentImage,
        contentScale = ContentScale.Crop,
        loading = placeholder(com.tattoshaman.core.R.drawable.common_placeholder),
        contentDescription = stringResource(R.string.select_image_contentdescription)
    )
}