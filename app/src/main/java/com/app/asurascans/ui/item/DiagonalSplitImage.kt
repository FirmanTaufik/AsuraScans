package com.app.asurascans.ui.item

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DiagonalSplitImage(
    imageUrl2: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clipToBounds()
    ) {
        // Gambar pertama (bagian kiri bawah)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    clip = true
                    shape = GenericShape { size, _ ->
                        moveTo(0f, 0f)
                        lineTo(size.width, size.height)
                        lineTo(0f, size.height)
                        close()
                    }
                },
        )

        // Gambar kedua (bagian kanan atas)
        AsyncImage(
            model = imageUrl2,
            contentDescription = "Right Image",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    clip = true
                    shape = GenericShape { size, _ ->
                        moveTo(0f, 0f)
                        lineTo(size.width, 0f)
                        lineTo(size.width, size.height)
                        close()
                    }
                },
            contentScale = ContentScale.Crop
        )

     /*   val localDestiny = LocalDensity.current
        // Garis diagonal
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawLine(
                color = Color.Transparent,
                start = Offset(0f, 0f),
                end = Offset(size.width, size.height),
                strokeWidth = with(localDestiny) { 2.dp.toPx() }
            )
        }*/
    }
}