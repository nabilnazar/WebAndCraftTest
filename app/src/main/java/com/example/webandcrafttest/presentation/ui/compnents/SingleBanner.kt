package com.example.webandcrafttest.presentation.ui.compnents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@Composable
fun SingleBanner(imageUrl: String?) {
    imageUrl?.let {
        AsyncImage(
            model = it,
            contentDescription = "dsds",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(8.dp)
        )
    }
}