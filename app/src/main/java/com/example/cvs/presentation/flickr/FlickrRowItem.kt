package com.example.cvs.presentation.flickr

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun FlickrRowItem(
    imageUrl: String = "https://asia.olympus-imaging.com/content/000107506.jpg",
    imageDescription: String = "Image Description",
    imageContentDescription: String = "Toucan Sam",
    imageHeight: Dp = 128.dp,
    imageWidth: Dp = 256.dp,
    onClick: () -> Unit = {}
) {
    Column(
        Modifier
            .clickable(onClick = onClick)
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Card(elevation = 4.dp) {
            Column {
                Image(
                    painter = rememberImagePainter(imageUrl),
                    contentDescription = imageContentDescription,
                    modifier = Modifier
                        .height(imageHeight)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Divider()
                Text(
                    text = imageDescription,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview
@Composable
fun FlickrRowItem_Preview() {
    FlickrRowItem()
}