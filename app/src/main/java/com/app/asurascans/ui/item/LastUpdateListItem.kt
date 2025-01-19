package com.app.asurascans.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun LastUpdateListItem(modifier: Modifier = Modifier) {
    Box (modifier = Modifier
        .wrapContentSize()
        .padding(10.dp)){
        Box (modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)){
            AsyncImage(model = "https://upload.wikimedia.org/wikipedia/id/4/46/Jujutsu_kaisen.jpg", contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop)

            Box (modifier = Modifier.fillMaxSize().
            background(color = )){ }

        }
    }
}