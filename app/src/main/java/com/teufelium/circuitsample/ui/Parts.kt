package com.teufelium.circuitsample.ui

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.teufelium.circuitsample.R

@Composable
fun IconImage(
    url: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier
            .clip(CircleShape),
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.Crop,
    )
}