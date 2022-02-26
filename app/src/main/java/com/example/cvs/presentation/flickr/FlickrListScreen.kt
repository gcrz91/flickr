package com.example.cvs.presentation.flickr

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FlickrListScreen(

) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(20) { healthData ->
            // TODO: replace once dynamic data to display is ready
            FlickrRowItem()
        }
    }
}

@Preview
@Composable
fun FlickrListScreen_Preview() {
    FlickrListScreen()
}